package com.demo.json;

import com.demo.entity.Emp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class JosnToEmp {
    public static void main(String[] args) throws Exception{
        ObjectMapper mapper= new ObjectMapper();
        List<Emp> empList=new ArrayList<>();
        empList.add(new Emp(100,"Shantanu","Hyderabad",69000));
        empList.add(new Emp(101,"Ranga","Hyderabad",79000));
        empList.add(new Emp(102,"Pavan","Bangalore",89000));
        empList.add(new Emp(103,"Raja","Chennai",99000));

        mapper.writeValue(System.out, empList);
        mapper.writeValue(new FileOutputStream("empList.json"),empList);


    }
}
