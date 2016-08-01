/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospita.Servlets.Registry;

import DB.entity.Card;

import HelpClass.Creatnumbercard;
import HelpClass.Dirthday;
import HelpClass.Regular;
import com.hospital.DAO.CardDAO;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Жека
 */
    @WebServlet(name = "AddCard", urlPatterns = {"/AddCard"})
public class AddCard extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Creatnumbercard number = new Creatnumbercard();
        Dirthday date = new Dirthday();
        request.setAttribute("number", number.getNumber());
        request.setAttribute("date", date);
        request.setAttribute("dateRegistr", number.getDateregistr2());
       
        RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Registry/AddCard.jsp");
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
        error = validate();
        System.out.println(error.size());
        if (error.size() != 0){
            Dirthday date = new Dirthday();
            request.setAttribute("number", number);
            request.setAttribute("dateRegistr", dateRegistr);
            request.setAttribute("error", error);
            request.setAttribute("date", date);
            request.setAttribute("name", name);
            request.setAttribute("sname", sname);
            request.setAttribute("address", address);
            request.setAttribute("telephone", telephone);
            request.setAttribute("email", email);
              RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Registry/AddCard.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
        
        } else{
        try {
            // учитывая особености класса sql.Date  необходимо было отнимать 1 от месяца
            // и 1900 от года 
            Card card = new Card();
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
            CardDAO cardsave = new CardDAO();
            cardsave.save(card);

            
        }catch (Exception ex){
            response.sendError(500, "Ошибка работы с БД");
        }
        }
            response.sendRedirect("StartPageRegistry");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
      private List<String> validate (){
        Regular reg = new Regular();
        List<String> errList1 = new ArrayList<>();
        if ( (email.length() != 0) && 
                (email.length() != 0)){
            if (reg.regEmail(email) == false){
                errList1.add("Неверный форат Email");
            }
        }
         
            if ((telephone.length() != 0) && 
                    (reg.regTelephone(telephone) == false)){
               errList1.add("Неверный форат Телефон");
            }
         
         if (reg.regName(name) == false || 
                 name.length()==0){
            errList1.add("Имя должно содержать только латинские символы");
         }
         if (reg.regName(sname) == false || 
                 sname.length()==0){
             System.out.println(reg.regName(sname));
            errList1.add("Фамилия должна содержать только латинские символы");
         }
         
          if (address.length() == 0){
             System.out.println(reg.regName(address));
            errList1.add("Неверный формат адресса");
         }
        
//          UsersDAO usselect = new UsersDAO();
//             List<Users> listus = usselect.getList();
//             for (Users us: listus){
//                 if ( us.getLogin().equals(NickName)){
//                     errList1.add("такой логин уже существует");
//                 }else if(us.getEmail().equals(Email)){
//                      errList1.add("такая почта уже используться");
//                 }
//             }
         return errList1;
    }
}
