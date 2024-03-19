package com.capstone.project.movieappbackend.exceptions;

// Create EmailIdAlreadyExistsException class that extends Throwable.

public class EmailIdAlreadyExistsException extends Throwable {
    public EmailIdAlreadyExistsException(String message) {
        super(message);
    }
}
