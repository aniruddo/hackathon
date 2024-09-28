package com.copilot.hackathon.service;

import com.copilot.hackathon.dto.LoginRequest;
import com.copilot.hackathon.dto.RegisterRequest;
import com.copilot.hackathon.entity.User;
import com.copilot.hackathon.repository.UserRepository;
import com.copilot.hackathon.util.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    public String login(LoginRequest loginDto) {
        final Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
        return jwtTokenService.generateToken(user.get().getEmail(), user.get().getRoles());
    }

    @Override
    public Optional<User> getUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userDetails.getUsername());
    }

    @Override
    public User register(RegisterRequest registerDto) {
        if(userRepository.existsByEmail(registerDto.getEmail())) {
            throw new IllegalArgumentException("User with email " + registerDto.getEmail() + " already exists");
        }
        User newUser = new User();
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(bcryptEncoder.encode(registerDto.getPassword()));
        return userRepository.save(newUser);
    }
}
