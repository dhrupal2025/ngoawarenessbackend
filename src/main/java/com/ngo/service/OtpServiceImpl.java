package com.ngo.service;

import com.ngo.model.EmailOtp;
import com.ngo.repository.EmailOtpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private EmailOtpRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    // NEW
    @Autowired
    private EmailValidationService emailValidationService;


    // =====================================================
    // SEND OTP
    // =====================================================

    @Override
    public void sendOtp(String email) {

        email = email.trim().toLowerCase();


        // =================================================
        // CHECK WHETHER EMAIL IS REAL / DELIVERABLE
        // =================================================

        boolean emailValid =
                emailValidationService
                        .isEmailDeliverable(email);


        // IMPORTANT:
        // If email is not deliverable,
        // STOP HERE.
        // No OTP is generated.
        // No email is sent.
        if (!emailValid) {

            throw new RuntimeException(
                    "Email address is not valid or deliverable."
            );
        }


        // =================================================
        // GENERATE OTP
        // =================================================

        String otp = String.format(
                "%06d",
                new Random().nextInt(1000000)
        );


        // =================================================
        // SAVE OTP
        // =================================================

        EmailOtp emailOtp = new EmailOtp();

        emailOtp.setEmail(email);
        emailOtp.setOtp(otp);

        emailOtp.setExpiryTime(
                LocalDateTime.now().plusMinutes(5)
        );

        emailOtp.setVerified(false);

        repository.save(emailOtp);


        // =================================================
        // SEND OTP
        // =================================================

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(email);

        message.setSubject(
                "NGO Registration - Email Verification OTP"
        );

        message.setText(
                "Hello,\n\n"
                + "Your NGO registration verification OTP is:\n\n"
                + otp
                + "\n\n"
                + "This OTP is valid for 5 minutes."
                + "\n\n"
                + "Please do not share this OTP with anyone."
                + "\n\n"
                + "Thank you,\n"
                + "NGO Social Awareness Team"
        );


        mailSender.send(message);
    }


    // =====================================================
    // VERIFY OTP
    // =====================================================

    @Override
    public boolean verifyOtp(
            String email,
            String otp) {

        email = email.trim().toLowerCase();
        otp = otp.trim();


        Optional<EmailOtp> result =
                repository
                        .findTopByEmailOrderByIdDesc(email);


        if (result.isEmpty()) {
            return false;
        }


        EmailOtp emailOtp = result.get();


        if (emailOtp.isVerified()) {
            return false;
        }


        if (LocalDateTime.now()
                .isAfter(emailOtp.getExpiryTime())) {

            return false;
        }


        if (!emailOtp.getOtp().equals(otp)) {
            return false;
        }


        emailOtp.setVerified(true);

        repository.save(emailOtp);


        return true;
    }


    // =====================================================
    // CHECK EMAIL VERIFIED
    // =====================================================

    @Override
    public boolean isEmailVerified(
            String email) {

        email = email.trim().toLowerCase();


        Optional<EmailOtp> result =
                repository
                        .findTopByEmailOrderByIdDesc(email);


        if (result.isEmpty()) {
            return false;
        }


        EmailOtp emailOtp = result.get();


        return emailOtp.isVerified();
    }


    // =====================================================
    // REMOVE VERIFICATION
    // =====================================================

    @Override
    public void removeVerification(
            String email) {

        email = email.trim().toLowerCase();


        Optional<EmailOtp> result =
                repository
                        .findTopByEmailOrderByIdDesc(email);


        if (result.isPresent()) {

            repository.delete(result.get());
        }
    }
}