/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.AllUsers;


import HospitalWeb.domain.Spcialialization;
import HospitalWeb.domain.Users;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.SpecialalizationServiceImpl;
import HospitalWeb.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Жека
 */
    @Controller
public class AllUsersController {
     @Autowired
     SpecialalizationService specService;
     
     @Autowired
     UserService userService;
     
      @RequestMapping(value = {"/","/StartPage"}, method = {RequestMethod.GET, RequestMethod.POST})
      public ModelAndView index(){
       // specService = new SpecialalizationServiceImpl();
        ModelAndView model = new ModelAndView();
        model.addObject("Specialalization",specService.getList());
        model.setViewName("AllUsers/StartPage");
        return model;
    }
        @RequestMapping(value = {"/Special/{id}","/**/Special/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
        @ResponseBody
        public ModelAndView getDoctorsList(
                @PathVariable("id")int id){
            ModelAndView model = new ModelAndView();
            Spcialialization spec = specService.getById(id);
            List<Users> userspec = userService.getBySpec(spec);
                System.out.println(id + "  fsdfsdfsdfs");
            model.addObject("users",userspec);
            model.addObject("Specialalization",specService.getList());
            model.setViewName("/AllUsers/DoctorsForSpecialization");
            return model;
        }
    
    @RequestMapping(value = {"/Special/SelectDoctors/{id}","/**/Special/SelectDoctors/{id}"}, method = {RequestMethod.GET})
    public ModelAndView getSelectDoctor(
            @PathVariable("id")int id){
        ModelAndView model = new ModelAndView();
        Users user = userService.getById(id);
        model.addObject("user",user);
        model.addObject("Specialalization",specService.getList());
        model.setViewName("AllUsers/AboutDoctor");
        return model;
    }
    
  
}
