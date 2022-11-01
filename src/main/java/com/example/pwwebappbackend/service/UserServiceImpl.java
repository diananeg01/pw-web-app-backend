package com.example.pwwebappbackend.service;

import com.example.pwwebappbackend.model.User;
import com.example.pwwebappbackend.model.UserRole;
import com.example.pwwebappbackend.repo.UserCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserCrudRepository userCrudRepository;

    public static String encodePassword(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    @Override
    public Optional<User> logIn(String username, String password) {
        Optional<User> user = this.getUserByUsername(username);
        String p = encodePassword(password);
        if(user.isPresent() && user.get().getUsername().equals(username) && user.get().getPassword().equals(p)){
            return user;
        }
        return Optional.empty();
    }

    @Override
    public User register(User newUser) {
        newUser.setPassword(encodePassword(newUser.getPassword()));
        newUser.setUserRole(UserRole.READER);
        return this.userCrudRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        List<User> allUsers = new ArrayList<>();
        this.userCrudRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return this.userCrudRepository.findUserByUsername(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return this.userCrudRepository.findUserByEmail(email);
    }

    @Override
    public void editUser(User newUser, String oldEmail) {
        Optional<User> user = this.userCrudRepository.findUserByEmail(oldEmail);
        if(user.isPresent()){
            User userObj = user.get();
            if (newUser.getUsername() != null) {
                userObj.setUsername(newUser.getUsername());
            }
            if (newUser.getFirstname() != null) {
                userObj.setFirstname(newUser.getFirstname());
            }
            if (newUser.getLastname() != null) {
                userObj.setLastname(newUser.getLastname());
            }
            if (newUser.getUserRole().equals(UserRole.ADMIN) || newUser.getUserRole().equals(UserRole.READER)) {
                userObj.setUserRole(newUser.getUserRole());
            }
            this.userCrudRepository.save(userObj);
        }
    }
}
