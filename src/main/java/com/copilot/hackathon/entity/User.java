package com.copilot.hackathon.entity;

import jakarta.persistence.Enumerated;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseModel {



    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Getters and setters
}