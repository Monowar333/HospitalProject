/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Medications;
import HospitalWeb.domain.Prescription;
import HospitalWeb.domain.Prescriptiondeteil;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Жека
 */
public class PrescriptiondeteilDAOTest {
    static int idprescriptiondeteil;
    static int idprescriptiondeteil1;
    static Prescription prescription;
    static Medications medications;
    
    @BeforeClass
    public static void setUpClass() {
        prescription = new PrescriptionDAOImpl().getList().get(0);
        medications = new MedicationsDAOImpl().getList().get(0);
        Prescriptiondeteil prescriptiondeteil = new Prescriptiondeteil();
        prescriptiondeteil.setIdmedication(medications);
        prescriptiondeteil.setIdprescription(prescription);
        prescriptiondeteil.setIndicationsforuse("TestName");
        PrescriptiondeteilDAO prescriptiondeteilDAO = new PrescriptiondeteilDAOImpl();
        idprescriptiondeteil = prescriptiondeteilDAO.save(prescriptiondeteil);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        PrescriptiondeteilDAO prescriptiondeteilDAO = new PrescriptiondeteilDAOImpl();
        Prescriptiondeteil prescriptiondeteil = 
               prescriptiondeteilDAO.getById(idprescriptiondeteil);
        prescriptiondeteilDAO.remove(prescriptiondeteil);
        prescriptiondeteil = prescriptiondeteilDAO.getById(idprescriptiondeteil1);
        prescriptiondeteilDAO.remove(prescriptiondeteil);
    }
    
   

    /**
     * Test of getById method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Prescriptiondeteil prescriptiondeteil = 
                new PrescriptiondeteilDAOImpl().getById(idprescriptiondeteil);
        Assert.assertNotNull("entity not found", prescriptiondeteil);
        Assert.assertEquals(idprescriptiondeteil, (long)prescriptiondeteil.getId());
    }

    /**
     * Test of save method, of class SpecialalizationDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Prescriptiondeteil prescriptiondeteil = new Prescriptiondeteil();
        prescriptiondeteil.setIdmedication(medications);
        prescriptiondeteil.setIdprescription(prescription);
        prescriptiondeteil.setIndicationsforuse("TestName");
        PrescriptiondeteilDAO prescriptiondeteilDAO = new PrescriptiondeteilDAOImpl();
        idprescriptiondeteil1 = prescriptiondeteilDAO.save(prescriptiondeteil);
        prescriptiondeteil = new PrescriptiondeteilDAOImpl().getById(idprescriptiondeteil1);
        Assert.assertNotNull("entity not found", prescriptiondeteil);
        Assert.assertEquals(idprescriptiondeteil1, (long)prescriptiondeteil.getId());
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
        List<Prescriptiondeteil> prescriptiondeteil = new PrescriptiondeteilDAOImpl().getList();
        Assert.assertNotNull("entity not found", prescriptiondeteil);
    }

}
