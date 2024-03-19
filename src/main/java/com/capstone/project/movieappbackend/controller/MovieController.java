package com.capstone.project.movieappbackend.controller;


import com.capstone.project.movieappbackend.exceptions.MovieAlreadyExistsException;
import com.capstone.project.movieappbackend.exceptions.MovieNotFoundException;

/*
 * Use @Autowired to inject the MovieService
    create methods to save, delete, get movie by id, get all movies
    update movie, get all movies by genre, get all movies by country from API
     use appropriate annotations to handle the exceptions ,don't use try catch block
     use /api/v1/movie as the base URI
    use appropriate loggers
 */

import com.capstone.project.movieappbackend.model.Movie;
import com.capstone.project.movieappbackend.model.MovieList;
import com.capstone.project.movieappbackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/save")
    public Movie saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        return movieService.saveMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        return movieService.deleteMovie(id);
    }

    @GetMapping("/get/{id}")
    public Movie getMovieById(@PathVariable String id) throws MovieNotFoundException {
        return movieService.getMovieById(id);
    }

    @GetMapping("/getAll")
    public List<Movie> getMoviesList() {
        return movieService.getMoviesList();
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @GetMapping("/getAllMovies")
    public MovieList getAllMovies() {
        return movieService.getAllMovies();
    }
    
}

