package com.demo.util.app;

import java.util.Objects;

public class Emp {
    private int empId;
    private String name;
    private String city;
    private double salary;

    public Emp() {
    }

    public Emp(int empId, String name, String city, double salary) {
        this.empId = empId;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

    public int getEmpId() {
        return this.empId;
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

    @Override
    public String toString() {
        return empId+" "+name+" "+city+" "+salary;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals called..");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return empId == emp.empId;
    }

    @Override
    public int hashCode() {
        System.out.println("Hashcode called..");
        return Objects.hash(empId);
    }
}
