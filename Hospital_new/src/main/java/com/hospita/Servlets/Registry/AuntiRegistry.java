/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospita.Servlets.Registry;

import DB.entity.Users;
import com.hospital.DAO.User_status;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Жека
 */
@WebFilter(filterName = "AuntiRegistry")
public class AuntiRegistry implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
       System.out.println("registry filtr");
//        String s = ;
        Users us1;
        us1 = (Users) request.getAttribute("userauintf");
        try{
            System.out.println(us1.getStatus() + "sdasdsda");
            if(!(us1.getStatus()).equals(User_status.registry.toString())){
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
