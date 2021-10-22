package com.demo.xml.stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.StringWriter;

public class StAXCreateXMLDemo {

   public static void main(String[] args) {

      try {
         StringWriter stringWriter = new StringWriter();

         XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
         XMLStreamWriter xMLStreamWriter =
            xMLOutputFactory.createXMLStreamWriter(stringWriter);
   
         xMLStreamWriter.writeStartDocument();
         xMLStreamWriter.writeStartElement("employees");
   
         xMLStreamWriter.writeStartElement("employee");
         xMLStreamWriter.writeAttribute("doj", "2009-10-29");
      
         xMLStreamWriter.writeStartElement("emp-id");
         xMLStreamWriter.writeCharacters("100");
         xMLStreamWriter.writeEndElement();
         xMLStreamWriter.writeStartElement("name");
         xMLStreamWriter.writeCharacters("Scott");
         xMLStreamWriter.writeEndElement();
         xMLStreamWriter.writeStartElement("city");
         xMLStreamWriter.writeCharacters("Chennai");
         xMLStreamWriter.writeEndElement();

         xMLStreamWriter.writeStartElement("salary");
         xMLStreamWriter.writeCharacters("46000");
         xMLStreamWriter.writeEndElement();



         xMLStreamWriter.writeEndElement();
         xMLStreamWriter.writeEndDocument();

         xMLStreamWriter.flush();
         xMLStreamWriter.close();

         String xmlString = stringWriter.getBuffer().toString();

         stringWriter.close();

         System.out.println(xmlString);

      } catch (XMLStreamException e) {
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}