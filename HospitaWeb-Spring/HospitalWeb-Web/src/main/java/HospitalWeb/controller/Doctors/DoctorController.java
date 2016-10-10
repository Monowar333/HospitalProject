/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.Doctors;

import HospitalWeb.HelpClass.Creatnumbercard;
import HospitalWeb.domain.Card;
import HospitalWeb.domain.Prescription;
import HospitalWeb.domain.Prescriptiondeteil;
import HospitalWeb.domain.Provisionaldiagnosis;
import HospitalWeb.domain.Reception;
import HospitalWeb.domain.Users;
import HospitalWeb.service.CardService;
import HospitalWeb.service.MedicationsService;
import HospitalWeb.service.PrescriptionService;
import HospitalWeb.service.PrescriptiondeteilService;
import HospitalWeb.service.ProvisionaldiagnosisService;
import HospitalWeb.service.ReceptionService;
import HospitalWeb.service.SpecialalizationService;
import HospitalWeb.service.UserService;
import HospitalWeb.web.springconfig.ReceptionValidate;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     
     @Autowired
     PrescriptionService prescriptionService;
     
     @Autowired
     ProvisionaldiagnosisService provisionaldiagnosisService;
     
     @Autowired
     MedicationsService medicationsService;
     
     @Autowired
     PrescriptiondeteilService prescriptiondeteilService;
     
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
    
    @RequestMapping(value = {"**/doctors/listreception"}, method = {RequestMethod.POST})
    public ModelAndView getReceptionList(){
        Users us = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user1 = userService.getById(us.getId());
        ModelAndView model = new ModelAndView();
        List<Reception> receptionList = (List<Reception>) user1.getReceptionCollection();
        model.addObject("Specialalization",specService.getList());
        model.addObject("receptionlist",receptionList);
        model.setViewName("Doctor/receptionlist");
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
        model.addObject("provisionaldiagnosis",provisionaldiagnosisService.getList());
        model.setViewName("Doctor/addreception");
        model.addObject("reception", reception);
        model.addObject("idcard1", cardService.getList());
        return model;
    }
    
    @RequestMapping(value = {"**/doctors/savereceptionandprescription"}, method = {RequestMethod.POST})
    public String saveReceptionandprescription(
                  HttpServletRequest request, 
                  HttpServletResponse response,
                  Model model, 
                  @ModelAttribute("idUsers1") Integer idUsers,
                  @ModelAttribute("provisionaldiagnosis") Integer idprovisionaldiagnosis,
                  @ModelAttribute("idcard1") Integer idcard,
                  @ModelAttribute("time1") String time,
                  @ModelAttribute("reception") Reception reception,
                   BindingResult result
        ){
        Users us = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         receptionValidate.validate(reception, result);
               if(result.hasErrors()){
                    model.addAttribute("Specialalization",specService.getList());
                    model.addAttribute("date",new Creatnumbercard());
                    model.addAttribute("provisionaldiagnosis",provisionaldiagnosisService.getList());
                    model.addAttribute("reception", reception);
                    model.addAttribute("idcard1", cardService.getList());
                  return "Doctor/addreception";
                }
        reception.setIdUsers(us);
        Integer i = savereception(idprovisionaldiagnosis, idcard, time, reception);
        Prescription pre = new Prescription();
        pre.setIdreception(receptionService.getById(i));
        Integer j = prescriptionService.save(pre);
        Cookie cookie = new Cookie("prescriptionid", j.toString());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        model.addAttribute("Specialalization",specService.getList());
        model.addAttribute("user",us);
        model.addAttribute("medications",medicationsService.getList());
        return "Doctor/addprescription";
    }
    
    
    @RequestMapping(value = {"**/doctors/savereception"}, method = {RequestMethod.POST})
    public String saveReception(
                  Model model, 
                  @ModelAttribute("idUsers1") Integer idUsers,
                  @ModelAttribute("provisionaldiagnosis") Integer idprovisionaldiagnosis,
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
                    model.addAttribute("provisionaldiagnosis",provisionaldiagnosisService.getList());
                    model.addAttribute("reception", reception);
                    model.addAttribute("idcard1", cardService.getList());
                  return "Doctor/addreception";
                }
        savereception(idprovisionaldiagnosis, idcard, time, reception);
        return "redirect:/doctors/doctorcabinet";
    }
    
    
    @RequestMapping(value = {"**/doctors/addmedication"}, method = {RequestMethod.POST})
    @ResponseBody
    public void addmedication(
                  @CookieValue(value = "prescriptionid", required = false) Cookie cookieName, 
                  HttpServletRequest request,
                  @ModelAttribute("medications") Integer medications,
                  @ModelAttribute("indicationsforuse") String indicationsforuse
        ){
        System.out.println(cookieName);
        Prescriptiondeteil prescr = new Prescriptiondeteil();
        prescr.setIndicationsforuse(indicationsforuse);
        prescr.setIdmedication(medicationsService.getById(medications));
        prescr.setIdprescription(prescriptionService.getById(Integer.valueOf(cookieName.getValue())));
        prescriptiondeteilService.save(prescr);
    }
    
   @RequestMapping(value = "**/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadMedicationList(
         @CookieValue(value = "prescriptionid", required = false) Cookie cookieName
        ) {
        Prescription pre = prescriptionService.getById(Integer.valueOf
                                                       (cookieName.getValue()));
        List<Prescriptiondeteil> prescriptionDeteil = 
                prescriptiondeteilService.getByIdprescription(pre);
        return new ModelAndView("pdfView", "prescriptionDeteil", prescriptionDeteil);
    }
    
    @RequestMapping(value = "**/watchMedicationLis/{id}", method = RequestMethod.GET)
    public ModelAndView watchMedicationList(
         @PathVariable("id")int id
        ) { 
        Reception rec = receptionService.getById(id);
        System.out.println(rec.getPrescriptionList());
        if(null != rec.getPrescriptionList()){
        List<Prescriptiondeteil> prescriptionDeteil = 
                prescriptiondeteilService.
                        getByIdprescription(rec.getPrescriptionList().get(0));
        return new ModelAndView("pdfView", "prescriptionDeteil", prescriptionDeteil);
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("Doctor/404");
        return model;
    }
    public Integer savereception( Integer idprovisionaldiagnosis,
            Integer idcard, String time, Reception reception){
        Card card = cardService.getById(idcard);
        Integer i = null;
        Provisionaldiagnosis provi =
                provisionaldiagnosisService.getById(idprovisionaldiagnosis);
        reception.setIdCard(card);
        reception.setIdprovisionaldiagnosis(provi);
        Date da;
               try{
                String[] s = time.split("-");
                da = new Date((Integer.valueOf(s[2]) - 1900), 
                        (Integer.valueOf(s[1]) - 1), 
                        Integer.valueOf(s[0]));          
                reception.setTime(da);  
               }catch (Exception ex){
                   
               }
        i = receptionService.save(reception);
        return i;
        
    }
}
