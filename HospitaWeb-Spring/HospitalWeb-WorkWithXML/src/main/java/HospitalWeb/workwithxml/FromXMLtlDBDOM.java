/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.workwithxml;

import HospitalWeb.domain.Users;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.UserService;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Жека
 */
public class FromXMLtlDBDOM implements FromXMLtoDB{
    
    @Autowired
     SpecialalizationService specService;
     
     @Autowired
     UserService userService;
     
    @Override
     public void FromXMLtlDBDOM(){
        String file = "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator + "iblog.xml";
        File xmlFile = new File(file);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            // получаем узлы с именем Language
            // теперь XML полностью загружен в память 
            // в виде объекта Document
            NodeList nodeList = document.getElementsByTagName("User"); 
            // создадим из него список объектов Language            
            for (int i = 0; i < nodeList.getLength(); i++) {
                userService.save(getUser(nodeList.item(i)));
            } 
            // печатаем в консоль информацию по каждому объекту Language           
        } catch (Exception exc) {
            exc.printStackTrace();
        }
     }
     
      private  Users getUser(Node node) {
        Users lang = new Users();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            lang.setName(getTagValue("name", element));
            lang.setSnme(getTagValue("snme", element));
            lang.setExp(Integer.parseInt(getTagValue("exp", element)));
            lang.setLogin(getTagValue("login", element));
            lang.setPassword(getTagValue("password", element));
            lang.setEmail(getTagValue("email", element));
            lang.setTelephone(getTagValue("telephone", element));
            lang.setStatus(getTagValue("status", element));
            lang.setIdspecialization(specService.getById(Integer.parseInt(getTagValue("idspecialization", element))));
            lang.setStatusregistr(Boolean.parseBoolean(getTagValue("statusregistr", element)));
            lang.setStatusWork(Boolean.parseBoolean(getTagValue("statusWork", element)));
            // lang.setLinkaccept(getTagValue("linkaccept", element));
            
            
          //  lang.setSnme(Integer.parseInt(getTagValue("snme", element)));
        }
 
        return lang;
    }
 
    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        //System.out.println(node);
        return node.getNodeValue();
    }
}
