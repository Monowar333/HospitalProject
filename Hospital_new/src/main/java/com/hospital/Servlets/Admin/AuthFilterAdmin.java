/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import DB.entity.Users;
import com.hospital.DAO.User_status;
import com.hospital.DAO.UsersDAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stan
 * Фильтр предназначенный для контроля роли Админа и разрешения доступа к 
 * определенным страницам
 */
@WebFilter(filterName = "AuthFilterAdmin")
public class AuthFilterAdmin implements Filter {
    

    private FilterConfig filterConfig = null;
    
    public AuthFilterAdmin() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        System.out.println("filter admin");
//        String s = ;
        Users us1;
        us1 = (Users) request.getAttribute("userauintf");
        try{
            if(!(us1.getStatus()).equals(User_status.admin.toString())){
                ((HttpServletResponse)response).sendError(401,"bad credentials");
            }else{
                chain.doFilter(request, response);
                //далее запрос переходит на сервлет на которій біл изначально отправлен запрос 
            }
                
            } catch (NullPointerException ex){ 
                request.setAttribute("info", false); 
                RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("StartServlet");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    } 
            }      
           
    }

    @Override
    public void destroy() { 
        System.out.println("Filter destroyed");
    }


    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        System.out.println("Filter created");
    }


    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

}
