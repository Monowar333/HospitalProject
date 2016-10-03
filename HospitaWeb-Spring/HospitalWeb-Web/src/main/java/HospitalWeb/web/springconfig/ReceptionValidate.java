/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;

import HospitalWeb.domain.Reception;
import HospitalWeb.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author Жека
 */
public class ReceptionValidate implements  Validator{
     @Autowired
        ReceptionService cardService;
    
  

    @Override
    public boolean supports(Class<?> clazz) {
        return Reception.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       Reception reception = (Reception) target;
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "complaints", "complaints.empty", "complaints must not be empty.");                
//                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "provisionaldiagnosis", "provisionaldiagnosis.empty", "provisionaldiagnosis must not be empty.");          
    }
    
}
