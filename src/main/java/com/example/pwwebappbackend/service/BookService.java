package com.example.pwwebappbackend.service;

import com.example.pwwebappbackend.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> getBookById(Long id);
    Optional<List<Book>> getBooksByTitle(String title);
    List<Book> getBooks();
    void addNewBook(Book newBook);
    void editBook(Book newBook, String oldTitle, String oldPublishingHouse);
    void deleteBook(Long id);
}
