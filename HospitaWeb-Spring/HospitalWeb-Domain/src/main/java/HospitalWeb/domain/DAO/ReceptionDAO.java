/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Reception;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface ReceptionDAO {
    public Reception getById(int id);
    public int save(Reception o);
    public void remove(Reception o);
    public List<Reception> getList();
    public void changeStatus(int id);
}
