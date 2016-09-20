/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.Admin;

import HospitalWeb.Validate.UsersValidateDate;
import HospitalWeb.domain.Users;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.UserService;
import HospitalWeb.web.springconfig.UserVAlidateUpdate;
import HospitalWeb.web.springconfig.UsersValidate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Жека
 * It is controller used for Admin - role 
 * Realizetion next functions
 *  add user + validate + send email to accept registr
 *  update user + validate
 *  delete user(change status work)
 *  show all users 
 * 
 * 
 */
@Controller
public class AdminControllerUsers {
    @Autowired
     SpecialalizationService specService;

     
     @Autowired
     UserService userService;
     
     @Autowired
     UsersValidate usersvalidate;
     
     @Autowired
     UserVAlidateUpdate usersupdatevalidate;
     
     //    @Autowired
//     SendMail sendMail;
     
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
            model.addObject("usersupdate", user);
            return model;
        }
        
          @RequestMapping(value = {"/admin/userdelete/{id}"}, method = {RequestMethod.GET})
           public String deleteUsers(
                @PathVariable("id")int id){
             if (!(("admin").equals(userService.getById(id).getStatus()))){
                 userService.changeStatus(id);
             }
             return "redirect:/admin/admincabinet";
        }

        @RequestMapping(value = {"/admin/useredit/updatruser/**"}, method = {RequestMethod.POST})
       public String updateUser(
               @RequestParam("id")int id,
               @RequestParam("idspecialization1")int idspecialization,
               Model model, @ModelAttribute("usersupdate") Users users, 
               BindingResult result
              ) {
                usersupdatevalidate.validate(users, result);
                    if(result.hasErrors()){
                         usersvalidate.getClass();
                        model.addAttribute("Specialalization",specService.getList());
                         model.addAttribute("users",users);
                         System.out.println(result.getAllErrors());
                       return "Admin/edituser";
                     }

                  
           Users user = userService.getById(id);
            user.setName(users.getName());    
            user.setSnme(users.getSnme());
            user.setStatus(users.getStatus());
            user.setExp(users.getExp());
            user.setIdspecialization(specService.getById(idspecialization));          
            user.setEmail(users.getEmail());
            user.setTelephone(users.getTelephone());
            user.setStatusWork(true);  
            userService.update(user);
           return "redirect:/admin/admincabinet";
        }
        
       @RequestMapping(value = {"/admin/adddoctors"}, method = {RequestMethod.POST, RequestMethod.GET})
           public ModelAndView goToAddUsers(){
                ModelAndView model = new ModelAndView();
                model.addObject("Specialalization",specService.getList());
                model.addObject("users",new UsersValidateDate());
            model.setViewName("Admin/adddoctors");
             return model;
        }
           
            @RequestMapping(value = {"/admin/saveuser"}, method = {RequestMethod.POST})
       public String saveUser(Model model, @ModelAttribute("users") UsersValidateDate users, BindingResult result){
               usersvalidate.validate(users, result);
               if(result.hasErrors()){
                    usersvalidate.getClass();
                   model.addAttribute("Specialalization",specService.getList());
                    model.addAttribute("users",users);
                  return "Admin/adddoctors";
                }
              Users user1 = new Users();
              String registrlink =users.getLogin() + 
                    new ShaPasswordEncoder().encodePassword(String.valueOf(System.currentTimeMillis()), null);
              String link = "<a href=\"http://localhost:8087/Hospital_new/AcceptRegistr?param="
                    + registrlink + "\">" + registrlink + "</a>";
                System.out.println( user1.getId());
            user1.setName(users.getName());    
            user1.setSnme(users.getSnme());
            user1.setExp(users.getExp());
            user1.setIdspecialization(specService.getById(users.getIdspecializationInt()));
            user1.setStatus(users.getStatus());
            user1.setLogin(users.getLogin());
            user1.setPassword(new ShaPasswordEncoder().encodePassword(users.getPassword(), null));
            user1.setEmail(users.getEmail());
            user1.setTelephone(users.getTelephone());
            user1.setLinkaccept(registrlink);
            user1.setStatusWork(true); 
            user1.setStatusregistr(false);              
             //new SendMail().sendMail(email, firstname,link); 
            //отправка письма на подтверждение регистрации 
           return "redirect:/admin/admincabinet";
        }
}
       