/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Provisionaldiagnosis;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface ProvisionaldiagnosisDAO {
    public Provisionaldiagnosis getById(int id);
    public int save(Provisionaldiagnosis o);
    public void remove(Provisionaldiagnosis o);
    public List<Provisionaldiagnosis> getList();
}
