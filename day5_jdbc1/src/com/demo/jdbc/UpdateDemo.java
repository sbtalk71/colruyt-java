package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {
    private static final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521:XE" ;
    private static final String USERNAME ="system" ;
    private static final String PASSWORD = "welcome1";

    public static void main(String[] args) {
        String UPDATE_STMT="update emp set name=?,address=?,salary=? where empno=?";
        Connection conn=null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn= DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);

            PreparedStatement pst=conn.prepareStatement(UPDATE_STMT);

            pst.setString(1,"Pramod");
            pst.setString(2,"Mumbai");
            pst.setDouble(3,95000);
            pst.setInt(4,110);

            int count=pst.executeUpdate();

            System.out.println("Rows Updated : "+count);

        }catch (ClassNotFoundException e){
            System.out.println("Driver Not Found");
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
