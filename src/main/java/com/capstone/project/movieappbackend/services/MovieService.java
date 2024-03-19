package com.capstone.project.movieappbackend.services;
/*
* Create interface MovieService with the methods to save, delete, get movie by id, get all movies,
 * update movie, get all movies by genre from API
 * methods may throw appropriate exceptions like
 * MovieNotFoundException, MovieAlreadyExistsException
  */ 
import java.util.List;

import com.capstone.project.movieappbackend.exceptions.MovieAlreadyExistsException;
import com.capstone.project.movieappbackend.exceptions.MovieNotFoundException;
import com.capstone.project.movieappbackend.model.Movie;
import com.capstone.project.movieappbackend.model.MovieList;

public interface MovieService {
    /*
     * Save the movie to the database
     * @param movie
     * @return movie
     * @throws MovieAlreadyExistsException
     */
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

    /*
     * Delete the movie from the database
     * @param id
     * @return string
     */
    public String deleteMovie(String id);

    /*
     * Get the movie from the database by id
     * @param id
     * @return movie
     * @throws MovieNotFoundException
     */
    public Movie getMovieById(String id) throws MovieNotFoundException;

    /*
     * Get the list of movies from the database
     * @return list of movies
     */
    public List<Movie> getMoviesList();

    /*
     * Update the movie in the database
     * @param movie
     * @return movie
     */
    public Movie updateMovie(Movie movie);
    
    /**
     * Retrieves the latest articles from the API.
     *
     * @return a list of the latest articles
     */
    public MovieList getAllMovies();
}