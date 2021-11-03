package com.demo.spring.clients;

import com.demo.spring.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SelectDemoWIthEmp implements CommandLineRunner {
    @Autowired
    JdbcTemplate jt;

    @Override
    public void run(String... args) throws Exception {
        /*jt.query("select * from emp", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getInt("EMPNO")+" "+rs.getString("NAME")+" "+
                        rs.getString("ADDRESS")+" "+rs.getDouble("SALARY"));
            }
        });*/

       List<Emp> empList= jt.query("select * from emp", new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),
                        rs.getString("ADDRESS"),rs.getDouble("SALARY"));
            }
        });

      empList.stream().forEach(e->System.out.println(e.getEmpId()+" "+e.getName()));


        Emp emp1= jt.queryForObject("select * from emp where empno="+104, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),
                        rs.getString("ADDRESS"),rs.getDouble("SALARY"));
            }
        });
        System.out.println(emp1);
    }
}
