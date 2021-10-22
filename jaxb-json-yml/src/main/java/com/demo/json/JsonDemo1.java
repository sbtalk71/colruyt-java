package com.demo.json;

import com.demo.entity.Emp;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class JsonDemo1 {
    public static void main(String[] args) throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        Emp emp = new Emp(100,"Shantanu","Hyderabad",89000);
        mapper.writeValue(System.out,emp);

        mapper.writeValue(new FileOutputStream("emp.json"),emp);

    }
}
