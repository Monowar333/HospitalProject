/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service.config;


import HospitalWeb.service.CardService;
import HospitalWeb.service.CardServiceImpl;
import HospitalWeb.service.MedicationsService;
import HospitalWeb.service.MedicationsServiceImpl;
import HospitalWeb.service.PrescriptionService;
import HospitalWeb.service.PrescriptionServiceImpl;
import HospitalWeb.service.PrescriptiondeteilService;
import HospitalWeb.service.PrescriptiondeteilServiceImpl;
import HospitalWeb.service.ProvisionaldiagnosisService;
import HospitalWeb.service.ProvisionaldiagnosisServiceImpl;
import HospitalWeb.service.ReceptionService;
import HospitalWeb.service.ReceptionServiceImpl;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.SpecialalizationServiceImpl;
import HospitalWeb.service.UserService;
import HospitalWeb.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author stan
 */
@Configuration
@ComponentScan({
        "HospitalWeb.domain",
        "HospitalWeb.domain.config",
        "HospitalWeb.domain.DAO",
        "HospitalWeb.service",
        "HospitalWeb.service.config"
    })
public class ServiceConfig {
    
    
    @Bean
    public UserService getUsersService(){
        return new UserServiceImpl();
    }
    
    @Bean
    public CardService getCardService(){
        return new CardServiceImpl();
    }
    
    @Bean
    public SpecialalizationService getSpecialalizationService(){
        return new SpecialalizationServiceImpl();
    }
    
      @Bean
    public ReceptionService getReceptionService(){
        return new ReceptionServiceImpl();
    }
    
       @Bean
    public MedicationsService getMedicationsService(){
        return new MedicationsServiceImpl();
    }
    
    @Bean
    public PrescriptionService getPrescriptionService(){
        return new PrescriptionServiceImpl();
    }
    
    @Bean
    public PrescriptiondeteilService getPrescriptiondeteilService(){
        return new PrescriptiondeteilServiceImpl();
    }
    
    @Bean
    public ProvisionaldiagnosisService getProvisionaldiagnosisService(){
        return new ProvisionaldiagnosisServiceImpl();
    }
    
}
