package com.demo.misc;

import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) {
        String userName="shantanu:welcome1";
        byte[] byteData=userName.getBytes();

        System.out.println(new String(Base64.getEncoder().encode(byteData)));

        System.out.println(Base64.getEncoder().encodeToString(byteData));

        String encodedData="dGhpcyBpcyBhIGRlbW8gc3RyaW5nIEkgZ290IGZyb20gZ29vZ2xl";
        byte[] newData=Base64.getDecoder().decode(encodedData);

        System.out.println(new String(newData));
    }
}
