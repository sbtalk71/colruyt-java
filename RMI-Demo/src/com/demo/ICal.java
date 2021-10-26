package com.demo;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICal extends Remote {
public int add(int a, int b)throws RemoteException;
}
