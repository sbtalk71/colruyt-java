package com.demo.util;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("Amit");
        list.add("Karan");
        list.add("Suman");
        list.add("Kajal");
        list.add("Sanjay");
        list.add("Suman");

        System.out.println(list);
        list.remove(5);
        list.add(5,"Chaman");
        System.out.println(list);
        System.out.println("No of entries : "+list.size());
        System.out.println("Is Suman present? "+list.contains("Suman"));

        //show each name  and its length
        Iterator<String> itr = list.iterator();

        while(itr.hasNext()){
            String name=itr.next();
            System.out.println(name+":"+name.length());
        }

        for(String name:list){
            System.out.println(name+":"+name.length());
        }
    }
}
