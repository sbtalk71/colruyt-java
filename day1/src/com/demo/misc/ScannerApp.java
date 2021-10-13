package com.demo.misc;

import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(true) {
            System.out.println("enter quit to exit");
            String name = sc.next();
            System.out.println("you entered :"+name);
            if(name.equals("quit")) break;
        }
    }
}
