package com.taller.tallerjpa.testsDao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import com.taller.tallerjpa.dao.IAtencionDao;
import com.taller.tallerjpa.model.Atencion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

/**
 * testAtenciones
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
@Log4j2
public class testAtenciones {

    @Autowired
    private IAtencionDao atencionDao;

    private int idTest;

    @Before
    // @Transactional
    public void before() {

        Atencion a = new Atencion(new Date(2018, 12, 2), "A", "procedure", false, null, "observations");
        Atencion a1 = new Atencion(new Date(2019, 03, 2), "A1", "procedure", false, null, "observations");
        Atencion a2 = new Atencion(new Date(2019, 04, 29), "A2", "procedure", false, null, "observations");
        Atencion a3 = new Atencion(new Date(2019, 04, 29), "A3", "procedure", false, null, "observations");
        Atencion a4 = new Atencion(new Date(2019, 06, 2), "A4", "procedure", false, null, "observations");

        atencionDao.save(a);
        idTest=a.getId();
        atencionDao.save(a1);
        atencionDao.save(a3);
        atencionDao.save(a2);
        atencionDao.save(a4);
    }
    @After
    // @Transactional
    public void after(){
        //test delete
        List<Atencion> a = atencionDao.findAll();
        for (Atencion var : a) {
			atencionDao.delete(var);
		}
    }

    @Test
    @Transactional
    public void testAddAtencion() {
        List<Atencion> atencions = atencionDao.findAll();
        int c = atencions.size();
        assertTrue("Cantidad " + c, c == 5);
    }
    @Test
    @Transactional
    public void updateAndFind(){
        Atencion at=atencionDao.findById(idTest);
        assertNotNull("At null",at);
        at.setProcedureDone("procedureDone");
        atencionDao.update(at);
        Atencion atU=atencionDao.findById(idTest);
        assertNotNull("AtU null",atU);
        assertTrue(atU.getProcedureDone().equals("procedureDone"));

    }

    @Test
    @Transactional
	public void testFindAtencionByRange() {
		log.info("Prueba de la consulta del punto 1.b");
		Date d = new Date(2019, 01, 2);
		Date d1 = new Date(2019, 05, 2);
		List<Atencion> atenciones = atencionDao.findByDates(d, d1);
		int c = atenciones.size();
		assertTrue("Cantidad " + c, c == 3);
		for (Atencion var : atenciones) {
			String des = var.getGeneralDescription();
			boolean exist = des.equals("A1");
			exist |= des.equals("A2");
			exist |= des.equals("A3");
			assertTrue("Atencion "+des, exist);
		}
	}


}