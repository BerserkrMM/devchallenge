package com.example.devchallenge.exception;

public class CellNotFoundException extends RuntimeException{

    public CellNotFoundException() {
        super();
    }

    public CellNotFoundException(String message) {
        super(message);
    }

    public CellNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CellNotFoundException(Throwable cause) {
        super(cause);
    }

}
