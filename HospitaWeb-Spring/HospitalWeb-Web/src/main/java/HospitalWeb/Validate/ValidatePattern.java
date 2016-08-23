/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.Validate;

/**
 *
 * @author Жека
 */
public enum ValidatePattern {
    name(){
    @Override
    public String pattern(){
        return "^[А-ЯA-Z][а-яa-z]+$";
     }
    },login_pass(){
      @Override
    public String pattern(){
        return "^[a-zA-Z0-9]{2,15}+$";
     }  
    },telephone(){
      @Override
    public String pattern(){
        return "^((0|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10,13}$";
     }    
    };
            
    public abstract String pattern();
    

}
