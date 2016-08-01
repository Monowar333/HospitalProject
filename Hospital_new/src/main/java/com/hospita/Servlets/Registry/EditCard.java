/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospita.Servlets.Registry;

import HelpClass.Dirthday;
import DB.entity.Card;
import com.hospital.DAO.CardDAO;
import com.hospital.Serviseconfig.ServiseConfig;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Жека
 */
@WebServlet(name = "EditCard", urlPatterns = {"/EditCard"})
public class EditCard extends HttpServlet {
    private String number;
    private String dateRegistr;
    private String name;
    private String sname;
    private String dayofBirthdey;
    private String monthofBirthdey;
    private String yearofBirthdey;
    private String address;
    private String telephone;
    private String email;
    private List<String> error;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
                    int id = 0;
               try{                    
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
                    CardDAO servise = contex.getBean(CardDAO.class);
//                    Card card1 = new CardDAO().getById(id);
//                    System.out.println(card1.getDateRegistr());
                    Dirthday date = new Dirthday();
                    request.setAttribute("date", date);
                    request.setAttribute("cardch", servise.getById(id));
                    RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Registry/EditCard.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
                    
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        number = request.getParameter("number");
        dateRegistr = request.getParameter("dateRegistr");
        name = request.getParameter("name");
        sname = request.getParameter("sname");
        dayofBirthdey = request.getParameter("day");
        monthofBirthdey = request.getParameter("month");
        yearofBirthdey = request.getParameter("year");
        address = request.getParameter("address");
        telephone = request.getParameter("telephone");
        email = request.getParameter("email");
//        error = validate();
//        System.out.println(error.size());
//        if (error.size() != 0){
//            Dirthday date = new Dirthday();
//            request.setAttribute("number", number);
//            request.setAttribute("dateRegistr", dateRegistr);
//            request.setAttribute("error", error);
//            request.setAttribute("date", date);
//            request.setAttribute("name", name);
//            request.setAttribute("sname", sname);
//            request.setAttribute("address", address);
//            request.setAttribute("telephone", telephone);
//            request.setAttribute("email", email);
//              RequestDispatcher dispatcher1 = 
//                    request.getRequestDispatcher("WEB-INF/Registry/AddCard.jsp");
//                    if(dispatcher1 != null){
//                    dispatcher1.forward(request, response);
//                    }
//        
//        } else{
         int id = 0;
        try{
            id = HelpClass.WorkWithTransformation.
                    StringToInt(request.getParameter("id"));
            if(id <= 0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException ex){
            response.sendError(404,"invalid param");
        }
        try {
            // учитывая особености класса sql.Date  необходимо было отнимать 1 от месяца
            // и 1900 от года 
            Card card = new CardDAO().getById(id);
            card.setNumber(number);
            String[] s = dateRegistr.split("-");
            Date da = new Date(HelpClass.WorkWithTransformation.StringToInt(s[2]) - 1900,
                    HelpClass.WorkWithTransformation.StringToInt(s[1]) - 1,
                    HelpClass.WorkWithTransformation.StringToInt(s[0]));          
            card.setDateRegistr(da);
            card.setName(name);
            card.setSname(sname);
            da = new Date(HelpClass.WorkWithTransformation.StringToInt(yearofBirthdey) - 1900,
                    HelpClass.WorkWithTransformation.StringToInt(monthofBirthdey) - 1,
                    HelpClass.WorkWithTransformation.StringToInt(dayofBirthdey));
            card.setDateofBirthdey(da);
            card.setAddress(address);
            card.setTelephone(telephone);
            card.setEmail(email);
            card.setStatus(true);
           ApplicationContext contex = 
                            new AnnotationConfigApplicationContext(ServiseConfig.class);
                    CardDAO servise = contex.getBean(CardDAO.class);
            servise.update(card);

            
        }catch (Exception ex){
            response.sendError(500, "Ошибка работы с БД");
        }
//        }
            response.sendRedirect("StartPageRegistry");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
