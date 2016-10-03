/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.workwithexel;

import HospitalWeb.domain.Medications;
import HospitalWeb.domain.Provisionaldiagnosis;
import HospitalWeb.service.MedicationsService;
import HospitalWeb.service.ProvisionaldiagnosisService;
import HospitalWeb.workwithxml.CredentialsBundle;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Жека
 */
public class FromExelToDBImpl implements FromExelToDB{
    @Autowired
    MedicationsService medicationsService;
    
     @Autowired
    ProvisionaldiagnosisService provisionaldiagnosisService;
    
    @Override
    public void FromExelToDBmedications() throws IOException {
         //инициализируем потоки
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        String filen = CredentialsBundle.resolveCredentials("fileexel"); 
        try {
            inputStream = new FileInputStream(filen);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
     //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
     //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
             Medications med = new Medications();
             med.setTradename(row.getCell(0).getStringCellValue());
             med.setMnn(row.getCell(1).getStringCellValue());
             med.setConditionsofsupply(row.getCell(2).getStringCellValue());
             med.setCompositionofactivesubstances(row.getCell(3).getStringCellValue());
             med.setClinicalpharmgroup(row.getCell(4).getStringCellValue());
             med.setCountry(row.getCell(5).getStringCellValue());
             med.setManufacturer(row.getCell(6).getStringCellValue());
             med.setManufactureren(row.getCell(7).getStringCellValue());
             med.setProduct(row.getCell(8).getStringCellValue());
             medicationsService.save(med);  
        }
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FromExelToDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public  String parse() {
    //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        String filen = CredentialsBundle.resolveCredentials("fileexel"); 
        try {
            inputStream = new FileInputStream(filen);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
     //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
     //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
             Medications med = new Medications();
            
             med.setTradename(row.getCell(0).getStringCellValue());
             med.setMnn(row.getCell(1).getStringCellValue());
             med.setConditionsofsupply(row.getCell(2).getStringCellValue());
             med.setCompositionofactivesubstances(row.getCell(3).getStringCellValue());
             med.setClinicalpharmgroup(row.getCell(4).getStringCellValue());
             med.setCountry(row.getCell(5).getStringCellValue());
             med.setManufacturer(row.getCell(6).getStringCellValue());
             med.setManufactureren(row.getCell(7).getStringCellValue());
             med.setProduct(row.getCell(8).getStringCellValue());
//            med.setTradename("1111111111111");
//             med.setMnn("1111111111111");
//             med.setConditionsofsupply("1111111111111");
//             med.setCompositionofactivesubstances("1111111111111");
//             med.setClinicalpharmgroup("1111111111111");
//             med.setCountry("1111111111111");
//             med.setManufacturer("1111111111111");
//             med.setManufactureren("1111111111111");
//             med.setProduct("1111111111111");
             medicationsService.save(med);  
            result += "\n";
        }
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FromExelToDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void FromExelToDBprovisionaldiagnosis() throws IOException {
         //инициализируем потоки
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        String filen = CredentialsBundle.resolveCredentials("fileexel1"); 
        try {
            inputStream = new FileInputStream(filen);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
     //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
     //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
             Provisionaldiagnosis provis = new Provisionaldiagnosis();
             provis.setGroupdiagnos(row.getCell(0).getStringCellValue());
             provis.setName(row.getCell(1).getStringCellValue());
             provis.setGroupid(row.getCell(2).getStringCellValue());
//             provis.setGroupdiagnos("111");
//             provis.setName("111");
//             provis.setGroupid("111");
//             System.out.println(provis.getGroup());
//             System.out.println(provis.getName());
//             System.out.println(provis.getGroupid());
//             System.out.println(provis.getGroupdiagnos().length());
//             System.out.println(provis.getName().length());
//             System.out.println(provis.getGroupid().length());
             provisionaldiagnosisService.save(provis);  
        }
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FromExelToDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
