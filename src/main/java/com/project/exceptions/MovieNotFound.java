package com.project.exceptions;

public class MovieNotFound extends RuntimeException{
    public MovieNotFound(String message) {
        super(message);
    }
}
