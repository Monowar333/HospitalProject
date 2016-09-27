
package HospitalWeb.workwithxml.config;

import HospitalWeb.workwithexel.FromExelToDB;
import HospitalWeb.workwithexel.FromExelToDBImpl;
import HospitalWeb.workwithxml.FromXMLtlDBDOM;
import HospitalWeb.workwithxml.FromXMLtoDB;
import HospitalWeb.workwithxml.WorkWithXML;
import HospitalWeb.workwithxml.WorkWithXMLDOM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan({
                                "HospitalWeb.domain",
                                "HospitalWeb.domain.DAO",
                                "HospitalWeb.domain.config",
                                "HospitalWeb.service",
                                "HospitalWeb.service.config",
                                "HospitalWeb.workwithxml",
                                "HospitalWeb.workwithexel"
})
                
public class WorkWithXMLConfig{
        //инекция зависимости самого контейнера, создаем бин который может быть внедрен  
    
    @Bean
    public WorkWithXML getWorkWithXML(){
        return new WorkWithXMLDOM();
    }
    
   
     @Bean
    public  FromXMLtoDB getFromXMLtoDB(){
        return new  FromXMLtlDBDOM();
    }
    
     @Bean
    public  FromExelToDB getFromExelToDB(){
        return new  FromExelToDBImpl();
    }
    
}
