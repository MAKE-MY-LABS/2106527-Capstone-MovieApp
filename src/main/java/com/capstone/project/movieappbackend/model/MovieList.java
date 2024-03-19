package com.capstone.project.movieappbackend.model;
/*
 * Create MovieList class of type List<Movie>
 */

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieList {
    private List<Movie> movies;
}

