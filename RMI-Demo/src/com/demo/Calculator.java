package com.demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Calculator extends UnicastRemoteObject implements ICal{

	public Calculator() throws RemoteException {
		System.out.println("Object created...");
	}
	@Override
	public int add(int a, int b) throws RemoteException {
		System.out.println("Inside add method..");
		return a+b;
	}

}
