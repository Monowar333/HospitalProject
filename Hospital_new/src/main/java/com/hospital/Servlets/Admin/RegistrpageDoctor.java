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
import com.hospital.email.SendMail;
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
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Жека
 */
@WebServlet(name ="Registrpage", urlPatterns = {"/Registrpage"})
public class RegistrpageDoctor extends HttpServlet {

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
       private String link;
       private String registrlink;
       private int id;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
         
        FirstName = request.getParameter("firstname");
        LastName =  request.getParameter("LastName");
        Exp = request.getParameter("Exp");
        Foto = request.getParameter("Foto");
        NickName = request.getParameter("NickName");
        Email = request.getParameter("Email");
        Pasw = request.getParameter("Pasw");
        Sprcia = request.getParameter("Sprcia");
        Telephone = request.getParameter("Telephon");
         Groups = request.getParameter("Group");
         error = validate();
         if (error.size() != 0 ){
                    ApplicationContext contex = 
                   new AnnotationConfigApplicationContext(ServiseConfig.class);
                     SpecialalizationDAO service = contex.getBean(SpecialalizationDAO.class);
                    request.setAttribute("Specialalization",service.getList() );
                    request.setAttribute("error", error);
                    request.setAttribute("firstname", FirstName);
                    request.setAttribute("LastName", LastName);
                    request.setAttribute("Exp", Exp);
                    request.setAttribute("NickName", NickName);
                    request.setAttribute("Email", Email);
                    request.setAttribute("Telephon", Telephone);
                    
                    RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Admin/AddDoctors.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
         }else {
           
         try {
             Users user = new Users();
             user.setName(FirstName);    
             user.setSnme(LastName);
             user.setExp(HelpClass.WorkWithTransformation.StringToInt(Exp));
            Spcialialization spe = new Spcialialization();
            user.setIdspecialization((Spcialialization)
                 new SpecialalizationDAO().getById(
                         HelpClass.WorkWithTransformation.StringToInt(Sprcia)));
             
            user.setStatus(Groups);
            user.setLogin(NickName);
            user.setPassword(Pasw);
            user.setEmail(Email);
            user.setTelephone(Telephone);
            user.setStatusWork(true); 
            user.setStatusregistr(false);
            registrlink =NickName + 
                    HelpClass.MD5Util.md5Custom(String.valueOf(System.currentTimeMillis()));
            link = "<a href=\"http://localhost:8087/Hospital_new/AcceptRegistr?param="
                    + registrlink + "\">" + registrlink + "</a>";
            user.setLinkaccept(registrlink);
             System.out.println(link);
              ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
                    UsersDAO service = contex.getBean(UsersDAO.class);
            id = service.save(user);
            
         }catch (Exception ex){
             response.sendError(500, "Ошибка работы с БД");
         }
    //    new SendMail().sendMail(Email, FirstName,link); 
    //отправка письма на подтверждение регистрации 
        

        response.sendRedirect("StartpageAdminCabinet");

      }            
    }           
    
         @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");

    
    }   
           
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
                
                
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
         if (reg.regLogin_pass(NickName) == false || NickName.length()==0){
            errList1.add("Неверный форат Логина");
         }
         if (reg.regLogin_pass(Pasw) == false || Pasw.length()==0){
            errList1.add("Неверный форат пароля");
         }
          UsersDAO usselect = new UsersDAO();
             List<Users> listus = usselect.getList();
             for (Users us: listus){
                 if ( us.getLogin().equals(NickName)){
                     errList1.add("такой логин уже существует");
                 }else if(us.getEmail().equals(Email)){
                      errList1.add("такая почта уже используться");
                 }
             }
         return errList1;
    }
    }


