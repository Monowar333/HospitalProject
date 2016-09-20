/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.Registry;

import HospitalWeb.HelpClass.Creatnumbercard;
import HospitalWeb.HelpClass.DateCreate;
import HospitalWeb.domain.Card;
import HospitalWeb.service.CardService;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.web.springconfig.CardValidate;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RegistryConttrolerCards {
   @Autowired
   CardService cardService;
   
    @Autowired
       SpecialalizationService specService;
      @Autowired
      CardValidate cardValidate;
      
   @RequestMapping(value={"/registry/cards"}, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView cardList(){
        ModelAndView model = new ModelAndView();
        model.addObject("cardlist", cardService.getList());
         model.addObject("Specialalization",specService.getList());
        model.setViewName("Registry/registrycabinet");
        return model;
    }
    
    @RequestMapping(value = {"/registry/addcard"}, method = {RequestMethod.POST, RequestMethod.GET})
           public ModelAndView goToAddCards(){
                ModelAndView model = new ModelAndView();
                model.addObject("Specialalization",specService.getList());
                model.addObject("date",new DateCreate());
                model.addObject("number",new Creatnumbercard());
                model.addObject("card",new Card());
                model.setViewName("Registry/addcard");
               return model;
        }
           
           
    @RequestMapping(value = {"/registry/savecard"}, method = {RequestMethod.POST, RequestMethod.GET})
          public String saveCard(Model model, 
                  @ModelAttribute("number") String number,
                  @ModelAttribute("dateRegistr1") String dateRegistr,
                  @ModelAttribute("day") Integer day,
                  @ModelAttribute("month") Integer month,
                  @ModelAttribute("year") Integer year,
                  @ModelAttribute("card") Card card, 
                  BindingResult result){
               cardValidate.validate(card, result);
               if(result.hasErrors()){
                   System.out.println(result.getAllErrors());
                    model.addAttribute("Specialalization",specService.getList());
                    model.addAttribute("date",new DateCreate());
                    model.addAttribute("number",new Creatnumbercard());
                    model.addAttribute("card",card);
                  return "Registry/addcard";
                }
               Date da;
               try{
                String[] s = dateRegistr.split("-");
                da = new Date((Integer.valueOf(s[2]) - 1900), 
                        (Integer.valueOf(s[1]) - 1), 
                        Integer.valueOf(s[0]));          
                card.setDateRegistr(da);  
               }catch (Exception ex){
                   Logger.getLogger(RegistryConttrolerCards.class.getName()).log(Level.SEVERE, null, ex);
               }
                card.setNumber(number);
                da = new Date(year - 1900, month - 1, day);
                card.setDateofBirthdey(da);
                card.setStatus(true);
                cardService.save(card);
               return "redirect:/registry/cards";
        }
          
          @RequestMapping(value = {"/registry/carddelete/{id}"}, method = {RequestMethod.GET})
           public String deleteCard(
                @PathVariable("id")int id){
            cardService.changeStatus(id);
            return "redirect:/registry/cards";
        }
           
            @RequestMapping(value = {"/registry/cardupdate/{id}"}, method = {RequestMethod.GET})
            public ModelAndView updateCard(
                @PathVariable("id")int id){
            ModelAndView model = new ModelAndView();
                Card card = cardService.getById(id);
                model.addObject("Specialalization",specService.getList());
                model.addObject("date",new DateCreate());
                model.addObject("dateRegistr1",card.getDateRegistr().toString());
                model.addObject("card", card);
                model.setViewName("Registry/editcard");
               return model;
        }
            
             @RequestMapping(value = {"/registry/cardupdate/saveupdate"}, method = {RequestMethod.POST, RequestMethod.GET})
          public String saveupdateCard(Model model,
                  @ModelAttribute("id") Integer id,
                  @ModelAttribute("number") String number,
                  @ModelAttribute("dateRegistr1") String dateRegistr,
                  @ModelAttribute("day") Integer day,
                  @ModelAttribute("month") Integer month,
                  @ModelAttribute("year") Integer year,
                  @ModelAttribute("card") Card card, 
                  BindingResult result){
               cardValidate.validate(card, result);
               if(result.hasErrors()){
                   System.out.println(result.getAllErrors());
                    model.addAttribute("Specialalization",specService.getList());
                    model.addAttribute("date",new DateCreate());
                    model.addAttribute("dateRegistr1",dateRegistr);
                    model.addAttribute("card", card);
                    return "Registry/editcard";
                }
               Date da;
               try{
                String[] s = dateRegistr.split("-");
                da = new Date((Integer.valueOf(s[2]) - 1900), 
                        (Integer.valueOf(s[1]) - 1), 
                        Integer.valueOf(s[0]));          
                card.setDateRegistr(da);  
               }catch (Exception ex){
                   Logger.getLogger(RegistryConttrolerCards.class.getName()).log(Level.SEVERE, null, ex);
               }
                card.setNumber(number);
                da = new Date(year - 1900, month - 1, day);
                card.setDateofBirthdey(da);
                card.setStatus(true);
                cardService.update(card);
               return "redirect:/registry/cards";
        }
}
