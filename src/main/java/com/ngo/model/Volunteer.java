package com.ngo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String location;

    private String date;

    private String status;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    // Default Constructor
    public Volunteer() {
    }

    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // TITLE
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // DESCRIPTION
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // LOCATION
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // DATE
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // STATUS
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // IMAGE
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}