/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.HelpClass;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Жека
 */
public class Creatnumbercard {
    private String number;
    private String dateregistr2;
    private SimpleDateFormat dateregistr;
    private SimpleDateFormat dateregistr1;
    private Date d;
    
    public String getNumbercard() {
            d = new Date();
            dateregistr1 = new SimpleDateFormat("ddMMyyyy-hh:mm");
            number = "K"+ dateregistr1.format(d);
            return number;
    }

  
    public String getDateregistr() {
        d = new Date();
        dateregistr = new SimpleDateFormat("dd-MM-yyyy");
        dateregistr2 = dateregistr.format(d);
        return dateregistr2;
    }

 

    
    
    
    
    
}
