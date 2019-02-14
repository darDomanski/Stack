package com.codecool.Stack.Exceptions;

public class StackOverflow extends RuntimeException {

    public StackOverflow() {
    }

    public StackOverflow(String message) {
        super(message);
    }

}
