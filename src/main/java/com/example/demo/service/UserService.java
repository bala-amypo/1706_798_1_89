package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {

    User register(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
