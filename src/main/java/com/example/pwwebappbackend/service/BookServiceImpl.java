package com.example.pwwebappbackend.service;

import com.example.pwwebappbackend.repo.BookCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
    @Autowired
    private final BookCrudRepository bookCrudRepository;
}
