package com.demo.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        //HashSet<String> nameSet=new HashSet<>();
        TreeSet<String> nameSet=new TreeSet<>();
        nameSet.add("Amit");
        nameSet.add("Karan");
        nameSet.add("Suman");
        nameSet.add("Kajal");
        nameSet.add("Sanjay");
        nameSet.add("Suman");

        //nameSet.remove(5);
        //nameSet.add(5,"Chaman");
        System.out.println(nameSet);
        System.out.println("No of entries : "+nameSet.size());
        System.out.println("Is Suman present? "+nameSet.contains("Suman"));
        System.out.println(nameSet);


        Iterator<String> itr = nameSet.iterator();

        while(itr.hasNext()){
            String name=itr.next();
            System.out.println(name+":"+name.length());
        }

        for(String name:nameSet){
            System.out.println(name+":"+name.length());
        }
    }
}
