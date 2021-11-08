package com.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Maths {

    @WebMethod()
    public int add(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8181/maths",new Maths());
    }
}
