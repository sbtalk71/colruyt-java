package com.demo.misc;

import java.util.Optional;

public class ConnectionMainApp {
    public static void main(String[] args) {
       Optional<MyConnection> connOPt= MyConnectionManager.getConnection("mysql");
        if(connOPt.isPresent()) {
            MyConnection conn=connOPt.get();
            conn.getConnection();
            System.out.println(conn.getDBInfo());
        }
    }
}
