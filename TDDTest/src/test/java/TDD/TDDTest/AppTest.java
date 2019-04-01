package TDD.TDDTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testAdd() {
		int a = App.add("//,\n2,3");
		assertTrue(5 == a);
	}

	public void testAddZeroNumber() {
		int a = App.add("//,\n");
		assertTrue(0 == a);
	}

	public void testAddOneNumber() {
		int a = App.add("//,\n2");
		assertTrue(2 == a);
	}

	public void testIsNull() {
		try {
			App.add(null);
			fail();
		} catch (Exception e) {
			assertTrue(true);

		}
	}

	public void testAddMoreNumber() {
		int a = App.add("//,\n1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20");
		assertTrue(a == 210);
	}


	public void testDelimiter() {
		int a = App.add("//-\n1,3-6-2");
		assertTrue(a == 11);
	}

	public void testDelimiterFail() {
		try {
			App.add("//sa\n1,3sa6as2");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}

	}
	

	public void testAddNoNumber() {
		try {
			App.add("1,asasda");
			fail();

		} catch (Exception e) {
			assertTrue(true);
		}

	}

	public void testAddFormat() {
		try {
			App.add("1_2");
			fail();

		} catch (Exception e) {
			assertTrue(true);
		}

	}
}
