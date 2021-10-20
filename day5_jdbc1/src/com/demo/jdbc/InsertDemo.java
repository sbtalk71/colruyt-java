package com.demo.jdbc;
import java.sql.*;

public class InsertDemo {
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
            pst.setInt(1,116);
            pst.setString(2,"Chatur");
            pst.setString(3,"Kanpur");
            pst.setDouble(4,45000);

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
