/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.workwithxml;

import HospitalWeb.domain.Users;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.UserService;

 import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;



/**
 *
 * @author Жека
 */
//@Component
public class WorkWithXMLDOM implements WorkWithXML{
    @Autowired
     SpecialalizationService specService;
     
     @Autowired
     UserService userService;

    public WorkWithXMLDOM() {
      
    }

    @Override
    public void creatXML() throws IOException {
       
        
            List<Users> users = userService.getList() ;
                 Document doc = new Document();
        // создаем корневой элемент с пространством имен
        doc.setRootElement(new Element("Users",
                Namespace.getNamespace("Hospital")));
        // формируем JDOM документ из объектов Student
         for (Users user : users) {
            Element userElement = new Element("User",
        Namespace.getNamespace("Hospital"));
            userElement.setAttribute("id", String.valueOf(user.getId()));
            userElement.addContent(new Element("name",
        Namespace.getNamespace("Hospital")).setText(user.getName()));
            userElement.addContent(new Element("snme",
        Namespace.getNamespace("Hospital")).setText(user.getSnme()));
            userElement.addContent(new Element("exp",
        Namespace.getNamespace("Hospital")).setText(user.getExp().toString()));
            userElement.addContent(new Element("login",
        Namespace.getNamespace("Hospital")).setText(user.getLogin()));
            userElement.addContent(new Element("password",
        Namespace.getNamespace("Hospital")).setText(user.getPassword()));
            userElement.addContent(new Element("email",
        Namespace.getNamespace("Hospital")).setText(user.getEmail()));
            userElement.addContent(new Element("telephone",
        Namespace.getNamespace("Hospital")).setText(user.getTelephone()));
            userElement.addContent(new Element("status",
        Namespace.getNamespace("Hospital")).setText(user.getStatus()));
            userElement.addContent(new Element("idspecialization",
        Namespace.getNamespace("Hospital")).setText(user.getIdspecialization().getId().toString()));
            userElement.addContent(new Element("statusregistr",
        Namespace.getNamespace("Hospital")).setText(String.valueOf(user.getStatusregistr())));
            userElement.addContent(new Element("statusWork",
        Namespace.getNamespace("Hospital")).setText(String.valueOf(user.getStatusregistr())));
            userElement.addContent(new Element("linkaccept",
        Namespace.getNamespace("Hospital")).setText(user.getLinkaccept()));
   
            doc.getRootElement().addContent(userElement);
         }
         //String filen =  "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator + "users.xml";
          //String filen = "classpath:" + File.separator + "resourse" + File.separator + "users.xml";
          String filen = CredentialsBundle.resolveCredentials("file");
          File file = new File(filen);
                System.out.println(file.getAbsolutePath());
            file.createNewFile();
            System.out.println(file.getAbsolutePath());
            System.out.println(file.canWrite());
        // Документ JDOM сформирован и готов к записи в файл
        XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
        	
        xmlWriter.output(doc, System.out);
        // сохнаряем в файл
        FileOutputStream fileout = new FileOutputStream(file);
        xmlWriter.output(doc, fileout);
        fileout.close();
            
        // сохнаряем в файл
       
            System.out.println("Файл сохранен!");
           
        }
       
    

    
   

   

  
    
}
