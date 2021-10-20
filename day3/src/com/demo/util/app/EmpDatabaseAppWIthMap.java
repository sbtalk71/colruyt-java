package com.demo.util.app;

import java.util.*;

public class EmpDatabaseAppWIthMap {
    public static void main(String[] args) {
        HashMap<Integer,Emp> empDB=new HashMap<>();
       // Hashtable<Integer,Emp> empDB=new Hashtable<>();
        empDB.put(100,new Emp(100, "Shantanu", "Hyderabad", 56000));
        empDB.put(101,new Emp(101, "Karan", "Mumbai", 76000));
        empDB.put(102,new Emp(102, "Suman", "Bangalore", 59000));
        empDB.put(103,new Emp(103, "Shekhar", "Chennai", 96000));
        empDB.put(104,new Emp(104, "Pavan", "Hyderabad", 76000));


        int id=103;
        if(empDB.containsKey(id)) {
            printEmpDetails(empDB.get(id));
        }


    }

    private static void printEmpDetails(Emp e) {
        System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary());
    }
}
