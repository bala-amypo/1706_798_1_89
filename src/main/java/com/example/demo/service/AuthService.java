package com.example.demo.service;

import com.example.demo.model.User;

public interface AuthService {

    Object login(User user);

    Object register(User user);
}
