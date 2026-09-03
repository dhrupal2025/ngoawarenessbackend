package com.ngo.service;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.stereotype.Service;

@Service
public class EmailValidationServiceImpl
        implements EmailValidationService {

    @Override
    public boolean isEmailDeliverable(String email) {

        try {

            // =========================================
            // CHECK NULL / EMPTY EMAIL
            // =========================================

            if (email == null || email.trim().isEmpty()) {

                return false;
            }

            email = email.trim().toLowerCase();

            // =========================================
            // EMAIL FORMAT CHECK
            // =========================================

            if (!email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

                return false;
            }

            // =========================================
            // GET DOMAIN
            // =========================================

            String domain =
                    email.substring(
                            email.indexOf("@") + 1
                    );

            if (domain.isEmpty()) {

                return false;
            }

            // =========================================
            // BLOCK RESERVED / INVALID DOMAINS
            // =========================================

            if (domain.equals("example.com")
                    || domain.equals("example.org")
                    || domain.equals("example.net")
                    || domain.equals("localhost")) {

                return false;
            }

            // =========================================
            // DNS CONFIGURATION
            // =========================================

            Hashtable<String, String> environment =
                    new Hashtable<>();

            environment.put(
                    Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.dns.DnsContextFactory"
            );

            environment.put(
                    Context.PROVIDER_URL,
                    "dns:"
            );

            // =========================================
            // CREATE DNS CONTEXT
            // =========================================

            DirContext context =
                    new InitialDirContext(environment);

            // =========================================
            // CHECK MX RECORD
            // =========================================

            Attributes attributes =
                    context.getAttributes(
                            domain,
                            new String[]{"MX"}
                    );

            // =========================================
            // MX RECORD FOUND
            // =========================================

            if (attributes.get("MX") != null
                    && attributes.get("MX").size() > 0) {

                System.out.println(
                        "Email domain is valid: "
                                + domain
                );

                System.out.println(
                        "MX record found."
                );

                return true;
            }

            // =========================================
            // NO MX RECORD
            // =========================================

            System.out.println(
                    "No MX record found for: "
                            + domain
            );

            return false;

        } catch (NamingException e) {

            System.out.println(
                    "DNS/MX validation failed: "
                            + e.getMessage()
            );

            return false;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}