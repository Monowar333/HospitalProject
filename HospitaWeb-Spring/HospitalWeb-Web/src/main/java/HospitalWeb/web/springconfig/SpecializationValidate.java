/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;

import HospitalWeb.Validate.ValidatePattern;
import HospitalWeb.Validate.ValidateRegular;
import HospitalWeb.domain.Spcialialization;
import HospitalWeb.service.SpecialalizationService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Жека
 */
public class SpecializationValidate implements Validator{
      @Autowired
         ValidateRegular regular;
       
      @Autowired
     SpecialalizationService specService;
      
        private Pattern patern;
        private Matcher matcher;
        private final String name = ValidatePattern.name.pattern();
    @Override
    public boolean supports(Class<?> type) {
       return Spcialialization.class.isAssignableFrom(type);
    }

    @Override
    @ResponseBody
    public void validate(Object o, Errors errors) {
        Spcialialization spec = (Spcialialization) o;
        
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "specialization must not be empty.");
		if(false == regular.regular(spec.getName(), name)){
                    errors.rejectValue("name", "name.falsform", "specialization  must have only A-Z,a-z,А-Я,а-я.");
                }else if (null != specService.getByName(spec.getName())){
                    
                     errors.rejectValue("name", "name.falsform", "specialization alredy exsist");
                }
    }
       
}
