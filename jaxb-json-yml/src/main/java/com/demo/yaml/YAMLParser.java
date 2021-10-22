package com.demo.yaml;

import com.demo.entity.Emp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class YAMLParser {
    public static void main(String[] args) throws Exception{
        ObjectMapper ymlMapper=new ObjectMapper(new YAMLFactory());
        Emp e=ymlMapper.readValue(new File("application.yml"), Emp.class);
        System.out.println(e);
    }
}
