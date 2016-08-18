/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;
import HospitalWeb.Validate.UsersValidateDate;
import HospitalWeb.Validate.UsersValidateDate;
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
    
        private Pattern patern;
        private Matcher matcher;
        private final String name = "^[А-ЯA-Z][а-яa-z]+$";
        private final String login_pass = "^[a-zA-Z0-9]{2,15}+$";
        private final String telephone = "^((0|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10,13}$";
        
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
		if ((login.length()) > 16) {
                    errors.rejectValue("login", "login.tooLong", "login must not more than 16 characters.");
		}else if(regular(login, login_pass) == false){
                    errors.rejectValue("login", "login.falsform", "login must have only A-Z,a-z,0-9.");
                }else if(userService.getByLogin(login) != null){
                    errors.rejectValue("login", "login.falsform", "login alredy using");
                }
                }catch (Exception ex){
                    System.out.println("login not using");                   
                }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
		if (!(users.getPassword()).equals(users
				.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
		}else if(regular(users.getPassword(), login_pass) == false){
                    errors.rejectValue("password", "password.falsform", "password must have only A-Z,a-z,0-9.");
                }
		
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "telephone.empty", "telephone must not be empty.");
		if(regular(users.getTelephone(), telephone) == false){
                    errors.rejectValue("telephone", "telephone.falsform", "telephone address is not valid.");
                }
                
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Firstname must not be empty.");
		if(regular(users.getName(), name) == false){
                    errors.rejectValue("name", "name.falsform", "Firstname  must have only A-Z,a-z,А-Я,а-я.");
                }
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "snme", "snme.empty", "Lastname must not be empty.");
		if(regular(users.getSnme(), name) == false){
                    errors.rejectValue("snme", "snme.falsform", "Lastname  must have only A-Z,a-z,А-Я,а-я.");
                }
                
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exp", "exp.empty", "Lastname must not be empty.");
		if(users.getExp() <= 0){
                    errors.rejectValue("exp", "exp.falsform", "Experions  must have only number more 0.");
                }
                
                try{
		if( !EmailValidator.getInstance().isValid( users.getEmail() ) ){
			errors.rejectValue("email", "email.notValid", "Email address is not valid.");
		}else if(userService.getByEmail(users.getEmail()) != null){
                    errors.rejectValue("email", "email.falsform", "email alredy using");
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

