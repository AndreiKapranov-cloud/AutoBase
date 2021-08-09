package com.andrei.myapp.exceptions;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(final String message){
        super(message);
    }
}
