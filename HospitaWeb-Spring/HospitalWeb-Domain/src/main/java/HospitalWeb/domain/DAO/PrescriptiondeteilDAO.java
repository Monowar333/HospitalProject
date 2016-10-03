/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Prescriptiondeteil;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface PrescriptiondeteilDAO {
     public Prescriptiondeteil getById(int id);
    public int save(Prescriptiondeteil o);
    public void remove(Prescriptiondeteil o);
    public List<Prescriptiondeteil> getList();
}
