/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;

import DB.entity.Users;
import com.hospital.DAO.UsersDAO;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Жека
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest)request).getCookies();
        Cookie auntlink = null;
        for(Cookie c : cookies){
            if(c.getName().equals("auntlink")){ 
                    auntlink = c;
            }
        }
        ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                    UsersDAO service = contex.getBean(UsersDAO.class);
        Users us = service.getByAuntification(auntlink.getValue());
        us.setAuntification(null);
        service.update(us);
        Cookie a = new Cookie("auntlink", null);
        response.addCookie(a);
        response.sendRedirect("StartServlet");
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
