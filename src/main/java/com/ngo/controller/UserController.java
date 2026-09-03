package com.ngo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.model.RegisterUser;
import com.ngo.service.EmailValidationService;
import com.ngo.service.OtpService;
import com.ngo.service.RegisterUserService;

@RestController
@RequestMapping("/api/registeruser")
@CrossOrigin(origins = "http://localhost:5174")
public class UserController {

    @Autowired
    private RegisterUserService registerUserService;

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailValidationService emailValidationService;
    // =====================================================
    // REGISTER USER
    // =====================================================

    @PostMapping
    public ResponseEntity<?> registerUser(
            @RequestBody RegisterUser user) {

        // Validate fields
        if (user.getName() == null ||
            user.getName().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Name is required");
        }

        if (user.getEmail() == null ||
            user.getEmail().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Email is required");
        }

        if (user.getMobile() == null ||
            user.getMobile().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Mobile number is required");
        }

        if (user.getPassword() == null ||
            user.getPassword().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Password is required");
        }


        // Normalize email
        String email = user.getEmail()
                .trim()
                .toLowerCase();

        user.setEmail(email);


        // ==========================================
        // EMAIL MUST BE OTP VERIFIED
        // ==========================================

        if (!otpService.isEmailVerified(email)) {

            return ResponseEntity.badRequest()
                    .body(
                        "Email address is not real or not verified. Please verify OTP first."
                    );
        }


        // ==========================================
        // CHECK DUPLICATE EMAIL
        // ==========================================

        if (registerUserService.emailExists(email)) {

            return ResponseEntity.badRequest()
                    .body(
                        "This email is already registered."
                    );
        }


        // ==========================================
        // SAVE USER IN MYSQL
        // ==========================================

        try {

            RegisterUser savedUser =
                    registerUserService.saveUser(user);

            // Remove OTP verification
            otpService.removeVerification(email);

            return ResponseEntity.ok(
                    "Registration Successful!"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest()
                    .body(
                        "Registration failed."
                    );
        }
    }

    // =====================================================
    // GET ALL USERS
    // =====================================================

    @GetMapping
    public ResponseEntity<List<RegisterUser>> getAllUsers() {

        List<RegisterUser> users =
                registerUserService.getAllUsers();

        return ResponseEntity.ok(users);
    }


    // =====================================================
    // GET USER BY ID
    // =====================================================

    @GetMapping("/{id}")
    public ResponseEntity<RegisterUser> getUserById(
            @PathVariable Long id) {

        RegisterUser user =
                registerUserService.getUserById(id);

        return ResponseEntity.ok(user);
    }


    // =====================================================
    // UPDATE USER
    // =====================================================

    @PutMapping("/{id}")
    public ResponseEntity<RegisterUser> updateUser(
            @PathVariable Long id,
            @RequestBody RegisterUser user) {

        RegisterUser updatedUser =
                registerUserService.updateUser(id, user);

        return ResponseEntity.ok(updatedUser);
    }


    // =====================================================
    // DELETE USER
    // =====================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Long id) {

        registerUserService.deleteUser(id);

        return ResponseEntity.ok(
                "User Deleted Successfully"
        );
    }


    // =====================================================
    // LOGIN
    // =====================================================

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody RegisterUser user) {

        RegisterUser loginUser =
                registerUserService.loginUser(
                        user.getEmail(),
                        user.getPassword()
                );

        if (loginUser != null) {

            Map<String, Object> response =
                    new HashMap<>();

            response.put(
                    "message",
                    "Login Successful"
            );

            response.put(
                    "email",
                    loginUser.getEmail()
            );


            if (loginUser.getEmail()
                    .equalsIgnoreCase("admin@ngo.com")) {

                response.put(
                        "type",
                        "admin@ngo.com"
                );

            } else {

                response.put(
                        "type",
                        "USER"
                );
            }

            return ResponseEntity.ok(response);

        } else {

            return ResponseEntity.badRequest()
                    .body(
                        "Invalid Email or Password"
                    );
        }
    }


    // =====================================================
    // SEND OTP
    // =====================================================

 // =====================================================
 // SEND OTP
 // =====================================================

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(
            @RequestBody Map<String, String> request) {

        String email = request.get("email");

        if (email == null || email.trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Email is required.");
        }

        email = email.trim().toLowerCase();


        // Email format
        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            return ResponseEntity.badRequest()
                    .body("Email is not real. OTP is not sent.");
        }


        // Email/domain validation
        boolean validEmail =
                emailValidationService.isEmailDeliverable(email);

        if (!validEmail) {

            return ResponseEntity.badRequest()
                    .body("Email is not real. OTP is not sent.");
        }


        // Send OTP
        try {

            otpService.sendOtp(email);

            return ResponseEntity.ok(
                    "OTP sent successfully."
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest()
                    .body(
                        "Email is not real. OTP is not sent."
                    );
        }
    }
    // =====================================================
    // VERIFY OTP
    // =====================================================

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(
            @RequestBody Map<String, String> request) {

        String email =
                request.get("email");

        String otp =
                request.get("otp");


        if (email == null ||
            email.trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Email is required");
        }


        if (otp == null ||
            otp.trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("OTP is required");
        }


        email =
                email.trim().toLowerCase();

        otp =
                otp.trim();


        boolean verified =
                otpService.verifyOtp(
                        email,
                        otp
                );


        if (!verified) {

            return ResponseEntity.badRequest()
                    .body(
                        "Invalid or expired OTP"
                    );
        }


        return ResponseEntity.ok(
                "Email verified successfully"
        );
    }
}