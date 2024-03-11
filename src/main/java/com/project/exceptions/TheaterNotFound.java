package com.project.exceptions;

public class TheaterNotFound extends RuntimeException{
    public TheaterNotFound(String message) {
        super(message);
    }
}
