/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.Doctors;

import HospitalWeb.HelpClass.Creatnumbercard;
import HospitalWeb.HelpClass.DateCreate;
import HospitalWeb.domain.Card;
import HospitalWeb.domain.Reception;
import HospitalWeb.domain.Users;
import HospitalWeb.service.CardService;
import HospitalWeb.service.ReceptionService;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.UserService;
import HospitalWeb.web.springconfig.ReceptionValidate;
import HospitalWeb.web.springconfig.UserVAlidateUpdate;
import HospitalWeb.web.springconfig.UsersValidate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Жека
 */
@Controller
public class DoctorController {
      @Autowired
     SpecialalizationService specService;

     
     @Autowired
     UserService userService;

     @Autowired
     ReceptionService receptionService;
     
     @Autowired
     CardService cardService;
     
     @Autowired
     ReceptionValidate receptionValidate;
     
     //    @Autowired
//     SendMail sendMail;
     
     @RequestMapping(value = {"**/doctors/doctorcabinet"}, method = {RequestMethod.GET})
    public ModelAndView getUsersList(){
        Users us = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView model = new ModelAndView();
        List<Users> uList = userService.getList();
        model.addObject("Specialalization",specService.getList());
        model.setViewName("Doctor/doctorcabinet");
        model.addObject("user", userService.getById(us.getId()));
        return model;
    }
    
    @RequestMapping(value = {"**/doctors/addreception"}, method = {RequestMethod.POST})
    public ModelAndView addReception(){
         Users us = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reception reception = new Reception();
        reception.setIdUsers(us);
        ModelAndView model = new ModelAndView();
        List<Users> uList = userService.getList();
        model.addObject("Specialalization",specService.getList());
        model.addObject("date",new Creatnumbercard());
        model.setViewName("Doctor/addreception");
        model.addObject("reception", reception);
        model.addObject("idcard1", cardService.getList());
        return model;
    }
    
    @RequestMapping(value = {"**/doctors/savereception"}, method = {RequestMethod.POST})
    public String saveReception(
                  Model model, 
                  @ModelAttribute("idUsers1") Integer idUsers,
                  @ModelAttribute("idcard1") Integer idcard,
                  @ModelAttribute("time1") String time,
                  @ModelAttribute("reception") Reception reception,
                   BindingResult result
        ){
        Users us = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reception.setIdUsers(us);
         receptionValidate.validate(reception, result);
               if(result.hasErrors()){
                   System.out.println(result.getAllErrors());
                    model.addAttribute("Specialalization",specService.getList());
                    model.addAttribute("date",new Creatnumbercard());
                    model.addAttribute("reception", reception);
                    model.addAttribute("idcard1", cardService.getList());
                  return "Doctor/addreception";
                }
        Card card = cardService.getById(idcard);
        reception.setIdCard(card);
        System.out.println(reception.getIdCard());
        System.out.println(reception.getIdUsers());
        System.out.println(reception.getProvisionaldiagnosis());
        System.out.println(reception.getComplaints());
        System.out.println(reception.getStatus());
        Date da;
               try{
                String[] s = time.split("-");
                da = new Date((Integer.valueOf(s[2]) - 1900), 
                        (Integer.valueOf(s[1]) - 1), 
                        Integer.valueOf(s[0]));          
                reception.setTime(da);  
               }catch (Exception ex){
                   
               }
        receptionService.save(reception);
        return "redirect:/doctors/doctorcabinet";
    }
}
