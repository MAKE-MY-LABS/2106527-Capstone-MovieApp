package com.capstone.project.movieappbackend.repository;

import java.util.Optional;

import com.capstone.project.movieappbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    // add method to to check email and password and return optional of user
    public Optional<User> findByEmailIdAndPassword(String emailId, String password);
}


