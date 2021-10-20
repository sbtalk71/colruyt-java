package com.demo.jdbc;
import java.sql.*;

public class MetaDataDemo {
    private static final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521:XE" ;
    private static final String USERNAME ="system" ;
    private static final String PASSWORD = "welcome1";

    public static void main(String[] args) {
        String SELECT_QUERY="select * from emp";
        Connection conn=null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn= DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
        DatabaseMetaData dbmd=conn.getMetaData();
            System.out.println(dbmd.getDatabaseProductName()+"-->"+dbmd.getDatabaseProductVersion());
            Statement stmt=conn.createStatement();
            System.out.println(stmt.getClass().getName());
            ResultSet rs=stmt.executeQuery(SELECT_QUERY);

            ResultSetMetaData rsmd=rs.getMetaData();
            System.out.println("Columns :"+rsmd.getColumnCount());
            System.out.println(rsmd.getTableName(3));
            System.out.println(rsmd.getSchemaName(3));
            System.out.println(rsmd.getColumnLabel(4));

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
