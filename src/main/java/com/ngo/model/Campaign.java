package com.ngo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String image;

    private String category;

    private Double targetAmount;

    private Double collectedAmount = 0.0;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    public Campaign() {
    }

    // =========================
    // ID
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // =========================
    // TITLE
    // =========================

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // =========================
    // DESCRIPTION
    // =========================

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // =========================
    // IMAGE
    // =========================

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // =========================
    // CATEGORY
    // =========================

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // =========================
    // TARGET AMOUNT
    // =========================

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    // =========================
    // COLLECTED AMOUNT
    // =========================

    public Double getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Double collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    // =========================
    // START DATE
    // =========================

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // =========================
    // END DATE
    // =========================

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // =========================
    // STATUS
    // =========================

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}