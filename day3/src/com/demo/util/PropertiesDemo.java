package com.demo.util;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties props = System.getProperties();
       Set<Object> keys= props.keySet();
       for(Object obj:keys){
           System.out.println(obj+"--> "+props.get(obj));
       }
    }
}
