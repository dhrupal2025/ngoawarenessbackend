
package com.ngo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String date;

    private String location;

    // =====================================================
    // IMAGE
    // =====================================================

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    private String imageType;


    // =====================================================
    // DEFAULT CONSTRUCTOR
    // =====================================================

    public Event() {
    }


    // =====================================================
    // ID
    // =====================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // =====================================================
    // TITLE
    // =====================================================

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    // =====================================================
    // DATE
    // =====================================================

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    // =====================================================
    // LOCATION
    // =====================================================

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    // =====================================================
    // IMAGE
    // =====================================================

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    // =====================================================
    // IMAGE TYPE
    // =====================================================

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}

