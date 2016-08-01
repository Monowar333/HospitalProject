/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Serviseconfig;

import com.hospital.DAO.CardDAO;
import com.hospital.DAO.SpecialalizationDAO;
import com.hospital.DAO.UsersDAO;
import com.hospital.Servise.CardService;
import com.hospital.Servise.CardServiceImpl;
import com.hospital.Servise.SpecialalizationService;
import com.hospital.Servise.SpecialalizationServiceImpl;
import com.hospital.Servise.UserService;
import com.hospital.Servise.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Жека
 */
//Указываем пакеты где находяться необходимые класы 
@Configuration 
@ComponentScan({"com.hospital.DAO",
                                "com.hospital.Servise",
                                "com.hospital.Serviseconfig",
                                "com.hospital.DAO",
                                "com.hospital.Servlets.Admin",
                                "com.hospital.Servlets.AllUsers",
                                "com.hospital.Servlets.Registry"
                                })
public class ServiseConfig {
    //инекция зависимости самого контейнера, создаем бин который может быть внедренно  
   
    @Bean
     public UserService getUserService(){
        return new UserServiceImpl();
    }
     
    @Bean
     public UsersDAO getUsersDAO(){
         return   new UsersDAO();
     }
     
      @Bean
     public SpecialalizationService getSpecialalizationService(){
        return new SpecialalizationServiceImpl();
    }
     
    @Bean
     public SpecialalizationDAO getSpecialalizationDAO(){
         return   new SpecialalizationDAO();
     }
     
       @Bean
     public CardService getCardServiceImpl(){
        return new CardServiceImpl();
    }
     
    @Bean
     public CardDAO getCardDAO(){
         return   new CardDAO();
     }
     
    
    
}