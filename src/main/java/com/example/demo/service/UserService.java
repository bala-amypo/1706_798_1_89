package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    Object login(User user);

    Object register(User user);
}
