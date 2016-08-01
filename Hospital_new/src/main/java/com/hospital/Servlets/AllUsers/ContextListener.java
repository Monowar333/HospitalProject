/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;

import DB.entity.HibernateUtil;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.Cookie;


/**
 * Web application lifecycle listener.
 *
 * Служит для контроля состояния нашего приложения, так же при деплое приложения 
 * мы отвязыаемся от БД
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context initialized " + new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.getSessionFactory().close();
//         Cookie c = new Cookie("auth", "invalid");
//        response.addCookie(c);
        System.out.println("context destroyed " + new Date());
    }
}
