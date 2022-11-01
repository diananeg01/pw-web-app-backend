package com.example.pwwebappbackend.controller;

import com.example.pwwebappbackend.model.Book;
import com.example.pwwebappbackend.model.User;
import com.example.pwwebappbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<User> register(@RequestBody User newUser) {
        User user = this.userService.register(newUser);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(path = "/log-in")
    public ResponseEntity<User> logIn(@RequestParam String username, @RequestParam String password){
        Optional<User> user = this.userService.logIn(username, password);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<>(this.userService.getUserByUsername(username).get(), HttpStatus.OK);
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(this.userService.getUserByEmail(email).get(), HttpStatus.OK);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Book> editUser(@RequestBody User newUser, @RequestParam String oldEmail){
        this.userService.editUser(newUser, oldEmail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "user/{username}/add-favourites")
    public ResponseEntity<?> addFavourite(@PathVariable String username, @RequestBody Book book){
        userService.addFavourite(username, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "user/{username}/favourites")
    public ResponseEntity<List<Book>> getFavourite(@PathVariable String username){
        return new ResponseEntity<>(userService.getFavourite(username), HttpStatus.OK);
    }
}
