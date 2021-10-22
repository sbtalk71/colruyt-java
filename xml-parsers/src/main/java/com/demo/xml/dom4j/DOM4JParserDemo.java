package com.demo.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class DOM4JParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("employees.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read( inputFile );

            System.out.println("Root element :" + document.getRootElement().getName());

            Element classElement = document.getRootElement();

            List<Node> nodes = document.selectNodes("/employees/employee" );
            System.out.println("----------------------------");

            for (Node node : nodes) {
                System.out.println("\nCurrent Element :"
                        + node.getName());
                System.out.println("Employee DOJ : "
                        + node.valueOf("@doj") );
                System.out.println("Name : "
                        + node.selectSingleNode("name").getText());
                System.out.println("City : "
                        + node.selectSingleNode("city").getText());
                System.out.println("Salary : "
                        + node.selectSingleNode("salary").getText());
                System.out.println("Emp Id : "
                        + node.selectSingleNode("emp-id").getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
