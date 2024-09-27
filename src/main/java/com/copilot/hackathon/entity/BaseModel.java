package com.copilot.hackathon.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import jakarta.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        lastUpdated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }

    // Getters and setters
}