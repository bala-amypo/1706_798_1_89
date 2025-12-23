package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        // No JWT generation
        return new AuthResponse(
                null,                // token removed
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
