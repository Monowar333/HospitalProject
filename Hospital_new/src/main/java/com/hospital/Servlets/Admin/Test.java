/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.Admin;

import DB.entity.Spcialialization;
import com.hospital.DAO.SpecialalizationDAO;

/**
 *
 * @author Жека
 */
public class Test {

    public Test() {
    Spcialialization spe3 = new Spcialialization();
         spe3.setName("аівавіаіваів");
         SpecialalizationDAO spe1 = new SpecialalizationDAO();
         spe1.save(spe3);
    }
    
}
