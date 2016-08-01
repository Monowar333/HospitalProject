/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospita.Servlets.Registry;


import com.hospital.DAO.CardDAO;
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
@WebServlet(name = "StartPageRegistry", urlPatterns = {"/StartPageRegistry"})
public class StartPageRegistry extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApplicationContext contex = 
                            new AnnotationConfigApplicationContext(ServiseConfig.class);
                    CardDAO servise = contex.getBean(CardDAO.class);
         request.setAttribute("cardlist", servise.getList());
                    RequestDispatcher dispatcher = 
                            request.getRequestDispatcher("/WEB-INF/Registry/RegistryCabinet.jsp");
                    if(dispatcher != null){
                        dispatcher.forward(request, response);
                    }
        
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ApplicationContext contex = 
//                            new AnnotationConfigApplicationContext(ServiseConfig.class);
//                    CardDAO servise = contex.getBean(CardDAO.class);
//            request.setAttribute("cardlist", servise.getList());
//                   
//                    RequestDispatcher dispatcher = 
//                            request.getRequestDispatcher("/WEB-INF/Registry/RegistryCabinet.jsp");
//                    if(dispatcher != null){
//                        dispatcher.forward(request, response);
//                    }
                    processRequest(request, response);
                   
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ApplicationContext contex = 
//                            new AnnotationConfigApplicationContext(ServiseConfig.class);
//                    CardDAO servise = contex.getBean(CardDAO.class);
//            request.setAttribute("cardlist", servise.getList());
//                    RequestDispatcher dispatcher = 
//                            request.getRequestDispatcher("/WEB-INF/Registry/RegistryCabinet.jsp");
//                    if(dispatcher != null){
//                        dispatcher.forward(request, response);
//                    }
                      processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
  
}
