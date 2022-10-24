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
@Table(name = "user_model")
public class User {
    @Id
    @GeneratedValue
    private String uuid;

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private UserRole userRole;
}
