
package HospitalWeb.workwithxml.config;

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
                                "HospitalWeb.workwithxml"
})
                
public class WorkWithXMLConfig{
        //инекция зависимости самого контейнера, создаем бин который может быть внедрен  
    
    @Bean
    public WorkWithXML getWorkWithXML(){
        return new WorkWithXMLDOM();
    }
    
    
    
    
}
