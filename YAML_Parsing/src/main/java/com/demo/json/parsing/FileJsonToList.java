package com.demo.json.parsing;

import com.demo.yml.parsing.Emp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;


public class FileJsonToList {

	public static void main(String[] args) throws Exception {
		File file = new File("employees.json");
		ObjectMapper mapper = new ObjectMapper();
		
		
		List<Emp> empList = mapper.readValue(file,new TypeReference<List<Emp>>() {} );
		
		
		empList.stream().forEach(System.out::println);

		

	}

}