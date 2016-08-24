/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;

import HospitalWeb.workwithxml.FromXMLtoDB;
import HospitalWeb.workwithxml.WorkWithXML;
import java.io.IOException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Жека
 */
public class StartHospitalWeb implements InitializingBean, DisposableBean  {
    
    @Autowired
     WorkWithXML workWithXML;
     
      @Autowired
     FromXMLtoDB FromXMLtoDB;
      
       @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Start App");
          try{
            FromXMLtoDB.FromXMLtlDBDOM();
            }catch ( IOException ex){
                System.out.println("HospitalWeb.controller.AllUsers.AllUsersController.getDoctorsList()");
            }
    }
    
    public void destroy(){
//        System.out.println("destroy App");
//        try{
//            workWithXML.creatXML();
//            }catch ( IOException ex){
//                System.out.println("HospitalWeb.controller.AllUsers.AllUsersController.getDoctorsList()");
//            }
    }
    
}
