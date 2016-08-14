/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.Admin;

import HospitalWeb.domain.Spcialialization;
import HospitalWeb.domain.Users;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
/**
 *
 * @author Жека
 */
@Controller
public class AdminControllerUsers {
    @Autowired
     SpecialalizationService specService;
     
     @Autowired
     UserService userService;
     
     @RequestMapping(value = {"**/admin/admincabinet"}, method = {RequestMethod.GET})
    public ModelAndView getUsersList(){
        ModelAndView model = new ModelAndView();
        List<Users> uList = userService.getList();
        model.addObject("Specialalization",specService.getList());
        model.setViewName("Admin/admincabinet");
        model.addObject("users", uList);
        return model;
    }
    
        @RequestMapping(value = {"/admin/useredit/{id}"}, method = {RequestMethod.GET})
        public ModelAndView getUsersById(
                @PathVariable("id")int id){
            ModelAndView model = new ModelAndView();
            Users user = userService.getById(id);
            model.addObject("Specialalization",specService.getList());
            model.setViewName("Admin/edituser");
            model.addObject("user", user);
            return model;
        }
        
          @RequestMapping(value = {"/admin/userdelete/{id}"}, method = {RequestMethod.GET})
           public String deleteUsers(
                @PathVariable("id")int id){
               
               System.out.println("HospitalWeb.controller.Admin.AdminControllerUsers.deleteUsers()" + id);
             if (!(("admin").equals(userService.getById(id).getStatus()))){
                 userService.changeStatus(id);
             }
//            model.addObject("Specialalization",specService.getList());
//            model.setViewName("Admin/edituser");
//            model.addObject("user", user);
             return "redirect:/admin/admincabinet";
        }

        @RequestMapping(value = {"/admin/useredit/saveuser/{id}"}, method = {RequestMethod.POST})
       public String updateUser(
               @PathVariable("id")int id,
               @RequestParam("firstname") String firstname,
               @RequestParam("LastName") String lastname,
               @RequestParam("Exp") Integer exp,
               @RequestParam("Foto") String foto,
               @RequestParam("Sprcia") Integer sprcia,
               @RequestParam("Telephon") String telephon,
               @RequestParam("Email") String email,
               @RequestParam("Group") String Group) {
           ModelAndView mv = new ModelAndView();
           Users user = new Users();
            user.setName(firstname);    
            user.setSnme(lastname);
            user.setStatus(Group);
            user.setExp(exp);
            user.setIdspecialization(specService.getById(sprcia));          
            user.setEmail(email);
            user.setTelephone(telephon);
            user.setStatusWork(true);  
            userService.update(user);
   //        usersService.updateUser(user);
   //        mv.setViewName("user/edituser");
   //        mv.addObject("user", user);
           return "redirect:/admin/admincabinet";
        }
        
       @RequestMapping(value = {"/admin/adddoctors"}, method = {RequestMethod.POST})
           public ModelAndView goToAddUsers(){
                ModelAndView model = new ModelAndView();
                model.addObject("Specialalization",specService.getList());
            model.setViewName("Admin/adddoctors");
             return model;
        }
           
            @RequestMapping(value = {"/admin/saveuser"}, method = {RequestMethod.POST})
       public String saveUser(
               @RequestParam("firstname") String firstname,
               @RequestParam("LastName") String lastname,
               @RequestParam("Exp") Integer exp,
               @RequestParam("Foto") String foto,
               @RequestParam("Sprcia") Integer sprcia,
               @RequestParam("Telephon") String telephon,
               @RequestParam("Email") String email,
               @RequestParam("Login") String login,
               @RequestParam("Pasw") String pasw,
               @RequestParam("Group") String Group) {
           ModelAndView mv = new ModelAndView();
           Users user = new Users();
            user.setName(firstname);    
            user.setSnme(lastname);
            user.setStatus(Group);
            user.setExp(exp);
            user.setIdspecialization(specService.getById(sprcia));          
            user.setEmail(email);
            user.setTelephone(telephon);
            user.setLogin(login);
            user.setPassword(new ShaPasswordEncoder().encodePassword("admin", null));
            System.out.println(user.getPassword());
            user.setStatusWork(true);  
            user.setStatusregistr(false);
            userService.save(user);
             
   //        usersService.updateUser(user);
   //        mv.setViewName("user/edituser");
   //        mv.addObject("user", user);
           return "redirect:/admin/admincabinet";
        }
}
       