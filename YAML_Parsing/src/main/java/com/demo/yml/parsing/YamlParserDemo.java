package com.demo.yml.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class YamlParserDemo {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File("application.yml");
        Emp emp = (Emp)mapper.readValue(file,Emp.class);

        System.out.println(emp);
    }
}
