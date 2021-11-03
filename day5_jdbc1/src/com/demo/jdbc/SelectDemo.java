package com.demo.jdbc;
import java.sql.*;

public class SelectDemo {
    private static final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521:XE" ;
    private static final String USERNAME ="system" ;
    private static final String PASSWORD = "welcome1";

    public static void main(String[] args) {
        String SELECT_QUERY="select * from emp";
        Connection conn=null;

        try {
           Class.forName("oracle.jdbc.OracleDriver");
            conn= DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);

            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(SELECT_QUERY);
            while(rs.next()){
                System.out.println(rs.getInt("EMPNO")+" "+rs.getString("NAME")+" "+rs.getString("ADDRESS")+" "+rs.getDouble("SALARY"));
            }

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
