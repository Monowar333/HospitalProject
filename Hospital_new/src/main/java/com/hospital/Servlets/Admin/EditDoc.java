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
import java.io.PrintWriter;
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
@WebServlet(name = "EditDoc", urlPatterns = {"/EditDoc"})
public class EditDoc extends HttpServlet {
    Boolean con = true;
       private String referer ;
       private String  FirstName;
       private String LastName;
       private String Exp;
       private String Foto;
       private String NickName;
       private String Email;
       private String Pasw;
       private String Sprcia;
       private String Telephone;
       private String Groups;
       private String Groups1;
       private List<String> error;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        }   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        Users user = new Users();
         ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                    UsersDAO service = contex.getBean(UsersDAO.class);
        user = service.getById(id);
        try{
          if(user == null){
            throw new IllegalArgumentException();}
          }catch (IllegalArgumentException ex1){
            response.sendError(404,"users not faund");
            }
             ApplicationContext contex1 = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                    SpecialalizationDAO service1 = contex.getBean(SpecialalizationDAO.class);
            request.setAttribute("Specialalization", service1.getList());
            request.setAttribute("user", user);
            RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Admin/EditUser.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
        FirstName = request.getParameter("firstname");
        LastName =  request.getParameter("LastName");
        Exp = request.getParameter("Exp");
        Foto = request.getParameter("Foto");
        Email = request.getParameter("Email");
        Sprcia = request.getParameter("Sprcia");
        Telephone = request.getParameter("Telephon");
        Groups = request.getParameter("Group");
        error = validate();
    
        if (error.size() != 0 ){
//            SpecialalizationDAO spec = new SpecialalizationDAO();
//                    request.setAttribute("Specialalization",spec.getList() );
//                    request.setAttribute("error", error);
//                    request.setAttribute("firstname", FirstName);
//                    request.setAttribute("LastName", LastName);
//                    request.setAttribute("Exp", Exp);
//                    request.setAttribute("id", id);
//                    request.setAttribute("Email", Email);
//                    request.setAttribute("Telephon", Telephone);
//                    request.setAttribute("error", error);
                    RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("StartpageAdminCabinet");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
        }else {
          try { 
                ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                    UsersDAO service = contex.getBean(UsersDAO.class);
            Users user = new Users();
            user = service.getById(id);
            user.setName(FirstName);    
            user.setSnme(LastName);
            user.setStatus(Groups);
            user.setExp(HelpClass.WorkWithTransformation.StringToInt(Exp));            
            Spcialialization spe = new Spcialialization();
            user.setIdspecialization((Spcialialization)
                 new SpecialalizationDAO().getById(
                         HelpClass.WorkWithTransformation.StringToInt(Sprcia)));          
            user.setEmail(Email);
            user.setTelephone(Telephone);
            user.setStatusWork(true);  
            service.update(user);
            response.sendRedirect("StartpageAdminCabinet");
          }catch (Exception ex){
             response.sendError(500, "Ошибка работы с БД");
         }      
            
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private List<String> validate (){
        Regular reg = new Regular();
        List<String> errList1 = new ArrayList<>();
         if (reg.regEmail(Email) == false || Email.length()==0){
             errList1.add("Неверный форат Email");
         }
         if (reg.regTelephone(Telephone) == false || Telephone.length()==0){
            errList1.add("Неверный форат Телефон");
         }
         if (reg.regName(FirstName) == false || FirstName.length()==0){
            errList1.add("Имя должно содержать только латинские символы");
         }
         if (reg.regName(LastName) == false || LastName.length()==0){
             System.out.println(reg.regName(LastName));
            errList1.add("Фамилия должна содержать только латинские символы");
         }
         return errList1;
    }
}
