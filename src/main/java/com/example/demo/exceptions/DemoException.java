package com.example.demo.exceptions;

public class DemoException extends RuntimeException {

    public DemoException(String message) {
        super(message);
    }

    public DemoException(String message, Throwable cause) {
        super(message, cause);
    }
}
