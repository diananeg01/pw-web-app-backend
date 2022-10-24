package com.example.pwwebappbackend.repo;

import com.example.pwwebappbackend.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCrudRepository extends CrudRepository<Book, String> {
}
