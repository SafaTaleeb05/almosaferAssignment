package org.example.ReadingHelpers;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLReader {

    public static String getXMLData(String dataFor) {
        String nodeValue = null;
        try {
            File file = new File("src/test/Resources/xml-data.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(file);
            nodeValue = document.getElementsByTagName(dataFor).item(0).getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return nodeValue;
    }

}
