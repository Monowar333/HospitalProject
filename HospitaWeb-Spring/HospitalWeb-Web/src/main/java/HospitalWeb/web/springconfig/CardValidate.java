/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;

import HospitalWeb.Validate.ValidatePattern;
import HospitalWeb.Validate.ValidateRegular;
import HospitalWeb.domain.Card;
import HospitalWeb.service.CardService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 *
 * @author Жека
 */
public class CardValidate implements Validator{
     @Autowired
        CardService cardService;
    
    @Autowired
         ValidateRegular regular;
        
        private final String name = ValidatePattern.name.pattern();
        private final String login_pass = ValidatePattern.login_pass.pattern();
        private final String telephone = ValidatePattern.telephone.pattern();

    @Override
    public boolean supports(Class<?> clazz) {
        return Card.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       Card card = (Card) target;


                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "telephone.empty", "telephone must not be empty.");
		if(false == regular.regular(card.getTelephone(), telephone)){
                    errors.rejectValue("telephone", "telephone.falsform", "Telephone  address is not valid.");
                }
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.empty", "address must not be empty.");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Firstname must not be empty.");
		if(false == regular.regular(card.getName(), name)){
                    errors.rejectValue("name", "name.falsform", "Firstname  must have only A-Z,a-z,А-Я,а-я.");
                }
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sname", "sname.empty", "Lastname must not be empty.");
		if(false == regular.regular(card.getSname(), name)){
                    errors.rejectValue("sname", "sname.falsform", "Lastname  must have only A-Z,a-z,А-Я,а-я.");
                }
                                
                try{
		if( !EmailValidator.getInstance().isValid( card.getEmail() ) ){
			errors.rejectValue("email", "email.notValid", "Email address is not valid.");
		}else if(null != cardService.getByEmail(card.getEmail())){
                    errors.rejectValue("email", "email.falsform", "email alredy using");
                }
                }catch (Exception ex){
                    System.out.println("email not using");                   
                }
    }
    
}
