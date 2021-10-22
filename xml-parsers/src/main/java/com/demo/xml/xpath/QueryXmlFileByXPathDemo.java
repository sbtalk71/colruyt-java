package com.demo.xml.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class QueryXmlFileByXPathDemo {

   public static void main(String[] args) {
 
      try {
         File inputFile = new File("employees.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.print("Root element: ");
         System.out.println(doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("employee");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :");
            System.out.print(nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.print("DOJ : ");
               System.out.println(eElement.getAttribute("doj"));
               NodeList empList = eElement.getElementsByTagName("employee");
               
               for (int count = 0; count < empList.getLength(); count++) {
                  Node node1 = empList.item(count);
                  
                  if (node1.getNodeType() == node1.ELEMENT_NODE) {
                     Element emp = (Element) node1;
                     System.out.print("Emp ID : ");
                     System.out.println(emp.getTextContent());

                  }
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}