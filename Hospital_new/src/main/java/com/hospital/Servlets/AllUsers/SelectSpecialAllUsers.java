/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;

import DB.entity.Spcialialization;
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
@WebServlet(name = "SelectSpecialAllUsers", urlPatterns = {"/SelectSpecialAllUsers"})
public class SelectSpecialAllUsers extends HttpServlet {

    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
               Spcialialization spec = new Spcialialization();
                 ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                 SpecialalizationDAO service = contex.getBean(SpecialalizationDAO.class);
                     request.setAttribute("addoredit", true);
                    request.setAttribute("specialization", service.getList());
               spec = service.getById(id);
                     UsersDAO service1 = contex.getBean(UsersDAO.class);
                     request.setAttribute("addoredit", true);
                    request.setAttribute("specialization", service.getList());
                    request.setAttribute("users", service1.getBySpecAndStWork(spec));
                    System.out.println(service1.getBySpec(spec).toString());
                    request.setAttribute("Specialalization",service.getList() );
                    RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/AllUsers/DoctorsForSpecialization.jsp");
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
