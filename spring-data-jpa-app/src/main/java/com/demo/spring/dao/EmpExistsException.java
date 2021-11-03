package com.demo.spring.dao;

public class EmpExistsException extends Exception {
    private String message="Emp Exists";
    public EmpExistsException() {
    }

    public EmpExistsException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return this.getClass().getName()+": "+message;
    }
}
