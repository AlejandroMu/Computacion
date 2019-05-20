package com.taller.tallerjpa.testsDao;


import static org.junit.Assert.*;

import javax.transaction.Transactional;

import com.taller.tallerjpa.dao.IMedicineDao;
import com.taller.tallerjpa.model.Medicine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * testMedicine
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class testMedicine {

    @Autowired
    private IMedicineDao medicineDao;

    @Test
    @Transactional
    public void testSave(){
        Medicine m = new Medicine("Acetaminofen", "Ac", "Genfar", "Via oral", "indications", "Ninguna");
        medicineDao.save(m);
        assertTrue(m.getId()!=0);
    }
    @Test
    @Transactional
    public void testUpdateAndFind(){
        Medicine m = new Medicine("Acetaminofen", "Ac", "Genfar", "Via oral", "indications", "Ninguna");
        medicineDao.save(m);
        Medicine original=medicineDao.findById(m.getId());
        original.setGenericName("genericName");
        medicineDao.update(original);
        Medicine update=medicineDao.findById(m.getId());
        assertEquals(update.getGenericName(), "genericName");
    }
    @Test
    @Transactional
    public void testDelete(){
        Medicine m = new Medicine("Acetaminofen", "Ac", "Genfar", "Via oral", "indications", "Ninguna");
        medicineDao.save(m);
        Medicine ori=medicineDao.findById(m.getId());
        assertNotNull(ori);
        medicineDao.delete(ori);
        Medicine delr=medicineDao.findById(m.getId());
        assertNull(delr);
    }
}