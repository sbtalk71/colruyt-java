package com.demo.xml.jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JDOMParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("employees.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();

            List<Element> studentList = classElement.getChildren();
            System.out.println("----------------------------");

            for (int temp = 0; temp < studentList.size(); temp++) {
                Element employee = studentList.get(temp);
                System.out.println("\nCurrent Element :"
                        + employee.getName());
                Attribute attribute =  employee.getAttribute("doj");
                System.out.println("Emp doj : "
                        + attribute.getValue() );
                System.out.println("empID : "
                        + employee.getChild("emp-id").getText());
                System.out.println("Name : "
                        + employee.getChild("name").getText());
                System.out.println("City : "
                        + employee.getChild("city").getText());
                System.out.println("Salary : "
                        + employee.getChild("salary").getText());
            }
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
