/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import DB.entity.Users;
import com.hospital.DAO.UsersDAO;
import com.hospital.Servise.UserServiceImpl;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "StartpageAdminCabinet", urlPatterns = {"/StartpageAdminCabinet"})
public class StartpageAdminCabinet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
        
        ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
        UsersDAO service = contex.getBean(UsersDAO.class);
//        List<Users> allusers;
//        allusers = service.getList();
        request.setAttribute("users", service.getList());
        RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Admin/AllBase.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
