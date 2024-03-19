package com.capstone.project.movieappbackend.repository;

/*
  * create  DataMongoTest  for testing
  *  As a part  of setup delete all the records from the database
    *  write test case to save movie
    *  write test case to delete movie
    *  write test case to get all movies
    *  write test case to get movie by id
    create  two movie objects with values and save them in the database
    autowire  movieRepository
  */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.capstone.project.movieappbackend.exceptions.MovieAlreadyExistsException;
import com.capstone.project.movieappbackend.exceptions.MovieNotFoundException;
import com.capstone.project.movieappbackend.model.Movie;
import com.capstone.project.movieappbackend.model.MovieList;
import com.capstone.project.movieappbackend.services.MovieService;
import com.capstone.project.movieappbackend.services.MovieServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @Test
    public void testSaveMovie() throws MovieAlreadyExistsException {
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        movieService.saveMovie(movie);
        assertNotNull(movieRepository.findById("1"));
    }

    @Test
    public void testDeleteMovie() throws MovieAlreadyExistsException {
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        movieService.saveMovie(movie);
        movieService.deleteMovie("1");
        assertEquals(false, movieRepository.existsById("1"));
    }

    @Test
    public void testGetAllMovies() throws MovieAlreadyExistsException {
        Movie movie1 = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        Movie movie2 = new Movie("2", 0, "The Godfather", "Drama", "USA", 0, "1972", null, null, null, null, null, null, null);
        movieService.saveMovie(movie1);
        movieService.saveMovie(movie2);
        List<Movie> movies = movieService.getMoviesList();
        assertEquals(2, movies.size());
    }

    @Test
    public void testGetMovieById() throws MovieAlreadyExistsException, MovieNotFoundException {
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        movieService.saveMovie(movie);
        Movie movie1 = movieService.getMovieById("1");
        assertEquals("The Shawshank Redemption", movie1.getTitle());
    }
}




