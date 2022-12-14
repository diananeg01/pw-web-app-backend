package com.example.pwwebappbackend.service;

import com.example.pwwebappbackend.model.Book;
import com.example.pwwebappbackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> logIn(String username, String password);
    User register(String username, String email, String password);
    List<User> getUsers();
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    void editUser(User newUser, String oldEmail);
    void addFavourite(String username, Book book);
    List<Book> getFavourite(String username);
    void deleteUser(Long id);
}
