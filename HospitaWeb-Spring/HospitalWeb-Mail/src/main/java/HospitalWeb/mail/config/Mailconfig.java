/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.mail.config;

import HospitalWeb.mail.SendMail;
import HospitalWeb.mail.SendMailImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Жека
 */
@Configuration
@ComponentScan("HospitalWeb.mail")
public class Mailconfig {
    
    @Bean
    public SendMail getMail(){
        return  new SendMailImpl();
    }
}
