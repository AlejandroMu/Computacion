package com.taller.tallerjpa.testsDao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.taller.tallerjpa.dao.ISupplyDao;
import com.taller.tallerjpa.model.Supply;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j2;

/**
 * testSupply
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
@Log4j2
public class testSupply {

    @Autowired
    private ISupplyDao supplyDao;

    @Before
    public void before() {
        Supply s = new Supply(3, new Date(2019, 04, 29), "S", "pathology");
        Supply s1 = new Supply(10, new Date(2019, 3, 2), "S1", "pathology");
        Supply s2 = new Supply(15, new Date(2019, 04, 29), "S2", "pathology");
        Supply s3 = new Supply(30, new Date(2019, 04, 29), "S3", "pathology");

        supplyDao.save(s1);
        supplyDao.save(s2);
        supplyDao.save(s3);
        supplyDao.save(s);
    }

    @Test
    @Transactional
    public void testSave() {
        Supply s = new Supply(3, new Date(2019, 04, 29), "observacion", "pathology");
        supplyDao.save(s);
        assertTrue("" + s.getId(), s.getId() != 0);

    }

    @Test
    @Transactional
    public void testUpdateAndFind() {
        Supply s = new Supply(3, new Date(2019, 04, 29), "observacion", "pathology");
        supplyDao.save(s);
        int id = s.getId();
        Supply gs = supplyDao.findById(id);
        assertNotNull(gs);
        gs.setObservation("update");
        supplyDao.update(gs);
        Supply up = supplyDao.findById(id);
        assertNotNull(up);
        assertTrue(up.getObservation().equals("update"));
    }

    @Test
    @Transactional
    public void delete() {
        Supply s = new Supply(3, new Date(2019, 04, 29), "observacion", "pathology");
        supplyDao.save(s);
        int id = s.getId();
        Supply n = supplyDao.findById(id);
        assertNotNull(n);
        supplyDao.delete(n);
        assertNull(supplyDao.findById(id));

    }

    @Test
    @Transactional
    public void testFindByAmount() {
        log.info("test para la consulta 1.c");
        int min = 1;
        int max = 10;
        List<Supply> supl = supplyDao.findByAmount(min, max);
        assertTrue("Cantidad", supl.size() == 2);
        for (Supply var : supl) {
            String o = var.getObservation();
            boolean exist = o.equals("S");
            exist |= o.equals("S1");
            assertTrue("Diferentes a s s1", exist);
        }

    }

}