package com.demo.spring.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class InsertDemoMain implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jt;

    @Override
    public void run(String... args) throws Exception {
        String INSERT_STMT="insert into emp(empno,name,address,salary) values(?,?,?,?)";

       int count= jt.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pst = con.prepareStatement(INSERT_STMT);
                pst.setInt(1,216);
                pst.setString(2,"Dinesh");
                pst.setString(3,"Kanpur");
                pst.setDouble(4,87000);
                return pst;
            }
        });
        System.out.println("Row Inserted : "+count);
    }
}
