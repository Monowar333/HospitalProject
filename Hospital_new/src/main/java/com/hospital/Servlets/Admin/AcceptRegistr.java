/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import DB.entity.Spcialialization;
import DB.entity.Users;
import com.hospital.DAO.SpecialalizationDAO;
import com.hospital.DAO.UsersDAO;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "НовыйServlet", urlPatterns = {"/AcceptRegistr"})
public class AcceptRegistr extends HttpServlet {

    private String link;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        link = request.getParameter("param");
        System.out.println(link);
        Users user = new Users();
           ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
        UsersDAO service = contex.getBean(UsersDAO.class);
        user = (Users) service.getByLinckAccept(link);
        user.setLinkaccept(null);
        user.setStatusregistr(true);
        service.update(user);
        
            RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/AllUsers/acceptregistr.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
