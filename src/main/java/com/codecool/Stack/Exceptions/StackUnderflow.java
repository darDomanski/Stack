package com.codecool.Stack.Exceptions;

public class StackUnderflow extends RuntimeException {
    public StackUnderflow(String message) {
        super(message);
    }

    public StackUnderflow() {
    }
}
