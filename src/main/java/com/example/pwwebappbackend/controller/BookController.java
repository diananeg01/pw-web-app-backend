package com.example.pwwebappbackend.controller;

import com.example.pwwebappbackend.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private final BookService bookService;
}
