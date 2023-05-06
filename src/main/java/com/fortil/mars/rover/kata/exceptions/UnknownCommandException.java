package com.fortil.mars.rover.kata.exceptions;

public class UnknownCommandException extends Exception {
    public UnknownCommandException(String message){
        super(message);
    }
}
