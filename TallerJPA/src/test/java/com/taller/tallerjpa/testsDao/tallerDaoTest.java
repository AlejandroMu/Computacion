package com.taller.tallerjpa.testsDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import com.taller.tallerjpa.dao.*;
import com.taller.tallerjpa.model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
@Log4j2
public class tallerDaoTest {

	@Autowired
	private IAtencionDao atencionDao;
	@Autowired
	private IPacientDao pacienteDao;
	@Autowired
	private MedicineDao medicineDao;
	@Autowired
	private IInventoryDao inventarioDao;
	@Autowired
	private ISupplyDao supplyDao;

	@Before
	@Transactional(readOnly = false, propagation =Propagation.REQUIRES_NEW)
	public void before() {

		assertNotNull("paciente", pacienteDao);
		assertNotNull("medicina", medicineDao);
		assertNotNull("inventario", inventarioDao);
		assertNotNull("supply", supplyDao);
		assertNotNull("atencion", atencionDao);

		Medicine m = new Medicine("Acetaminofen", "M", "Genfar", "Via oral", "indications", "Ninguna");
		Medicine m1 = new Medicine("Ibuprofeno", "M1", "Genfar", "Via oral", "indications", "Ninguna");
		Medicine m2 = new Medicine("Sevedol", "M2", "Genfar", "Via oral", "indications", "Ninguna");
		Medicine m3 = new Medicine("Acetaminofem", "M3", "Genfar", "Via oral", "indications", "Ninguna");

		MedicineInventory i = new MedicineInventory(9, "location", new Date(2019, 12, 1));
		MedicineInventory i1 = new MedicineInventory(11, "location", new Date(2019, 12, 1));
		MedicineInventory i2 = new MedicineInventory(2, "location", new Date(2020, 02, 1));
		MedicineInventory i3 = new MedicineInventory(21, "location", new Date(2020, 02, 1));
		MedicineInventory i4 = new MedicineInventory(1, "location", new Date(2019, 10, 1));

		Pacient p = new Pacient("1234", "jorge", "murcia", "Ing. sistema", true);
		Pacient p1 = new Pacient("1235", "Carlos", "Mosquera", "Ing. Industrial", true);
		Pacient p2 = new Pacient("1236", "Antonio", "murcia", "Ing. Quimica", true);
		Pacient p3 = new Pacient("1237", "jorge", "Mosquera", "Ing. sistema", true);

		Atencion a = new Atencion(new Date(2018, 12, 2), "A", "procedure", false, null, "observations");
		Atencion a1 = new Atencion(new Date(2019, 03, 2), "A1", "procedure", false, null, "observations");
		Atencion a2 = new Atencion(new Date(2019, 04, 29), "A2", "procedure", false, null, "observations");
		Atencion a3 = new Atencion(new Date(2019, 04, 20), "A3", "procedure", false, null, "observations");
		Atencion a4 = new Atencion(new Date(2019, 04, 2), "A4", "procedure", false, null, "observations");

		Supply s = new Supply(3, new Date(2019, 04, 29), "observacion", "pathology");
		Supply s1 = new Supply(10, new Date(2019, 3, 2), "observacion", "pathology");
		Supply s2 = new Supply(15, new Date(2019, 04, 29), "observacion", "pathology");
		Supply s3 = new Supply(15, new Date(2019, 04, 29), "observacion", "pathology");


		m.addMedicineInventory(i);// test
		m.addMedicineInventory(i1);
		m1.addMedicineInventory(i2);// test
		m2.addMedicineInventory(i3);
		m3.addMedicineInventory(i4);// test

		m.addSupply(s1);
		m1.addSupply(s2);
		m2.addSupply(s);
		m3.addSupply(s3);

		p.addAtention(a);
		p1.addAtention(a1);
		p3.addAtention(a2);
		p.addAtention(a3);
		p.addAtention(a4);

		a1.addSupply(s1);
		a2.addSupply(s2);
		a.addSupply(s);
		a3.addSupply(s3);
		
		addAMedicine(m, m1, m2, m3);
		addAPacient(p, p1, p2, p3);
		addAInventory(i, i1, i2, i3, i4);
		addAtencion(a, a1, a2, a3, a4);
		addASupply(s, s1, s2, s3);

	}

	public void addAtencion(Atencion... atenciones) {
		for (Atencion var : atenciones) {
			atencionDao.save(var);
			// atencionDao.flush();
		}
	}

	public void addAMedicine(Medicine... medicines) {
		for (Medicine var : medicines) {
			medicineDao.save(var);
			// medicineDao.flush();
		}
	}

	public void addAInventory(MedicineInventory... inventories) {
		for (MedicineInventory var : inventories) {
			inventarioDao.save(var);
			// inventarioDao.flush();
		}
	}

	public void addAPacient(Pacient... pacients) {
		for (Pacient var : pacients) {
			pacienteDao.save(var);
			// pacienteDao.flush();
		}
	}

	public void addASupply(Supply... supplies) {
		for (Supply var : supplies) {
			supplyDao.save(var);
			// supplyDao.flush();
		}
	}

	@After
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void after() {
		List<Medicine> m = medicineDao.findAll();
		List<MedicineInventory> i = inventarioDao.findAll();
		List<Supply> s = supplyDao.findAll();
		List<Atencion> a = atencionDao.findAll();
		List<Pacient> p = pacienteDao.findAll();
		for (Supply var : s) {
			supplyDao.delete(var);
		}
		for (Atencion var : a) {
			atencionDao.delete(var);
		}
		for (Pacient var : p) {
			pacienteDao.delete(var);
		}
		for (MedicineInventory var : i) {
			inventarioDao.delete(var);
		}
		for (Medicine var : m) {
			medicineDao.delete(var);
		}
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void testPacientWithAtencions() {
		log.info("test para la consulta 2.a");
		List<Pair<Pacient, Long>> pacients = pacienteDao.findAllWithAtentions();
		int c = pacients.size();
		assertTrue("Cantidad " + c, c == 4);
		long res[] = { 3, 1, 0, 1 };
		for (int i = 0; i < 4; i++) {
			Pair<Pacient, Long> tmp = pacients.get(i);
			assertTrue("Pacient " + (1234 + i), tmp.getFirst().getDocument().equals("" + (1234 + i)));
			assertTrue("Atenciones " + tmp.getSecond(), res[i] == tmp.getSecond());
		}
	}

	@Test
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public void testMedicinebyInventory() {
		log.info("test para la consulta 2.b por nombre");
		List<Medicine> medicines = medicineDao.findByInventory();
		int size = medicines.size();
		assertEquals(size, 3);
		for (Medicine m : medicines) {
			String gen = m.getGenericName();
			boolean exist = gen.equals("M");
			exist |= gen.equals("M1");
			exist |= gen.equals("M3");
			assertTrue("Diferente", exist);

		}

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void testPacient() {
		log.info("test para la consulta 2.c");
		List<Pacient> pacients = pacienteDao.findLastAtencion();
		assertEquals(1, pacients.size());
		for (Pacient p : pacients) {
			String doc = p.getDocument();
			boolean exist = doc.equals("1234");
			assertTrue("Diferentes", exist);
		}
	}

}
