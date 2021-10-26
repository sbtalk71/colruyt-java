package com.demo;

import java.rmi.Naming;


public class TestServer {

	public static void main(String[] args) throws Exception{
		
		Calculator cal = new Calculator();
		Naming.bind("rmi://localhost:1099/test", cal);
		System.out.println("The object is bound..");
		
	}

}
