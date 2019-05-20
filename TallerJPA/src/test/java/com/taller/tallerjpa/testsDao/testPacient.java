package com.taller.tallerjpa.testsDao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.taller.tallerjpa.dao.IPacientDao;
import com.taller.tallerjpa.model.Pacient;

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
 * testPacient
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
@Log4j2
public class testPacient {

    @Autowired
    private IPacientDao pacienteDao;

    @Before    
    public void before(){
        Pacient p = new Pacient("1234", "jorge", "murcia", "Ing. sistemas", true);
		Pacient p1 = new Pacient("1235", "Carlos", "Mosquera", "Ing. Industrial", true);
		Pacient p2 = new Pacient("1236", "Antonio", "murcia", "Ing. Quimica", true);
		Pacient p3 = new Pacient("1237", "jorge", "Mosquera", "Ing. sistemas", true);

        pacienteDao.save(p1);
		pacienteDao.save(p2);
		pacienteDao.save(p);
		pacienteDao.save(p3);
    }

    @Test
    @Transactional
	public void testAdd() {
		List<Pacient> pacients = pacienteDao.findAll();
		int c = pacients.size();
		assertTrue("Cantidad " + c, c == 4);
    }

    @Test
    @Transactional
    public void testUpdate(){
        log.info("test para la consulta 1.a por documento");
        Pacient paciente=pacienteDao.findByDocument("1234");
        assertNotNull(paciente);
        paciente.setAcademicProgram("Ing. Industrial");
        pacienteDao.update(paciente);
        Pacient pacienteMerge=pacienteDao.findByDocument("1234");
        assertNotNull(pacienteMerge);
        assertTrue("No actualizo", pacienteMerge.getAcademicProgram().equals("Ing. Industrial"));
    }
    @Test
    @Transactional
    public void findByName(){
        log.info("test para la consulta 1.a por nombre");
        List<Pacient> pacients=pacienteDao.findByName("jorge");
        int c=pacients.size();
        assertTrue("Cantidad Erronea", c==2);
        for (Pacient var : pacients) {
            String doc=var.getDocument();
            boolean exist=doc.equals("1237");
             exist|=doc.equals("1234");
             assertTrue("Diferentes",exist);
        }

    }
    @Test
    @Transactional
    public void findByLastName(){
        log.info("test para la consulta 1.a por apellidos");
        List<Pacient> pacients=pacienteDao.findByLastName("Mosquera");
        int c=pacients.size();
        assertTrue("Cantidad Erronea", c==2);
        for (Pacient var : pacients) {
            String doc=var.getDocument();
            boolean exist=doc.equals("1237");
             exist|=doc.equals("1235");
             assertTrue("Diferentes",exist);
        }

    }
    @After
    public void testDelete(){
        List<Pacient> p = pacienteDao.findAll();
        for (Pacient var : p) {
			pacienteDao.delete(var);
		}
    }
}