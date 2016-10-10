/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;
import HospitalWeb.domain.Prescription;
import HospitalWeb.domain.Reception;
import HospitalWeb.domain.Users;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Жека
 */
public class PrescriptionDAOTest {
    static int idprescription;
    static int idprescription1;
    static Reception reception;
    @BeforeClass
    public static void setUpClass() {
        reception = new ReceptionDAOImpl().getList().get(0);
        Prescription prescription = new Prescription();
        prescription.setIdreception(reception);
        prescription.setLinkprescription("TestName");
        PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl();
        idprescription = prescriptionDAO.save(prescription);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        Prescription prescription = 
                new PrescriptionDAOImpl().getById(idprescription);
        PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl();
        prescriptionDAO.remove(prescription);
        prescription = new PrescriptionDAOImpl().getById(idprescription1);
        prescriptionDAO.remove(prescription);
    }
    
   

    /**
     * Test of getById method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Prescription prescription = 
                new PrescriptionDAOImpl().getById(idprescription);
        Assert.assertNotNull("entity not found", prescription);
        Assert.assertEquals(idprescription, (long)prescription.getId());
    }

    /**
     * Test of save method, of class SpecialalizationDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Prescription prescription = new Prescription();
        prescription.setIdreception(reception);
        prescription.setLinkprescription("TestName");
        PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl();
        idprescription1 = prescriptionDAO.save(prescription);
        prescription = new PrescriptionDAOImpl().getById(idprescription1);
        Assert.assertNotNull("entity not found", prescription);
        Assert.assertEquals(idprescription1, (long)prescription.getId());
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
        List<Prescription> prescription = new PrescriptionDAOImpl().getList();
        Assert.assertNotNull("entity not found", prescription);
    }

}
