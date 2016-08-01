/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import com.hospital.DAO.SpecialalizationDAO;
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
 *переход к форме добавления 
 * @author Жека
 */
@WebServlet(name = "AddDoctors", urlPatterns = {"/AddDoctors"})
public class AddDoctors extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
        SpecialalizationDAO service = contex.getBean(SpecialalizationDAO.class);
        request.setAttribute("Specialalization",service.getList() );
        
       
        RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Admin/AddDoctors.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
