package com.demo.util.app;

import java.util.*;

public class EmpDataWIthEquality {
    public static void main(String[] args) {

        Set<Emp> empList = new HashSet<>();
        empList.add(new Emp(100, "Shantanu", "Hyderabad", 56000));
        empList.add(new Emp(101, "Karan", "Mumbai", 76000));
        empList.add(new Emp(102, "Suman", "Bangalore", 59000));
        empList.add(new Emp(104, "Pavan", "Hyderabad", 76000));
        empList.add(new Emp(103, "Shekhar", "Chennai", 96000));
        empList.add(new Emp(104, "Pavan", "Hyderabad", 76000));

        System.out.println(empList);


        //System.out.println(empList);
    }
}
