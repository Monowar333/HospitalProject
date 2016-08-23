/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Жека
 */
public class ValidateRegular {
    private Pattern patern;
        private Matcher matcher;

      public  boolean regular(String s, String pattern){
        patern = Pattern.compile(pattern);//компилирование регулярного віражения
        matcher = patern.matcher(s);//анализирует строку и ищет соответсвие шалону
        return matcher.matches();//результат сравнение true/false

      }
}
