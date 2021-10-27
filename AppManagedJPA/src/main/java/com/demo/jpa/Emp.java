package com.demo.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="EMP")
public class Emp {
    @Id
    @Column(name="EMPNO")
    private int empId;

    private String name;

    @Column(name="ADDRESS")
    private String city;

    @Embedded
    Address address;
    private double salary;

    @ElementCollection()
    @CollectionTable(name="IMAGES",joinColumns = @JoinColumn(name="EMPNO"))
    Set<String> images=new HashSet<>();
    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }



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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return empId+" "+name+" "+city+" "+salary;
    }
}
