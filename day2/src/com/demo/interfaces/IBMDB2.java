package com.demo.interfaces;

public class IBMDB2 implements MyNewConnection{

    @Override
    public void getConnection() {

        System.out.println("Connected to Oracle DB");
    }

    @Override
    public String getDBInfo() {
        return "Version 11c"+" ";
    }


    @Override
    public String getDBVendorInfo() {
        return "IBM";
    }
}
