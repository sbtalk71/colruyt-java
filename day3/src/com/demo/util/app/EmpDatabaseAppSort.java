package com.demo.util.app;

import java.util.*;

public class EmpDatabaseAppSort {
    public static void main(String[] args) {
        //ArrayList<Emp> empList = new ArrayList<>();
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(100, "Shantanu", "Hyderabad", 56000));
        empList.add(new Emp(101, "Karan", "Mumbai", 76000));
        empList.add(new Emp(102, "Suman", "Bangalore", 59000));
        empList.add(new Emp(103, "Shekhar", "Chennai", 96000));
        empList.add(new Emp(104, "Pavan", "Hyderabad", 76000));

        System.out.println(empList);

        Collections.sort(empList, new Comparator<Emp>() {
            @Override
            public int compare(Emp e1, Emp e2) {
                System.out.println("Compare called...");
               // return e2.getEmpId()-e1.getEmpId();
                Double d = new Double(e2.getSalary()-e1.getSalary());
                return d.intValue();
            }
        });
        System.out.println(empList);
    }
}
