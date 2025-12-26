package com.example.demo.security;

import com.example.demo.model.User;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey123";
    private static final long EXPIRATION = 86400000;

    /* ===== METHOD USED BY CONTROLLERS ===== */
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /* ===== METHOD REQUIRED BY TESTS ===== */
    public String generateToken(UserDetails userDetails, User user) {
        return generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }

    /* ===== TOKEN VALIDATION ===== */
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /* ===== METHOD REQUIRED BY TESTS ===== */
    public boolean validateToken(String token, UserDetails userDetails) {
        return validateToken(token);
    }
}
