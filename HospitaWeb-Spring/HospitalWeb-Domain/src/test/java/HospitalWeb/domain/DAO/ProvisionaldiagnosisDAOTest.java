/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;


import HospitalWeb.domain.Provisionaldiagnosis;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Жека
 */
public class ProvisionaldiagnosisDAOTest {
    static int idprovisionaldiagnosis;
    static int idprovisionaldiagnosis1;

    @BeforeClass
    public static void setUpClass() {
        Provisionaldiagnosis provisionaldiagnosis = new Provisionaldiagnosis();
        provisionaldiagnosis.setGroupdiagnos("Test");
        provisionaldiagnosis.setName("Test");
        provisionaldiagnosis.setGroupid("Test");
        ProvisionaldiagnosisDAO provisionaldiagnosisDAO =
                                    new ProvisionaldiagnosisDAOImpl();
        idprovisionaldiagnosis = provisionaldiagnosisDAO.save(provisionaldiagnosis);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        Provisionaldiagnosis provisionaldiagnosis = 
                new ProvisionaldiagnosisDAOImpl().getById(idprovisionaldiagnosis);
        ProvisionaldiagnosisDAO provisionaldiagnosisDAO = 
                            new ProvisionaldiagnosisDAOImpl();
        provisionaldiagnosisDAO.remove(provisionaldiagnosis);
        provisionaldiagnosis = 
                new ProvisionaldiagnosisDAOImpl().getById(idprovisionaldiagnosis1);
        provisionaldiagnosisDAO.remove(provisionaldiagnosis);
    }
    
   

    /**
     * Test of getById method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Provisionaldiagnosis provisionaldiagnosis = 
                new ProvisionaldiagnosisDAOImpl().getById(idprovisionaldiagnosis);
        Assert.assertNotNull("entity not found", provisionaldiagnosis);
        Assert.assertEquals(idprovisionaldiagnosis, (long)provisionaldiagnosis.getId());
    }

    /**
     * Test of save method, of class SpecialalizationDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
         Provisionaldiagnosis provisionaldiagnosis = new Provisionaldiagnosis();
        provisionaldiagnosis.setGroupdiagnos("Test");
        provisionaldiagnosis.setName("Test");
        provisionaldiagnosis.setGroupid("Test");
        ProvisionaldiagnosisDAO provisionaldiagnosisDAO =
                                    new ProvisionaldiagnosisDAOImpl();
        idprovisionaldiagnosis1 = provisionaldiagnosisDAO.save(provisionaldiagnosis);
        provisionaldiagnosis = new ProvisionaldiagnosisDAOImpl().getById(idprovisionaldiagnosis1);
        Assert.assertNotNull("entity not found", provisionaldiagnosis);
        Assert.assertEquals(idprovisionaldiagnosis1, (long)provisionaldiagnosis.getId());
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
        List<Provisionaldiagnosis> provisionaldiagnosis = 
                                new ProvisionaldiagnosisDAOImpl().getList();
        Assert.assertNotNull("entity not found", provisionaldiagnosis);
    }
}
