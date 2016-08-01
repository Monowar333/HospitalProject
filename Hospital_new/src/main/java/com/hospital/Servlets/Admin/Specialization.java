/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import DB.entity.Spcialialization;
import DB.entity.Users;
import HelpClass.Regular;
import com.hospital.DAO.SpecialalizationDAO;
import com.hospital.DAO.UsersDAO;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "Specialization", urlPatterns = {"/specialization"})
public class Specialization extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html; charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
                   ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                SpecialalizationDAO service = contex.getBean(SpecialalizationDAO.class);
                     request.setAttribute("addoredit", true);
                    request.setAttribute("specialization", service.getList());
        RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Admin/AddSpecialization.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          processRequest(request, response);
//        response.setContentType("text/html; charset=UTF-8");
//             request.setCharacterEncoding("UTF-8");
//                    int id = 0;
//               try{
////                      System.out.println(request.getParameter("param"));
//                      id = HelpClass.WorkWithTransformation.
//                      StringToInt(request.getParameter("param"));
//                    if(id <= 0){
//                       throw new IllegalArgumentException();
//                    }
//                }catch (IllegalArgumentException ex){
//                     response.sendError(404,"invalid param");
//                    } 
//                  SpecialalizationDAO spec = new SpecialalizationDAO();
//                    spec.remove(spec.getById(id));
////                    SpecialalizationDAO spe = new SpecialalizationDAO();
////                     List<Spcialialization> allusers;
////                     allusers = spe.getList();
//                    request.setAttribute("specialization", spec.getList());
//                    RequestDispatcher dispatcher1 = 
//                    request.getRequestDispatcher("WEB-INF/Admin/AddSpecialization.jsp");
//                    if(dispatcher1 != null){
//                    dispatcher1.forward(request, response);
//                    }       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//                response.setContentType("text/html; charset=UTF-8");
//                request.setCharacterEncoding("UTF-8");
//                    SpecialalizationDAO spe = new SpecialalizationDAO();
//                     List<Spcialialization> allusers;
//                     allusers = spe.getList();
//                     request.setAttribute("addoredit", true);
//                    request.setAttribute("specialization", allusers);
//        RequestDispatcher dispatcher1 = 
//                    request.getRequestDispatcher("WEB-INF/Admin/AddSpecialization.jsp");
//                    if(dispatcher1 != null){
//                    dispatcher1.forward(request, response);
//                    }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
