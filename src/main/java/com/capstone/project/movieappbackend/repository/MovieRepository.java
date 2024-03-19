package com.capstone.project.movieappbackend.repository;

/*
 * Create movie repository interface that extends the MongoRepository interface
 * Add @Repository annotation
 */

import com.capstone.project.movieappbackend.model.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    
}

