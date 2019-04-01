package co.edu.icesi.ci.junit.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import co.edu.icesi.ci.junit.spring.main.AppConfig;
import co.edu.icesi.ci.junit.spring.service.*;
import co.edu.icesi.ci.unit.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
//@Log4j2
public class JUnitSpringExample {

	private SampleService sampleService;
	private Order orden;

	@Before
	public void start() {
		System.out.println("Start test");
		sampleService = new SampleServiceImpl();
		orden=new Order();
		orden.description="Description";
		orden.orderDate=new Date();
		orden.orderId=1;
		orden.orderStatus=SampleServiceImpl.ESTADOS[0];
		orden.securityCode="AYSA";

	}

	@After
	public void end() {
		 System.out.println("End test");
		sampleService.delete();
	}

	public void context() {

	}

	@Test
	public void testDescription() {
		sampleService.createOrder(orden);
		String or = sampleService.getOrderDescription(1);
		assertTrue(or.startsWith("Description"));
	}

	@Test
	public void testCode() {
		sampleService.createOrder(orden);
		String code = sampleService.getOrderStringCode(1);
		assertTrue(code.contains("AYSA"));

	}

	@Test
	public void testOrdenes() {
		Order orden =sampleService.createOrder(this.orden);
		assertNotNull(orden);
		assertNotNull(orden.description);
		assertNotNull(orden.securityCode);
		assertEquals(orden.description,"Description");
		assertEquals(orden.securityCode,"AYSA");
	}
	@Test
	public void testConsulta() {
		sampleService.createOrder(this.orden);
		Order orden=sampleService.getOrder(1);
		assertNotNull(orden.description);
		assertNotNull(orden.securityCode);
	}
	@Test
	public void testCreateOrdenFailNull() {
		orden.orderStatus=null;
		Order tmp=sampleService.createOrder(orden);
		assertNull(tmp);
		assertNull(sampleService.getOrder(1));
	}
	@Test
	public void testCreateOrdenFailFields() {
		orden.orderStatus="sal";
		Order tmp=sampleService.createOrder(orden);
		assertNull(tmp);
		assertNull(sampleService.getOrder(1));
	}
	@Test
	public void testCreateOrdenFailCode() {
		orden.securityCode="sakjksa";
		Order tmp=sampleService.createOrder(orden);
		assertNull(tmp);
		assertNull(sampleService.getOrder(1));
	}
	
}
