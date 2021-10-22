package com.demo.json;

import com.demo.entity.Emp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class ReadJSONFIleToList {
    public static void main(String[] args) throws Exception{
        ObjectMapper mapper= new ObjectMapper();
        List<Emp> empList= mapper.readValue(new File("empList.json"), new TypeReference<List<Emp>>() {});
        empList.stream().forEach(System.out::println);
    }
}
