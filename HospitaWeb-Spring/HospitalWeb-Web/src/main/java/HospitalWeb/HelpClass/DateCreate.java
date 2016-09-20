/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.HelpClass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Жека
 */
public class DateCreate {
    private List day;
    private List month;
    private List year;

    public DateCreate() {
      creatdate();
      creatmonth();
      creatyer();
      
    }
    
   private void creatdate(){
       this.day = new ArrayList<Integer>();
       for (int i = 1; i<=31;i++ ){
       this.day.add(i);
       }
    }
   private void creatmonth(){
       this.month = new ArrayList<Integer>();
        for (int i = 1; i<=12;i++ ){
       this.month.add(i);
       }
   }
   private void creatyer(){
       Calendar c = new GregorianCalendar();
       int y = c.get(Calendar.YEAR);
       this.year = new ArrayList<Integer>();
        for (int i = 1910; i <= y;i++ ){
       this.year.add(i);
       }
   }
    
    
    public List getDay() {
        return day;
    }

    public List getMonth() {
        return month;
    }

    public List getYear() {
        return year;
    }
    
    
}
