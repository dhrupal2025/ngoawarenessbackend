package com.ngo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "volunteer_applications")
public class VolunteerApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // =========================
    // EVENT / VOLUNTEER IDs
    // =========================

    private Long eventId;

    private Long volunteerId;


    // =========================
    // VOLUNTEER INFORMATION
    // =========================

    private String fullName;

    private String email;

    private String mobile;

    private Integer age;

    private String occupation;


    @Column(length = 500)
    private String address;


    @Column(length = 500)
    private String skills;


    private String availability;


    @Column(length = 1000)
    private String reason;


    // =========================
    // APPLICATION INFORMATION
    // =========================

    private LocalDate applicationDate;

    private String status;


    // =========================
    // VOLUNTEER HOURS
    // =========================

    private Integer hours;


    // =========================
    // CONSTRUCTOR
    // =========================

    public VolunteerApplication() {
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
    // EVENT ID
    // =========================

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }


    // =========================
    // VOLUNTEER ID
    // =========================

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }


    // =========================
    // FULL NAME
    // =========================

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    // =========================
    // EMAIL
    // =========================

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // =========================
    // MOBILE
    // =========================

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    // =========================
    // AGE
    // =========================

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    // =========================
    // OCCUPATION
    // =========================

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    // =========================
    // ADDRESS
    // =========================

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    // =========================
    // SKILLS
    // =========================

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


    // =========================
    // AVAILABILITY
    // =========================

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


    // =========================
    // REASON
    // =========================

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    // =========================
    // APPLICATION DATE
    // =========================

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
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


    // =========================
    // HOURS
    // =========================

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}