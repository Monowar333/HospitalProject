/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;



import HospitalWeb.controller.Doctors.PDFBuilder;
import HospitalWeb.Validate.ValidateRegular;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

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
                                "HospitalWeb.mail",
                                "HospitalWeb.mail.config",
                                "HospitalWeb.service",
                                "HospitalWeb.service.config",
                                "HospitalWeb.workwithxml",
                                "HospitalWeb.workwithexel",
                                "HospitalWeb.workwithxml.config",
                                "HospitalWeb.web",
                                "HospitalWeb.Validate.*",
                                "HospitalWeb.controller.*",
                                "HospitalWeb.Doctor.controller.pdf.PDFBuilder",
                                "HospitalWeb.web.springconfig"
                                
        
    })
    @Import({ AppSecurityConfig.class })
    public class WebConfig extends WebMvcConfigurerAdapter {
        
    /**
     * <mvc:resources mapping="/resources/**" location="/resources/" />
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
        @Bean
         public InternalResourceViewResolver viewResolver() {
         InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
         viewResolver.setViewClass(JstlView.class);
         viewResolver.setOrder(2);
         viewResolver.setPrefix("/WEB-INF/");
         viewResolver.setSuffix(".jsp");
         return viewResolver;
        }
         
         
        @Bean
         public ResourceBundleViewResolver viewResolver1() {
         ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
//        viewResolver.setViewClass(org.springframework.web.servlet.view.ResourceBundleViewResolver);
//         viewResolver.setSuffix("views");
        viewResolver.setOrder(1);
         viewResolver.setBasename("views");
         return viewResolver;
        }
         
        @Bean(name = "userDetailsService")
        public UserDetailsService userDetailsService(){
            return new AuthenticationManager();
        }
        
         @Bean(name = "usersValidate")
        public UsersValidate usersValidate(){
            return new UsersValidate();
        }
         @Bean(name = "cardValidate")
        public CardValidate cardValidate(){
            return new CardValidate();
        }
         @Bean(name = "userVAlidateUpdate")
        public UserVAlidateUpdate userVAlidateUpdate(){
            return new UserVAlidateUpdate();
        }
          @Bean(name = "specializationValidate")
        public SpecializationValidate specializationValidate(){
            return new SpecializationValidate();
        }
        @Bean(name = "validateRegular")
        public ValidateRegular validateRegular(){
            return new ValidateRegular();
        }
        
         @Bean(name = "ReceptionValidate")
        public ReceptionValidate receptionValidate(){
            return new ReceptionValidate();
        }
        
        @Bean(name = "startHospitalWeb")
        public StartHospitalWeb startHospitalWeb(){
            return new StartHospitalWeb();
        }
    }