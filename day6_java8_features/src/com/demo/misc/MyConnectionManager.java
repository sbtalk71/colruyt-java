package com.demo.misc;

import java.util.Optional;

public class MyConnectionManager {

    public static Optional<MyConnection> getConnection(String dbType){
        if(dbType.equals("oracle")){
            OracleDB db=new OracleDB();
            return Optional.of(db);
        }else if(dbType.equals("mysql")){
           return Optional.of(new MySQLDB());
        }else{
            return Optional.empty();
        }
    }
}
