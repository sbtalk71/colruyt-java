package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateDemo {
    private static final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521:XE" ;
    private static final String USERNAME ="system" ;
    private static final String PASSWORD = "welcome1";

    public static void main(String[] args) {
        String INSERT_STMT="insert into emp(empno,name,address,salary) values(?,?,?,?)";
        Connection conn=null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn= DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);

            PreparedStatement pst=conn.prepareStatement(INSERT_STMT);
            System.out.println(pst.getClass().getName());
            pst.setInt(1,200);
            pst.setString(2,"Dalveer");
            pst.setString(3,"Chandigarh");
            pst.setDouble(4,45000);
            pst.addBatch();

            pst.setInt(1,201);
            pst.setString(2,"Naveen");
            pst.setString(3,"Noida");
            pst.setDouble(4,65000);
            pst.addBatch();

            pst.setInt(1,202);
            pst.setString(2,"Chandra");
            pst.setString(3,"Hyderabad");
            pst.setDouble(4,75000);
            pst.addBatch();

            conn.setAutoCommit(false);

            int[] count=pst.executeBatch();
            conn.commit();

            System.out.println("Rows Updated : "+count.length);

        }catch (ClassNotFoundException e){
            System.out.println("Driver Not Found");
            e.printStackTrace();
        }catch (SQLException e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                conn.setAutoCommit(true);
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
