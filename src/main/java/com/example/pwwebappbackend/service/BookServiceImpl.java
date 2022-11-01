package com.example.pwwebappbackend.service;

import com.example.pwwebappbackend.model.Book;
import com.example.pwwebappbackend.repo.BookCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
    @Autowired
    private final BookCrudRepository bookCrudRepository;

    @Override
    public Optional<Book> getBookById(Long id) {
        return this.bookCrudRepository.findById(id);
    }

    @Override
    public Optional<List<Book>> getBooksByTitle(String title){
        return this.bookCrudRepository.findBooksByTitle(title);
    }

    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<>();
        this.bookCrudRepository.findAll().forEach(allBooks::add);
        return allBooks;
    }

    @Override
    public void addNewBook(Book newBook) {
        this.bookCrudRepository.save(newBook);
    }

    @Override
    public void editBook(Book newBook, String oldTitle, String oldPublishingHouse) {
        Optional<Book> book = this.bookCrudRepository.findBookByTitleAndPublishingHouse(oldTitle, oldPublishingHouse);
        if(book.isPresent()) {
            Book bookObj = book.get();
            bookObj.setTitle(newBook.getTitle());
            bookObj.setAuthor(newBook.getAuthor());
            bookObj.setPublishingHouse(newBook.getPublishingHouse());
            bookObj.setDescription(newBook.getDescription());
            bookObj.setCategory(newBook.getCategory());
            bookObj.setCover(newBook.getCover());
            this.bookCrudRepository.save(bookObj);
        }
    }
}
