package com.ngo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ngo.model.Feedback;
import com.ngo.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    // Email address where admin should receive feedback
    private static final String ADMIN_EMAIL = "bitsj2024072708@bitbaroda.com";

    @Override
    public void sendFeedbackToAdmin(Feedback feedback) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(senderEmail);
        message.setTo(ADMIN_EMAIL);

        message.setSubject("New Feedback Received");

        message.setText(
                "New Feedback Received\n\n"
                + "--------------------------------\n"
                + "Name    : " + feedback.getName() + "\n"
                + "Email   : " + feedback.getEmail() + "\n"
                + "Subject : " + feedback.getSubject() + "\n"
                + "Rating  : " + feedback.getRating() + "/5\n\n"
                + "Message:\n"
                + feedback.getMessage()
        );

        mailSender.send(message);
    }

    @Override
    public void sendThankYouMail(Feedback feedback) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(senderEmail);
        message.setTo(feedback.getEmail());

        message.setSubject("Thank You For Your Feedback");

        message.setText(
                "Dear " + feedback.getName() + ",\n\n"
                + "Thank you for your valuable feedback.\n\n"
                + "We appreciate your suggestions and support.\n\n"
                + "Your feedback helps us improve our NGO services.\n\n"
                + "Regards,\n"
                + "NGO Social Awareness Team"
        );

        mailSender.send(message);
    }

}