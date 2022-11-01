package com.example.pwwebappbackend.service;

import com.example.pwwebappbackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> logIn(String username, String password);
    User register(User newUser);
    List<User> getUsers();
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    void editUser(User newUser, String oldEmail);
}
