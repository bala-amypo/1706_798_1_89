package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User register(User user);
    User getUser(Long id);
    List<User> getAllUsers();
}
