package com.demo.xml.stax;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class StAXParserDemo {
   public static void main(String[] args) {
      boolean bEmpID = false;
      boolean bName = false;
      boolean bCity = false;
      boolean bSalary = false;
      
      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader("employees.xml"));

         while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
               
            switch(event.getEventType()) {
               
               case XMLStreamConstants.START_ELEMENT:
                  StartElement startElement = event.asStartElement();
                  String qName = startElement.getName().getLocalPart();

               if (qName.equalsIgnoreCase("employee")) {
                  System.out.println("Start Element : employee");
                  Iterator<Attribute> attributes = startElement.getAttributes();
                  String doj = attributes.next().getValue();
                  System.out.println("DOJ : " + doj);
               } else if (qName.equalsIgnoreCase("emp-id")) {
                  bEmpID = true;
               } else if (qName.equalsIgnoreCase("name")) {
                  bName = true;
               } else if (qName.equalsIgnoreCase("city")) {
                  bCity = true;
               }
               else if (qName.equalsIgnoreCase("salary")) {
                  bSalary = true;
               }
               break;

               case XMLStreamConstants.CHARACTERS:
                  Characters characters = event.asCharacters();
               if(bEmpID) {
                  System.out.println("emp-Id: " + characters.getData());
                  bEmpID = false;
               }
               if(bName) {
                  System.out.println("Name: " + characters.getData());
                  bName = false;
               }
               if(bCity) {
                  System.out.println("City: " + characters.getData());
                  bCity = false;
               }
               if(bSalary) {
                  System.out.println("Salary: " + characters.getData());
                  bSalary = false;
               }
               break;

               case XMLStreamConstants.END_ELEMENT:
                  EndElement endElement = event.asEndElement();
                  
               if(endElement.getName().getLocalPart().equalsIgnoreCase("employee")) {
                  System.out.println("End Element : employee");
                  System.out.println();
               }
               break;
            } 
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (XMLStreamException e) {
         e.printStackTrace();
      }
   }
}