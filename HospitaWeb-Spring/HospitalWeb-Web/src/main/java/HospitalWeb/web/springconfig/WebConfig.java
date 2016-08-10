/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Жека
 */
@Configuration
@EnableWebMvc
@ComponentScan({
                                "HospitalWeb.domain",
                                "HospitalWeb.domain.DAO",
                                "HospitalWeb.domain.config",
                                "HospitalWeb.mail.config",
                                "HospitalWeb.service",
                                "HospitalWeb.service.config",
                                "HospitalWeb.web",
                               
                                "HospitalWeb.controller.*",
                                "HospitalWeb.web.springconfig"
        
    })
    public class WebConfig extends WebMvcConfigurerAdapter {
        

    
        @Bean
         public InternalResourceViewResolver viewResolver() {
         InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
         viewResolver.setViewClass(JstlView.class);
         viewResolver.setPrefix("/WEB-INF/");
         viewResolver.setSuffix(".jsp");
         return viewResolver;
     }
    }