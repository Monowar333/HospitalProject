/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.workwithxml;

import java.util.ResourceBundle;

/**
 *
 * @author Жека
 */
public class CredentialsBundle {
    static ResourceBundle rb;
    static{
        try{
            rb = ResourceBundle.getBundle("xml");
        }catch(Exception ex){
            
        }
    }
    static public String resolveCredentials(String label){
        return rb.getString(label);
    }
}