/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Жека
 */
public  class Regular {
    private Pattern patern;
    private Matcher matcher;
    private final String email = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]"
            + "+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private final String name = "^[А-Я][а-я]+$";
    private final String login_pass = "^[a-zA-Z0-9]{2,15}+$";
    private final String telephone = "^((0|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10,13}$";
    public  boolean regEmail(String s){
        patern = Pattern.compile(email);//компилирование регулярного віражения
        matcher = patern.matcher(s);//анализирует строку и ищет соответсвие шалону
        return matcher.matches();//результат сравнение true/false
    }
    
    public  boolean regName(String s){
        patern = Pattern.compile(name);//компилирование регулярного віражения
        matcher = patern.matcher(s);//анализирует строку и ищет соответсвие шалону
        return matcher.matches();//результат сравнение true/false
    }
    
     public  boolean regTelephone(String s){
        patern = Pattern.compile(telephone);//компилирование регулярного віражения
        matcher = patern.matcher(s);//анализирует строку и ищет соответсвие шалону
        return matcher.matches();//результат сравнение true/false
    }
     public  boolean regLogin_pass(String s){
        patern = Pattern.compile(login_pass);//компилирование регулярного віражения
        matcher = patern.matcher(s);//анализирует строку и ищет соответсвие шалону
        return matcher.matches();//результат сравнение true/false
    }
    
}
