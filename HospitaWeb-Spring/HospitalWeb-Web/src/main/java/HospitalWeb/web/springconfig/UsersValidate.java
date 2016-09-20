/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;
import HospitalWeb.Validate.UsersValidateDate;
import HospitalWeb.Validate.UsersValidateDate;
import HospitalWeb.Validate.ValidatePattern;
import HospitalWeb.Validate.ValidateRegular;
import HospitalWeb.domain.Users;
import HospitalWeb.service.UserService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 *
 * @author Жека
 * Validate users with org.springframework.validation.Validator
 */
 @Component
public class UsersValidate implements Validator {
       @Autowired
         ValidateRegular regular;
        
        private final String name = ValidatePattern.name.pattern();
        private final String login_pass = ValidatePattern.login_pass.pattern();
        private final String telephone = ValidatePattern.telephone.pattern();

        @Autowired
        UserService userService;
            
        @Override
	public boolean supports(Class<?> clazz) {
		return UsersValidateDate.class.isAssignableFrom(clazz);
	}
        
        @Override
	public void validate(Object target, Errors errors) {
            
		UsersValidateDate users = (UsersValidateDate) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "login must not be empty.");
		String login = users.getLogin();
                try{
		if (16 < (login.length())) {
                    errors.rejectValue("login", "login.tooLong", "login must not more than 16 characters.");
		}else if(false == regular.regular(login, login_pass)){
                    errors.rejectValue("login", "login.falsform", "login must have only A-Z,a-z,0-9.");
                }else if(null != userService.getByLogin(login)){
                    errors.rejectValue("login", "login.falsform", "login alredy using");
                }
                }catch (Exception ex){
                    System.out.println("login not using");                   
                }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
		if (!(users.getPassword()).equals(users
				.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
		}else if(false == regular.regular(users.getPassword(), login_pass)){
                    errors.rejectValue("password", "password.falsform", "password must have only A-Z,a-z,0-9.");
                }
		
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "telephone.empty", "telephone must not be empty.");
		if(false == regular.regular(users.getTelephone(), telephone)){
                    errors.rejectValue("telephone", "telephone.falsform", "Telephone  address is not valid.");
		
                }
                
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Firstname must not be empty.");
		if(false == regular.regular(users.getName(), name)){
                    errors.rejectValue("name", "name.falsform", "Firstname  must have only A-Z,a-z,А-Я,а-я.");
                }
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "snme", "snme.empty", "Lastname must not be empty.");
		if(false == regular.regular(users.getSnme(), name)){
                    errors.rejectValue("snme", "snme.falsform", "Lastname  must have only A-Z,a-z,А-Я,а-я.");
                }
                
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exp", "exp.empty", "Lastname must not be empty.");
		if(0 >= users.getExp()){
                    errors.rejectValue("exp", "exp.falsform", "Experions  must have only number more 0.");
                }
                
                try{
		if( !EmailValidator.getInstance().isValid( users.getEmail() ) ){
			errors.rejectValue("email", "email.notValid", "Email address is not valid.");
		}else if(null != userService.getByEmail(users.getEmail())){
                    errors.rejectValue("email", "email.falsform", "email alredy using");
                }
                }catch (Exception ex){
                    System.out.println("email not using");                   
                }
	}
        
      
    
}

