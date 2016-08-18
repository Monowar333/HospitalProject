/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;

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
      private Pattern patern;
        private Matcher matcher;
        private final String name = "^[А-ЯA-Z][а-яa-z]+$";
        private final String login_pass = "^[a-zA-Z0-9]{2,15}+$";
        private final String telephone = "^((0|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10,13}$";
        
           @Autowired
        UserService userService;
            
        @Override
	public boolean supports(Class<?> clazz) {
		return Users.class.isAssignableFrom(clazz);
	}
        
        @Override
	public void validate(Object target, Errors errors) {
            
		Users usersupdate = (Users) target;
		
	
		
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "telephone.empty", "telephone must not be empty.");
		if(regular(usersupdate.getTelephone(), telephone) == false){
                    errors.rejectValue("telephone", "telephone.falsform", "telephone address is not valid.");
                }
                
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Firstname must not be empty.");
		if(regular(usersupdate.getName(), name) == false){
                    errors.rejectValue("name", "name.falsform", "Firstname  must have only A-Z,a-z,А-Я,а-я.");
                }
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "snme", "snme.empty", "Lastname must not be empty.");
		if(regular(usersupdate.getSnme(), name) == false){
                    errors.rejectValue("snme", "snme.falsform", "Lastname  must have only A-Z,a-z,А-Я,а-я.");
                }
                
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exp", "exp.empty", "Lastname must not be empty.");
		if(usersupdate.getExp() <= 0){
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
        
        public  boolean regular(String s, String pattern){
        patern = Pattern.compile(pattern);//компилирование регулярного віражения
        matcher = patern.matcher(s);//анализирует строку и ищет соответсвие шалону
        return matcher.matches();//результат сравнение true/false
    }
}
