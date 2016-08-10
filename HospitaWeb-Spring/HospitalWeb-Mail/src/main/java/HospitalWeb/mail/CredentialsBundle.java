/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.mail;

import java.util.ResourceBundle;

/**
 *файл подклчечения настроек почтовіх настроек
 * 
 */
public class CredentialsBundle {
    static ResourceBundle rb;
    static{
        try{
            rb = ResourceBundle.getBundle("mail");
        }catch(Exception ex){
            
        }
    }
    static String resolveCredentials(String label){
        return rb.getString(label);
    }
}
