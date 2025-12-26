package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.model.User;

public class JwtUtil {

    public String generateToken(UserDetails userDetails, User user) {
        return "token";
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}
