package com.java.yash;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadingXml {
	public static void main(String args[]) {
		String filePath = "D:\\JavaWorkspace\\Java Project1\\src\\GK.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Question");
            // now XML is loaded as Document in memory, lets convert it to Object List
            List < Quiz > quesList = new ArrayList < Quiz > ();

            for (int i = 0; i < nodeList.getLength(); i++) {
                quesList.add(getUser(nodeList.item(i)));
            }
            // lets print User list information
            for (Quiz ques: quesList) {
                System.out.println(ques.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        
        //new subject file of Database
        String fileLocation = "D:\\JavaWorkspace\\Java Project1\\src\\Database.xml";
        File DbFile = new File(fileLocation);
        DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder2;
        
        
        try {
        	dBuilder2= dbFactory2.newDocumentBuilder();
        	Document doc = dBuilder2.parse(DbFile);
        	doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            System.out.println("-----------------DBMS QUESTIONS-----------------------");
            NodeList nodeList = doc.getElementsByTagName("Question");
        	
            List < Quiz > quesList = new ArrayList < Quiz > ();

            for (int i = 0; i < nodeList.getLength(); i++) {
                quesList.add(getUser(nodeList.item(i)));
            }
            // lets print User list information
            for (Quiz ques: quesList) {
                System.out.println(ques.toString());
            }

        }catch (SAXException | ParserConfigurationException | IOException e1){
        	e1.printStackTrace();
        }
        
        

	}
	
	private static Quiz getUser(Node node) {
        // XMLReaderDOM domReader = new XMLReaderDOM();
        Quiz user = new Quiz();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            user.setId(Integer.parseInt(getTagValue("id", element)));
            user.setQuestion(getTagValue("Questions",element));
            user.setOption1(getTagValue("Option1", element));
            user.setOption2(getTagValue("Option2", element));
            user.setOption3(getTagValue("Option3", element));
            user.setOption4(getTagValue("Option4",element));
            user.setCorrect(getTagValue("Correct",element));
        }
        return user;
    }
	
	  private static String getTagValue(String tag, Element element) {
	        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
	        Node node = (Node) nodeList.item(0);
	        return node.getNodeValue();
	    }
	

}