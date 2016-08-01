/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpClass;

/**
 *
 * @author Жека
 */
public class WorkWithTransformation {
    public static Integer StringToInt(String s){
        Integer i;
        try {
           i = Integer.valueOf(s); 
           return i;
        }catch (NumberFormatException e) {  
           System.err.println("Неверный формат строки!");
           return i = null;
        }  
    }
}
