package com.demo.spring.exceptions;

public class EmpExistsException extends Exception {
    private String message="Emp Not Found";

    public EmpExistsException() {

    }

    public EmpExistsException(String s) {
        super(s);
        this.message = s;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+" : "+this.message;
    }
}
