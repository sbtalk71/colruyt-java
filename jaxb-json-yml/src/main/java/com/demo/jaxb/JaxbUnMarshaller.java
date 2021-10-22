package com.demo.jaxb;

import com.demo.entity.Emp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUnMarshaller {
    public static void main(String[] args) throws Exception{
        JAXBContext ctx= JAXBContext.newInstance(Emp.class); //package name as parameter
        Unmarshaller um= ctx.createUnmarshaller();

        Emp e=(Emp)um.unmarshal(new File("emp.xml"));
        System.out.println(e);


    }
}
