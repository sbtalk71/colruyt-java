package com.demo.util.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmpDatabaseApp {
    public static void main(String[] args) {
        //ArrayList<Emp> empList = new ArrayList<>();
        List<Emp> empList=new ArrayList<>();
        empList.add(new Emp(100, "Shantanu", "Hyderabad", 56000));
        empList.add(new Emp(101, "Karan", "Mumbai", 76000));
        empList.add(new Emp(102, "Suman", "Bangalore", 59000));
        empList.add(new Emp(103, "Shekhar", "Chennai", 96000));
        empList.add(new Emp(104, "Pavan", "Hyderabad", 76000));

        Scanner sc = new Scanner(System.in);
        boolean found=false;
        while (true) {
            System.out.println("Enter Emp Id..");
            int id = sc.nextInt();
            for (Emp e : empList) {
                if (id == e.getEmpId()) {
                  printEmpDetails(e);
                    found=true;

                }else{
                   found=false;
                }
                if(found)
                    break;
                //take the empid from scanner object and print the details of that emp if found
            }
            if(!found)
            System.out.println("Emp Not Found..");

        }
    }

    private static void printEmpDetails(Emp e) {
        System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary());
    }
}
