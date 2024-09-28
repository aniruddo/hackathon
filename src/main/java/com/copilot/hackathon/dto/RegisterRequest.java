package com.copilot.hackathon.dto;

import com.copilot.hackathon.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private Set<Role> roles;
}
