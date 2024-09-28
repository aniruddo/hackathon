package com.copilot.hackathon.service;

import com.copilot.hackathon.dto.LoginRequest;
import com.copilot.hackathon.dto.RegisterRequest;
import com.copilot.hackathon.entity.User;

import java.util.Optional;

public interface UserService {

    String login(LoginRequest loginDto);

    Optional<User> getUser();

    User register(RegisterRequest registerDto);
}
