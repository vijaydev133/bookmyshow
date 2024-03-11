package com.project.exceptions;

public class SeatNotAvailable extends RuntimeException{
    public SeatNotAvailable(String message) {
        super(message);
    }
}
