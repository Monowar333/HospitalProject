/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.config;


import HospitalWeb.domain.DAO.CardsDAO;
import HospitalWeb.domain.DAO.CardsDAOImpl;
import HospitalWeb.domain.DAO.MedicationsDAO;
import HospitalWeb.domain.DAO.MedicationsDAOImpl;
import HospitalWeb.domain.DAO.PrescriptionDAO;
import HospitalWeb.domain.DAO.PrescriptionDAOImpl;
import HospitalWeb.domain.DAO.PrescriptiondeteilDAO;
import HospitalWeb.domain.DAO.PrescriptiondeteilDAOImpl;
import HospitalWeb.domain.DAO.ProvisionaldiagnosisDAO;
import HospitalWeb.domain.DAO.ProvisionaldiagnosisDAOImpl;
import HospitalWeb.domain.DAO.ReceptionDAO;
import HospitalWeb.domain.DAO.ReceptionDAOImpl;
import HospitalWeb.domain.DAO.SpecialalizationDAO;
import HospitalWeb.domain.DAO.SpecialalizationDAOImpl;
import HospitalWeb.domain.DAO.UserDAO;
import HospitalWeb.domain.DAO.UsersDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author stan
 */

@Configuration
@ComponentScan("HospitalWeb.domain.DAO")
public class DomainConfig {
        //инекция зависимости самого контейнера, создаем бин который может быть внедренно  
    
    @Bean
    public UserDAO getUserDao(){
        return new UsersDAOImpl();
    }
    
    @Bean
    public CardsDAO getCardsDao(){
        return new CardsDAOImpl();
    }
    
    @Bean
    public PrescriptionDAO getPrescriptionDao(){
        return new PrescriptionDAOImpl();
    }
    
     
    @Bean
    public PrescriptiondeteilDAO getPrescriptiondeteilDAO(){
        return new PrescriptiondeteilDAOImpl();
    }
    
    
    @Bean
    public SpecialalizationDAO getSpecialalizationDao(){
        return new SpecialalizationDAOImpl();
    }
    
    @Bean
    public ReceptionDAO getReceptionDAO(){
        return new ReceptionDAOImpl();
    }
    
    @Bean
    public MedicationsDAO getMedicationsDAO(){
        return new MedicationsDAOImpl();
    }
    
     @Bean
    public ProvisionaldiagnosisDAO getProvisionaldiagnosisDAO(){
        return new ProvisionaldiagnosisDAOImpl();
    }
    
    
    
}
