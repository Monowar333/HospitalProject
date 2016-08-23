/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;

import HospitalWeb.Validate.ValidatePattern;
import HospitalWeb.Validate.ValidateRegular;
import HospitalWeb.domain.Users;
import HospitalWeb.service.UserService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Жека
 */
public class UserVAlidateUpdate implements Validator{
         @Autowired
        UserService userService;
         
         @Autowired
         ValidateRegular regular;
         
         
         
         
         private final String name = ValidatePattern.name.pattern();
        private final String login_pass = ValidatePattern.login_pass.pattern();
        private final String telephone = ValidatePattern.telephone.pattern();

        
          
            
        @Override
	public boolean supports(Class<?> clazz) {
		return Users.class.isAssignableFrom(clazz);
	}
        
        @Override
	public void validate(Object target, Errors errors) {
            
		Users usersupdate = (Users) target;
		
	
		System.out.println("telephone " + telephone);
                System.out.println("telephone " + usersupdate.getTelephone());
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "telephone.empty", "telephone must not be empty.");
		if(false == regular.regular(usersupdate.getTelephone(), telephone)){
                    errors.rejectValue("telephone", "telephone.falsform", "telephone address is not valid.");
                }
                
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Firstname must not be empty.");
		if(false == regular.regular(usersupdate.getName(), name)){
                    errors.rejectValue("name", "name.falsform", "Firstname  must have only A-Z,a-z,А-Я,а-я.");
                }
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "snme", "snme.empty", "Lastname must not be empty.");
		if(false == regular.regular(usersupdate.getSnme(), name)){
                    errors.rejectValue("snme", "snme.falsform", "Lastname  must have only A-Z,a-z,А-Я,а-я.");
                }
                
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exp", "exp.empty", "Lastname must not be empty.");
		if(0 >= usersupdate.getExp()){
                    errors.rejectValue("exp", "exp.falsform", "Experions  must have only number more 0.");
                }
                
                try{
		if( !EmailValidator.getInstance().isValid( usersupdate.getEmail() ) ){
			errors.rejectValue("email", "email.notValid", "Email address is not valid.");
		
                }
                }catch (Exception ex){
                    System.out.println("email not using");                   
                }
	}
        
     
}
