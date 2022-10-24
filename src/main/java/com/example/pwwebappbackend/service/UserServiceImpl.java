package com.example.pwwebappbackend.service;

import com.example.pwwebappbackend.repo.UserCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserCrudRepository userCrudRepository;
}
