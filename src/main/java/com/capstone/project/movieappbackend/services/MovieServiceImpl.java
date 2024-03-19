package com.capstone.project.movieappbackend.services;

/*
    * Create a class MovieServiceimpl which implements all the methods in the MovieService
    * autowire  MovieRepository ,RestTemplate
    * create API_URL attribute to get the value from application.properties  API_BASE_URL
    * add appropriate loggers
    */
import com.capstone.project.movieappbackend.model.Movie;
import com.capstone.project.movieappbackend.model.MovieList;
import com.capstone.project.movieappbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MovieServiceImpl implements MovieService {
    private static final Logger LOGGER = Logger.getLogger(MovieServiceImpl.class.getName());
    
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_BASE_URL}")
    private String API_URL;

    @Value("${API_KEY}")
    private String apiKey;

    
    /*
     * Save the movie to the database
     * @param movie
     * @return movie
     */
    @Override
    public Movie saveMovie(Movie movie) {
        LOGGER.info("Saving movie to database");
        return movieRepository.save(movie);
    }

    /*
     * Delete the movie from the database
     * @param id
     * @return string
     */
    @Override
    public String deleteMovie(String id) {
        LOGGER.info("Deleting movie from database");
        movieRepository.deleteById(id);
        return "Movie deleted successfully";
    }

    /*
     * Get the movie from the database
     * @param id
     * @return movie
     */
    @Override
    public Movie getMovieById(String id) {
        LOGGER.info("Fetching movie from database");
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    /*
     * Get all the movies from the database
     * @return list of movies
     */
    @Override
    public List<Movie> getMoviesList() {
        LOGGER.info("Fetching all movies from database");
        return movieRepository.findAll();
    }

    /*
     * Update the movie in the database
     * @param movie
     * @return movie
     */
    @Override
    public Movie updateMovie(Movie movie) {
        LOGGER.info("Updating movie in database");
        return movieRepository.save(movie);
    }

    /*
     * Get all the movies from the API
     * @return list of movies
     */
    @Override
    public MovieList getAllMovies() {
        LOGGER.info("Fetching all movies from API");
        String url = API_URL + apiKey;
        LOGGER.info("Fetching all movies from: " + url);
        MovieList movieList = restTemplate.getForObject(url, MovieList.class);
        return movieList;
        
    }

   
}

