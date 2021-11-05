package com.demo.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Greeter {

    public void getGreet(){
        //logBefore
       System.out.println("Good Morning!");
        //LogAfter


    }

}
