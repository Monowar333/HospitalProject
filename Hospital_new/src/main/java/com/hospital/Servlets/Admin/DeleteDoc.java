/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import com.hospital.DAO.UsersDAO;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Жека
 */
@WebServlet(name = "DalateDoc", urlPatterns = {"/DalateDoc"})
public class DeleteDoc extends HttpServlet {
// private String page  ="/Admin_jsp/AllBase.jsp";
 private String link;
private Integer il;

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html; charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
                    int id = 0;
               try{                    
                      id = HelpClass.WorkWithTransformation.
                      StringToInt(request.getParameter("param"));
                    if(id <= 0){
                       throw new IllegalArgumentException();
                    }
                }catch (IllegalArgumentException ex){
                     response.sendError(404,"invalid param");
                    } 
                    ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                    UsersDAO service = contex.getBean(UsersDAO.class);
                    service.changeStatus(id);
                    response.sendRedirect("StartpageAdminCabinet");
    }
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
   

  
   

 
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


