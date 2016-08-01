/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;


import com.hospital.DAO.SpecialalizationDAO;
import com.hospital.DAO.UsersDAO;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;
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
@WebServlet(name = "SelectDoctorsForAllUsers", urlPatterns = {"/SelectDoctorsForAllUsers"})
public class SelectDoctorsForAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 0;
               try{
                      System.out.println(request.getParameter("param"));
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
                    SpecialalizationDAO service1 = contex.getBean(SpecialalizationDAO.class);
                    UsersDAO service = contex.getBean(UsersDAO.class);
                    request.setAttribute("user", service.getById(id));
                    request.setAttribute("Specialalization",service1.getList() );
                    RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/AllUsers/AboutDoctor.jsp");
                    if(dispatcher1 != null){
                        dispatcher1.forward(request, response);
                    }
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
