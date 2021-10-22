package com.demo.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserDemo {

    public static void main(String[] args) {

        try {
            File inputFile = new File("employees.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    boolean bEmpId = false;
    boolean bName = false;
    boolean bCity = false;
    boolean bSalary = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
       // System.out.println("Start element called..");
        if (qName.equalsIgnoreCase("employee")) {
            String doj = attributes.getValue("doj");
            System.out.println("DOJ : " + doj);
        } else if (qName.equalsIgnoreCase("emp-id")) {
            bEmpId = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("city")) {
            bCity = true;
        } else if (qName.equalsIgnoreCase("salary")) {
            bSalary = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bEmpId) {
            System.out.println("Emp Id: " + new String(ch, start, length));
            bEmpId = false;
        } else if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bCity) {
            System.out.println("City: " + new String(ch, start, length));
            bCity = false;
        } else if (bSalary) {
            System.out.println("Marks: " + new String(ch, start, length));
            bSalary = false;
        }
    }
}