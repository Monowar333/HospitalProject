/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;


import HospitalWeb.domain.Spcialialization;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Жека
 */
public class SpecialalizationDAOTest {
    static int iduser;
    static int iduser1;
    public SpecialalizationDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Spcialialization spec = new Spcialialization();
        spec.setName("TestName");
        SpecialalizationDAO spDAO = new SpecialalizationDAOImpl();
        iduser = spDAO.save(spec);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        Spcialialization spec = new SpecialalizationDAOImpl().getById(iduser);
        SpecialalizationDAO spDAO = new SpecialalizationDAOImpl();
        spDAO.remove(spec);
        spec = new SpecialalizationDAOImpl().getById(iduser1);
        spDAO.remove(spec);
    }
    
   

    /**
     * Test of getById method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
         Spcialialization user = new SpecialalizationDAOImpl().getById(iduser);
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals(iduser, (long)user.getId());
    }

    /**
     * Test of save method, of class SpecialalizationDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Spcialialization spec = new Spcialialization();
        spec.setName("TestName3");
        SpecialalizationDAO spDAO = new SpecialalizationDAOImpl();
        iduser1 = spDAO.save(spec);
        Spcialialization spec1 = new SpecialalizationDAOImpl().getById(iduser1);
        Assert.assertNotNull("entity not found", spec1);
        Assert.assertEquals(iduser1, (long)spec1.getId());
    }

    /**
     * Test of update method, of class SpecialalizationDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Spcialialization spec = new SpecialalizationDAOImpl().getById(iduser);
            spec.setName("TestNameUpdate");
            new SpecialalizationDAOImpl().update(spec);
            Spcialialization spec1 = new SpecialalizationDAOImpl().getById(iduser);
        Assert.assertNotNull("entity not found", spec1);
        Assert.assertEquals("TestNameUpdate", spec1.getName());
    }

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
        List<Spcialialization> user = new SpecialalizationDAOImpl().getList();
        Assert.assertNotNull("entity not found", user);
    }

  
    
}
