package co.edu.icesi.ci.junit.spring.unit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import co.edu.icesi.ci.junit.spring.main.AppConfig;
import co.edu.icesi.ci.junit.spring.model.Order;
import co.edu.icesi.ci.junit.spring.service.SampleService;
import co.edu.icesi.ci.junit.spring.service.SampleServiceImpl;

import org.slf4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class JUnitSpringExample {

	@Autowired
	private SampleService sampleService;
	private Order orden;

	private static final Logger log = LoggerFactory.getLogger(JUnitSpringExample.class);

	@BeforeClass
	public static void setUp() {
		log.info("-----> SETUP <-----");

	}

	public void context() {
		orden = new Order();
		orden.description = "Description";
		orden.orderDate = new Date();
		orden.orderId = 1;
		orden.orderStatus = SampleServiceImpl.ESTADOS[0];
		orden.securityCode = "AYSA";

	}

	@Test
	public void testSampleServiceGetAccountDescription() {
		// Check if the return description has a 'Description:' string.
		try {
			context();
			sampleService.createOrder(orden);
			assertTrue(sampleService.getOrderDescription(1).contains("Description"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSampleServiceGetAccountCode() {
		// Check if the return description has a 'Code:' string.
		try {
			context();
			sampleService.createOrder(orden);
			assertTrue(sampleService.getOrderStringCode(1).contains("AYSA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSampleServiceCreateNewOrder() {
		context();
		if (orden != null) {
			try {
				assertThat(sampleService.createOrder(orden), instanceOf(Order.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				fail();
			}
			assertNotNull("Security isn't null", orden.getSecurityCode());
			assertNotNull("Description isn't not null", orden.getDescription());
		}

		assertNotNull("New Order is not null", orden);

	}

	@Test
	public void testSampleServiceGetOrder() {
		context();
		Order existingOrder;
		try {
			sampleService.createOrder(orden);
			existingOrder = sampleService.getOrder(1);

			if (existingOrder != null) {
				assertThat(sampleService.getOrder(1), instanceOf(Order.class));
				assertNotNull("Security isn't null", existingOrder.getSecurityCode());
				assertNotNull("Description isn't null", existingOrder.getDescription());
			}

			assertNotNull("Object is not null", existingOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testDescription() throws Exception {
		context();

		sampleService.createOrder(orden);
		String or = sampleService.getOrderDescription(1);
		assertTrue(or.startsWith("Description"));
	}

	@Test
	public void testCode() throws Exception {
		context();
		sampleService.createOrder(orden);
		String code = sampleService.getOrderStringCode(1);
		assertTrue(code.contains("AYSA"));

	}

	@Test
	public void testOrdenes() throws Exception {
		context();
		Order orden = sampleService.createOrder(this.orden);
		assertNotNull(orden);
		assertNotNull(orden.description);
		assertNotNull(orden.securityCode);
		assertEquals(orden.description, "Description");
		assertEquals(orden.securityCode, "AYSA");
	}

	@Test
	public void testConsulta() throws Exception {
		context();
		sampleService.createOrder(this.orden);
		Order orden = sampleService.getOrder(1);
		assertNotNull(orden.description);
		assertNotNull(orden.securityCode);
	}

	@Test(expected = Exception.class)
	public void testCreateOrdenFailNull() throws Exception {
		context();

		orden.orderStatus = null;
		sampleService.createOrder(orden);

	}

	@Test(expected = Exception.class)
	public void testCreateOrdenFailFields() throws Exception {
		context();

		orden.orderStatus = "sal";
		sampleService.createOrder(orden);
	}

	@Test(expected = Exception.class)
	public void testCreateOrdenFailCode() throws Exception {
		context();

		orden.securityCode = "sakjksa";
		sampleService.createOrder(orden);

	}

	@AfterClass
	public static void afterTest() {
		log.info("-----> DESTROY <-----");
	}
}
