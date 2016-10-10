/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Card;
import HospitalWeb.domain.Medications;
import HospitalWeb.domain.Prescription;
import HospitalWeb.domain.Prescriptiondeteil;
import HospitalWeb.domain.Provisionaldiagnosis;
import HospitalWeb.domain.Reception;
import HospitalWeb.domain.Users;
import java.sql.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Жека
 */
public class ReceptionDAOTest {
      static int idreception;
    static int idreception1;
    static Users user;
    static Card card;
    static Provisionaldiagnosis provisionaldiagnosis;
    
    @BeforeClass
    public static void setUpClass() {
        user = new UsersDAOImpl().getList().get(0);
        card = new CardsDAOImpl().getList().get(0);
        provisionaldiagnosis = new ProvisionaldiagnosisDAOImpl().getList().get(0);
        Reception reception = new Reception();
        reception.setIdCard(card);
        reception.setIdUsers(user);
        reception.setIdprovisionaldiagnosis(provisionaldiagnosis);
        reception.setStatus("new");
        reception.setTime(new Date(2016, 12, 9));
        reception.setComplaints("Test");
        ReceptionDAO receptionDAO = new ReceptionDAOImpl();
        idreception = receptionDAO.save(reception);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        ReceptionDAO receptionDAO = new ReceptionDAOImpl();
        Reception reception = 
               receptionDAO.getById(idreception);
        receptionDAO.remove(reception);
        reception = receptionDAO.getById(idreception);
        receptionDAO.remove(reception);
    }
    
   

    /**
     * Test of getById method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Reception reception = 
                new ReceptionDAOImpl().getById(idreception);
        Assert.assertNotNull("entity not found", reception);
        Assert.assertEquals(idreception, (long)reception.getId());
    }

    /**
     * Test of save method, of class SpecialalizationDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        user = new UsersDAOImpl().getList().get(0);
        card = new CardsDAOImpl().getList().get(0);
        provisionaldiagnosis = new ProvisionaldiagnosisDAOImpl().getList().get(0);
        Reception reception = new Reception();
        reception.setIdCard(card);
        reception.setIdUsers(user);
        reception.setIdprovisionaldiagnosis(provisionaldiagnosis);
        reception.setStatus("new");
        reception.setTime(new Date(2016, 12, 9));
        reception.setComplaints("Test");
        ReceptionDAO receptionDAO = new ReceptionDAOImpl();
        idreception1 = receptionDAO.save(reception);
        reception = new ReceptionDAOImpl().getById(idreception1);
        Assert.assertNotNull("entity not found", reception);
        Assert.assertEquals(idreception1, (long)reception.getId());
    }

    /**
     * Test of update method, of class SpecialalizationDAO.
     */
   

    /**
     * Test of remove method, of class SpecialalizationDAO.
     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        Spcialialization o = null;
//        SpecialalizationDAO instance = new SpecialalizationDAO();
//        instance.remove(o);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getList method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        List<Reception> reception = new ReceptionDAOImpl().getList();
        Assert.assertNotNull("entity not found", reception);
    }
}
