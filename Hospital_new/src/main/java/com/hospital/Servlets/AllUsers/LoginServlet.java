/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;

import DB.entity.Users;
import com.hospital.DAO.User_status;

import com.hospital.DAO.UsersDAO;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;

import java.util.List;
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
 * 
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
Boolean con = false;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           //request.getRequestDispatcher("login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Cookie auntlink = null;
        String link = null;
        String status = null;
        
        if ((user != null) && (pass != null)){
             ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                    UsersDAO service = contex.getBean(UsersDAO.class);
            List<Users> users = service.getList();
            for (Users user1: users){
              if (user1.getLogin().equals(user) 
                      && user1.getPassword().equals(pass)){
                    link = HelpClass.MD5Util.md5Custom
                            (String.valueOf(System.currentTimeMillis()));
                     System.out.println(user1.getLogin() + user1.getPassword() + "|||" + user1.getStatus());
                     con = true;
                     user1.setAuntification(link);
                     service.update(user1);
                     status = user1.getStatus();
                     auntlink = new Cookie("auntlink", link);
                     break;
              } 
            }
            if (con == true && status.equals(User_status.admin.toString()) ){
                response.addCookie(auntlink);
                response.sendRedirect("StartpageAdminCabinet");
            }else if(con == true && status.equals(User_status.registry.toString())){
                response.addCookie(auntlink);
                response.sendRedirect("StartPageRegistry");
            }else if(con == true && status.equals(User_status.doctors.toString())){
                response.addCookie(auntlink);
                response.sendRedirect("StartPageRegistry");
            } else {
                response.sendError(401, "bad credentials");
            }
                
        }else{
            response.sendError(401, "bad credentials");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
