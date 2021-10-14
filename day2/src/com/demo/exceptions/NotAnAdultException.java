package com.demo.exceptions;

public class NotAnAdultException extends Exception{

    public NotAnAdultException() {
    }

    public NotAnAdultException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "You are Not an Adult";
    }
}
