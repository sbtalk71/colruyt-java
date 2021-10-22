package com.demo.xml.sax.ex2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class NoteSAXParser {

    public static void main(String[] args) {

        try {
            File inputFile = new File("notes.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            NoteHandler handler = new NoteHandler();
            saxParser.parse(inputFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class NoteHandler extends DefaultHandler {

    boolean bheader = false;
    boolean bbody = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
       // System.out.println("Start element called..");
        if (qName.equalsIgnoreCase("note")) {
            String date = attributes.getValue("date");
            System.out.println("Note Date : " + date);
        } else if (qName.equalsIgnoreCase("header")) {
            bheader = true;
        } else if (qName.equalsIgnoreCase("body")) {
            bbody = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("note")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bheader) {
            System.out.println("Note Header: " + new String(ch, start, length));
            bheader = false;
        } else if (bbody) {
            System.out.println("Note Body: " + new String(ch, start, length));
            bbody = false;
        }
    }
}