package com.demo.spring.dao;

public class EmpNotFoundException extends Exception {
   private String message="Emp Not Found";
    public EmpNotFoundException() {
    }

    public EmpNotFoundException(String s) {
        super(s);
        this.message=s;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+":"+message;
    }
}
