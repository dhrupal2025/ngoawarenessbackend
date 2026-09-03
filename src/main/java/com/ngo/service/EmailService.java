package com.ngo.service;

import com.ngo.model.Feedback;

public interface EmailService {

    // Send feedback details to NGO Admin
    void sendFeedbackToAdmin(Feedback feedback);

    // Send thank-you email to customer
    void sendThankYouMail(Feedback feedback);

}