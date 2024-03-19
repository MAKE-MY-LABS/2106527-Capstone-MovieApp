package com.capstone.project.movieappbackend.exceptions;

/*
 * Use @ControllerAdvice annotation to handle the exceptions globally
 * Use @ExceptionHandler annotation to handle the exceptions
 * MovieNotFoundException and MovieAlreadyExistsException
 */

import com.capstone.project.movieappbackend.model.Movie;
// No changes required for this code block.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Movie> handleMovieNotFoundException(MovieNotFoundException ex) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Movie> handleMovieAlreadyExistsException(MovieAlreadyExistsException ex) {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}

