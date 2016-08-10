/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;

import DB.entity.Users;
import com.hospital.DAO.User_status;

import com.hospital.DAO.UsersDAO;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Жека
 */

/*
фильтр работающим при любом запросе от пользователя, кроме запросов 
на логин и логаут, формирует параметры для страницы меню и передает их дальше на 
оброботку(на фильтр или сервлет)
*/
@WebFilter(filterName = "AuntiAllUsers")
public class AuntiAllUsers implements Filter {
     private FilterConfig filterConfig = null;
    
     public AuntiAllUsers() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        System.out.println("firstfilter");    
        Cookie[] cookies = ((HttpServletRequest)request).getCookies();
        Cookie auntlink = null;
        System.out.println("Filtr working");
        if (cookies != null){
        for(Cookie c : cookies){
            if(c.getName().equals("auntlink")){
                    auntlink = c;
            }
        }    
        if((auntlink == null || auntlink.getValue() == "")){
            // System.out.println(auntlink.getValue() + "dasd");   
            request.setAttribute("info", false);
              chain.doFilter(request, response);
            
        }else{
            String link = auntlink.getValue();
            try{
            Users us  = new UsersDAO().getByAuntification(link);
            System.out.println(auntlink.getValue());
            request.setAttribute("info", true); 
            request.setAttribute("userauintf", us);
            request.setAttribute("username", us.getLogin());
            if (us.getStatus().equals(User_status.admin.toString())){
                request.setAttribute("adress123", "StartpageAdminCabinet");
            }else if(us.getStatus().equals(User_status.registry.toString())){
                request.setAttribute("adress123", "StartPageRegistry");
            }else {
                //request.setAttribute("adress", "StartpageAdminRegistry");
            }
                chain.doFilter(request, response);
           
            } catch (NullPointerException ex){ 
                request.setAttribute("info", false); 
                  chain.doFilter(request, response);  
            }
        }
        }
                    request.setAttribute("info", false); 
                  chain.doFilter(request, response);
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
