package com.demo;

import java.rmi.Naming;
import java.rmi.Remote;


public class Client {

	
	public static void main(String[] args) throws Exception{
		Remote robj=Naming.lookup("rmi://localhost:1099/test");
		ICal cal=(ICal)robj;
		System.out.println("The Result : "+cal.add(22, 33));

	}

}
