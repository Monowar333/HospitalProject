/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;

import com.hospital.DAO.SpecialalizationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Жека
 */
@WebServlet(name = "StartServlet", urlPatterns = {"/StartServlet"})
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          System.out.println("dasd asdsdasdasdasd"); 
//         Cookie auth = new Cookie("auth", "accepted_doctor");
//         Cookie username = new Cookie("username", null);
//         response.addCookie(auth);
//         response.addCookie(username);
     SpecialalizationDAO spec = new SpecialalizationDAO();
        request.setAttribute("Specialalization",spec.getList() );
        RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/AllUsers/StartPage.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("dasd asdsdasdasdasd");   
        SpecialalizationDAO spec = new SpecialalizationDAO();
        request.setAttribute("Specialalization",spec.getList() );
        RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/AllUsers/StartPage.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
