package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public UserInfo getUserInfo(String username) {
        String sql = "SELECT u.username name, u.password pass, a.authority role FROM " +
                "users u INNER JOIN authorities a on u.username=a.username WHERE " +
                "u.enabled =1 and u.username = ?";
        UserInfo userInfo = (UserInfo) jdbcTemplate.queryForObject(sql, new Object[]{username},
                new RowMapper<UserInfo>() {
                    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserInfo user = new UserInfo();
                        user.setUsername(rs.getString("name"));
                        user.setPassword(encoder.encode(rs.getString("pass")));
                        user.setRole(rs.getString("role"));
                        return user;
                    }
                });
        return userInfo;
    }
} 