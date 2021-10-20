package com.demo.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    private static final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521:XE" ;
    private static final String USERNAME ="system" ;
    private static final String PASSWORD = "welcome1";

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn= DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
            if(conn!=null){
                System.out.println("Connection Success with "+conn);
            }
        }catch (ClassNotFoundException e){
            System.out.println("Driver Not Found");
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
