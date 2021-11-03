package com.demo.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="MYEMP")
public class Emp {
    @Id
    @Column(name="EMPNO")
    private int empId;

    @Column(name="NAME")
    private String name;

    @Column(name="ADDRESS")
    private String city;

    @Column(name="SALARY")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "DNO")
    private Dept dept;

    public Emp() {
    }

    public Emp(int empId, String name, String city, double salary) {
        this.empId = empId;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return empId+" "+name+" "+city+" "+salary;
    }
}
