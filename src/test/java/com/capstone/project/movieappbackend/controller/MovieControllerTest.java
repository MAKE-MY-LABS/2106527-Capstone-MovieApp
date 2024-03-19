package com.capstone.project.movieappbackend.controller;

/*
 *  use @WebMvcTest annotation to test the controller
 * use @Autowired to inject the MockMvc
 * use @MockBean to inject the MovieService
 * create test cases to test all the end points of the MovieController
 *  
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.capstone.project.movieappbackend.exceptions.MovieAlreadyExistsException;
import com.capstone.project.movieappbackend.exceptions.MovieNotFoundException;
import com.capstone.project.movieappbackend.model.Movie;
import com.capstone.project.movieappbackend.model.MovieList;
import com.capstone.project.movieappbackend.services.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @Test
    public void testSaveMovie() throws Exception {
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        when(movieService.saveMovie(movie)).thenReturn(movie);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/save").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteMovie() throws Exception {
        when(movieService.deleteMovie("1")).thenReturn("Movie deleted successfully");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/movie/delete/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetMovieById() throws Exception {
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        when(movieService.getMovieById("1")).thenReturn(movie);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/get/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetMoviesList() throws Exception {
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        movies.add(movie);
        when(movieService.getMoviesList()).thenReturn(movies);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/getAll")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateMovie() throws Exception {
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        when(movieService.updateMovie(movie)).thenReturn(movie);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/movie/update").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAllMovies() throws Exception {
        MovieList movieList = new MovieList();
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie("1", 0, "The Shawshank Redemption", "Drama", "USA", 0, "1994", null, null, null, null, null, null, null);
        movieList.setMovies(movies);
        when(movieService.getAllMovies()).thenReturn(movieList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/getAllMovies")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
    