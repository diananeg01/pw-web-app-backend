package com.example.pwwebappbackend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "book_model")
public class Book {
    @Id
    @GeneratedValue
    private String uuid;

    private String title;
    private String author;
    private String publishingHouse;
    private String description;
    private String category;
    private Double price;
}
