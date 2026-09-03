package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ngo.model.Feedback;
import com.ngo.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:5174")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping
    public Feedback saveFeedback(@RequestBody Feedback feedback) {

        return service.saveFeedback(feedback);

    }

    @GetMapping
    public List<Feedback> getAllFeedback() {

        return service.getAllFeedback();

    }

    @GetMapping("/{id}")
    public Feedback getFeedback(@PathVariable Long id) {

        return service.getFeedbackById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {

        service.deleteFeedback(id);

    }

}