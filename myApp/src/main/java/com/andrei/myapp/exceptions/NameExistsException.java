package com.andrei.myapp.exceptions;

public class NameExistsException extends RuntimeException {
    public NameExistsException(final String message) {
        super(message);
    }
}
