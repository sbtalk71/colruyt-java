package com.demo.misc;

public class MySQLDB implements MyConnection{

    @Override
    public void getConnection() {
        System.out.println("Connected to MySQL DB");
    }

    @Override
    public String getDBInfo() {
        return "Version 8.0.1";
    }
}
