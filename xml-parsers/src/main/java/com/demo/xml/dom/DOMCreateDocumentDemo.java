package com.demo.xml.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMCreateDocumentDemo {
    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("employees");
            doc.appendChild(rootElement);

            // employee element
            Element employee = doc.createElement("employee");
            rootElement.appendChild(employee);

            // setting attribute to element
            Attr attr = doc.createAttribute("doj");
            attr.setValue("2009-10-20");
            employee.setAttributeNode(attr);

            // emp-id element
            Element empId = doc.createElement("emp-id");
            Attr attrType = doc.createAttribute("type");
            attrType.setValue("permanent");
            empId.setAttributeNode(attrType);
            empId.appendChild(doc.createTextNode("100"));
            employee.appendChild(empId);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("Shantanu"));
            employee.appendChild(name);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("emps.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
