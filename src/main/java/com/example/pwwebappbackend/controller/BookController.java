package com.example.pwwebappbackend.controller;

import com.example.pwwebappbackend.model.Book;
import com.example.pwwebappbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Book> getBookByUuid(@PathVariable() Long id){
        return new ResponseEntity<>(this.bookService.getBookById(id).get(), HttpStatus.OK);
    }

    @GetMapping(path = "/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable() String title){
        return new ResponseEntity<>(this.bookService.getBooksByTitle(title).get(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(this.bookService.getBooks(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Book> addNewBook(@RequestBody Book newBook) {
        this.bookService.addNewBook(newBook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Book> editBook(@RequestBody Book newBook, @RequestParam String oldTitle, @RequestParam String oldPublishingHouse){
        this.bookService.editBook(newBook, oldTitle, oldPublishingHouse);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
