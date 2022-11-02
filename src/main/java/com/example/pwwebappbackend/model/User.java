package com.example.pwwebappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "model_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long user_uuid;
    @Column(unique = true)
    private String username;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String password;
    private UserRole userRole;

    @ManyToMany
    @JoinTable(
            name="user_favourite",
            joinColumns = @JoinColumn( name="user_uuid"),
            inverseJoinColumns = @JoinColumn( name="book_uuid")
    )
    @JsonIgnore
    private List<Book> favourite;

    public void addToFavourites(Book book) {
        this.favourite.add(book);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_uuid=" + user_uuid +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
