package com.example.pwwebappbackend.repo;

import com.example.pwwebappbackend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<User, String> {
}
