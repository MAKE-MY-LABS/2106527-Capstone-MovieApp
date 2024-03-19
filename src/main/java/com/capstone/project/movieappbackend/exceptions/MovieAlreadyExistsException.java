package com.capstone.project.movieappbackend.exceptions;

/*
 * Create a custom exception class MovieAlreadyExistsException which extends Exception
 */

public class MovieAlreadyExistsException extends Exception {
    public MovieAlreadyExistsException(String message) {
        super(message);
    }
}
