/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;

import HospitalWeb.domain.Prescription;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface PrescriptionService {
     public Prescription getById(int id);
    public int save(Prescription o);
    public void remove(Prescription o);
    public List<Prescription> getList();
}
