/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Medications;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Жека
 */
public class MedicationsDAOTest {
    static int idmed;
    static int idmed1;
   
    @BeforeClass
    public static void setUpClass() {
        Medications med = new Medications();
        med.setTradename("TestName");
        med.setManufacturer("TestName");
        med.setMnn("TestName");
        MedicationsDAO spDAO = new MedicationsDAOImpl();
        idmed = spDAO.save(med);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        Medications med = new MedicationsDAOImpl().getById(idmed);
        MedicationsDAO medDAO = new MedicationsDAOImpl();
        medDAO.remove(med);
        med = new MedicationsDAOImpl().getById(idmed1);
        medDAO.remove(med);
    }
    
   

    /**
     * Test of getById method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
         Medications med = new MedicationsDAOImpl().getById(idmed);
        Assert.assertNotNull("entity not found", med);
        Assert.assertEquals(idmed, (long)med.getId());
    }

    /**
     * Test of save method, of class SpecialalizationDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Medications med = new Medications();
        med.setTradename("TestName3");
        med.setMnn("TestName3");
        MedicationsDAO spDAO = new MedicationsDAOImpl();
        idmed1 = spDAO.save(med);
        med = new MedicationsDAOImpl().getById(idmed1);
        Assert.assertNotNull("entity not found", med);
        Assert.assertEquals(idmed1, (long)med.getId());
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
        List<Medications> med = new MedicationsDAOImpl().getList();
        Assert.assertNotNull("entity not found", med);
    }

}
