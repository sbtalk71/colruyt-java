package com.demo.jaxb;

import com.demo.entity.Emp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

public class JAXBMarshaller {
    public static void main(String[] args) throws Exception{
        JAXBContext ctx= JAXBContext.newInstance(Emp.class); //package name as parameter
        Marshaller m=ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        Emp emp = new Emp(100,"Shantanu","Hyderabad",89000);
        m.marshal(emp,System.out);
        m.marshal(emp,new FileOutputStream("emp.xml"));

    }
}
