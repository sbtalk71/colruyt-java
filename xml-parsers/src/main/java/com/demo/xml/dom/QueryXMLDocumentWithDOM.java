package com.demo.xml.dom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class QueryXMLDocumentWithDOM {
    public static void main(String[] args) {

        try {
            File inputFile = new File("employees.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element rootElement = document.getRootElement();

            List<Element> empList = rootElement.getChildren("employee");
            System.out.println("----------------------------");

            for (int temp = 0; temp < empList.size(); temp++) {
                Element employee = empList.get(temp);
                System.out.println("\nCurrent Element :" + employee.getName());
                Attribute attribute = employee.getAttribute("doj");
                System.out.println("DOJ : " + attribute.getValue() );
                Element nameElement=employee.getChild("name");
                String name=nameElement.getText();
                System.out.println(name);
                Element cityElement=employee.getChild("city");
                String city=cityElement.getText();
                System.out.println(city);

                Element salaryElement=employee.getChild("salary");
                String salary=salaryElement.getText();
                System.out.println(salary);
            /*
              List<Element> carNameList = employee.getChildren("name");

                for (int count = 0; count < carNameList.size(); count++) {
                    Element carElement = carNameList.get(count);
                    System.out.print("car name : ");
                    System.out.println(carElement.getText());
                    System.out.print("car type : ");
                    Attribute typeAttribute = carElement.getAttribute("type");

                    if(typeAttribute != null)
                        System.out.println(typeAttribute.getValue());
                    else {
                        System.out.println("");
                    }
                }*/
            }
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
