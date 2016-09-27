/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Medications;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface MedicationsDAO {
    public Medications getById(int id);
    public int save(Medications o);
    public void remove(Medications o);
    public List<Medications> getList();
}
