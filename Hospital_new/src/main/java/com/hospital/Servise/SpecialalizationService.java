/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servise;


import DB.entity.Spcialialization;
import java.util.List;


/**
 *
 * @author Жека
 */
public interface SpecialalizationService {

    public Spcialialization getById(int id);
    public int save(Spcialialization o);
    public void update(Spcialialization o);       
    public void remove(Spcialialization o);       
    public List<Spcialialization> getList();        
    public void changeStatus(int id);
}
