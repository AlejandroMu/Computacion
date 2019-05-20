package com.taller.tallerjpa.testsDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import com.taller.tallerjpa.dao.IInventoryDao;
import com.taller.tallerjpa.model.MedicineInventory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

/**
 * testInventory
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class testInventory {

    @Autowired
    private IInventoryDao inventoryDao;

    @Test
    @Transactional
    public void testSave(){
		MedicineInventory i4 = new MedicineInventory(21, "location", new Date(2019, 10, 1));
        inventoryDao.save(i4);
        assertTrue(i4.getId()!=0);
    }
    @Test
    @Transactional
    public void testUpdateAndFind(){
        MedicineInventory i4 = new MedicineInventory(21, "location", new Date(2019, 10, 1));
        inventoryDao.save(i4);
        MedicineInventory original=inventoryDao.findById(i4.getId());
        original.setLocation("ub");
        inventoryDao.update(original);
        MedicineInventory update=inventoryDao.findById(i4.getId());
        assertEquals(update.getLocation(), "ub");
    }
    @Test
    @Transactional
    public void testDelete(){
        MedicineInventory i4 = new MedicineInventory(21, "location", new Date(2019, 10, 1));
        inventoryDao.save(i4);
        MedicineInventory ori=inventoryDao.findById(i4.getId());
        assertNotNull(ori);
        inventoryDao.delete(ori);
        MedicineInventory delr=inventoryDao.findById(i4.getId());
        assertNull(delr);
    }
}