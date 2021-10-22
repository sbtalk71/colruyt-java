package com.demo.xml.dom4j;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DOM4JCreateDocumentDemo {
    public static void main(String[] args) {

        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement( "employees" );
            Element employeeElement = root.addElement("employee")
                    .addAttribute("doj", "2009-10-21");

            employeeElement.addElement("name").addText("John");

            employeeElement.addElement("emp-id").addText("100");
            employeeElement.addElement("city").addText("Pune");
            employeeElement.addElement("salary").addText("89000");

            // Pretty print the document to System.out
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter( System.out, format );
            writer.write( document );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
