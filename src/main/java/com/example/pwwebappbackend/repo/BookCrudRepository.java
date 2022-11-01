package com.example.pwwebappbackend.repo;

import com.example.pwwebappbackend.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookCrudRepository extends CrudRepository<Book, Long> {
    Optional<List<Book>> findBooksByTitle(String title);
    Optional<Book> findBookByTitleAndPublishingHouse(String title, String publishingHouse);
}
