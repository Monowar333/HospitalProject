/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import DB.entity.Spcialialization;
import HelpClass.Regular;
import com.hospital.DAO.SpecialalizationDAO;
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
@WebServlet(name = "EditSpecialization", urlPatterns = {"/EditSpecialization"})
public class EditSpecialization extends HttpServlet {
    
    private String spename;
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
        SpecialalizationDAO service = contex.getBean(SpecialalizationDAO.class);
        Spcialialization special = new Spcialialization();
        special = service.getById(id);
        try{
          if(special == null){
            throw new IllegalArgumentException();}
          }catch (IllegalArgumentException ex1){
            response.sendError(404,"users not faund");
            }
           ApplicationContext contex1 = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
        SpecialalizationDAO service1 = contex1.getBean(SpecialalizationDAO.class);
            request.setAttribute("addoredit", false);
            request.setAttribute("specialization", service1.getList());
            request.setAttribute("specchange", special);
            RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("WEB-INF/Admin/AddSpecialization.jsp");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
       String spename  = request.getParameter("spename");
       int id = 0;
       try{
           id = HelpClass.WorkWithTransformation.
                   StringToInt(request.getParameter("id1"));
           if(id <= 0){
               throw new IllegalArgumentException();
           }
        }catch (IllegalArgumentException ex){
             response.sendError(404,"invalid param");
        }
        System.out.println(id);
        ApplicationContext contex = 
                new AnnotationConfigApplicationContext(ServiseConfig.class);
        SpecialalizationDAO service = contex.getBean(SpecialalizationDAO.class);
//        error = validate();
//         if (error.size() != 0 ){
//                    request.setAttribute("addoredit", false);
//                    request.setAttribute("specialization", spec.getList());
//                    request.setAttribute("error", error);
//                    RequestDispatcher dispatcher1 = 
//                    request.getRequestDispatcher("WEB-INF/Admin/AddSpecialization.jsp");
//                    if(dispatcher1 != null){
//                    dispatcher1.forward(request, response);
//                    }
//         }else {
             try {
                 
                Spcialialization spe = new Spcialialization();
                spe = service.getById(id);
                spe.setName(spename);
                service.update(spe);
            }catch (Exception ex){
                response.sendError(500, "Ошибка работы с БД");
            }
             request.setAttribute("addoredit", true);
             request.setAttribute("specialization", service.getList());
                RequestDispatcher dispatcher1 = 
                    request.getRequestDispatcher("/specialization");
                    if(dispatcher1 != null){
                    dispatcher1.forward(request, response);
                    }
         
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
   
    
//     private List<String> validate (){
//        Regular reg = new Regular();
//        List<String> errList1 = new ArrayList<>();
//         if ( (spename.length()== 0) || (reg.regName(spename) == false)){
//             errList1.add("Неверный формат название специализации");
//         }
//         
//          SpecialalizationDAO spselect = new SpecialalizationDAO();
//             List<Spcialialization> listus = spselect.getList();
//             for (Spcialialization us: listus){
//                 if ( us.getName().equals(spename)){
//                     errList1.add("такая специализация уже существует");
//                 }
//             }
//         return errList1;
//    }
    
}
