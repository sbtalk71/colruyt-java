package com.demo.spring.controllers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="USERNAME")
    private String userName;
    private String password;

    public User() {
        System.out.println("User Object created..");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println("Setter called with userName "+userName);
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Setter called with password "+password);
        this.password = password;
    }
}
