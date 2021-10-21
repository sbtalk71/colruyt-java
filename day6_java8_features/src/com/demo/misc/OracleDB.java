package com.demo.misc;

public class OracleDB implements MyConnection{

    @Override
    public void getConnection() {

        System.out.println("Connected to Oracle DB");
    }

    @Override
    public String getDBInfo() {
        return "Version 11c"+" ";
    }
}
