/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.Admin;


import HospitalWeb.domain.Spcialialization;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.web.springconfig.SpecializationValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Жека
 */
@Controller
public class AdminControllerSpecialization {
    @Autowired
       SpecialalizationService specService;
    
    @Autowired
     SpecializationValidate specializationValidate;
    
    @RequestMapping(value={"/admin/specialization"}, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView specList(){
        ModelAndView model = new ModelAndView();
        model.addObject("Specialalization", specService.getList());
        model.addObject("addoredit",true);
        model.addObject("specialization",new Spcialialization());
        model.setViewName("Admin/addspecialization");
        return model;
    }
    
    @RequestMapping(value = {"/admin/addspec"}, method = {RequestMethod.POST})
       public String saveSpecialization(Model model, @ModelAttribute("specialization") Spcialialization spec, BindingResult result){ 
           specializationValidate.validate(spec, result);
               if(result.hasErrors()){
                   model.addAttribute("addoredit",true);
                   model.addAttribute("Specialalization",specService.getList());
                    model.addAttribute("specialization",spec);
                  return "Admin/addspecialization";
                }
              specService.save(spec);
           return "redirect:/admin/specialization";
        }
       
       
       @RequestMapping(value = {"/admin/deletespecalization/{id}"}, method = {RequestMethod.GET})
           public void deleteSpec(
                @PathVariable("id")int id){
               System.out.println("ready");
               Spcialialization spec = specService.getById(id);
               System.out.println("HospitalWeb.controller.Admin.AdminControllerUsers.deleteUsers()" + id);
             if (!(("Default").equals(spec.getName()))){
                 specService.remove(spec);
             }
             System.out.println("ready");
           //  return "redirect:/admin/admincabinet";
        }
           
        @RequestMapping(value = {"/admin/editspec/{id}"}, method = {RequestMethod.GET})
           public ModelAndView editSpec(
                @PathVariable("id")int id){
               ModelAndView model = new ModelAndView();
               System.out.println("ready");
               model.addObject("Specialalization", specService.getList());
               model.addObject("addoredit",false);
               model.addObject("specialization",specService.getById(id));
               model.setViewName("Admin/addspecialization");
               return model;
           //  return "redirect:/admin/admincabinet";
        }
           
           @RequestMapping(value = {"/admin/editspec/{id}"}, method = {RequestMethod.POST})
           public String saveEditSpec(
                @ModelAttribute("specialization") Spcialialization spec){
               specService.update(spec);
               return "redirect:/admin/specialization";
           //  return "redirect:/admin/admincabinet";
        }
    
}
