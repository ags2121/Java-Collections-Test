package homework_4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollectionsTestTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		CollectionsTest tester = new CollectionsTest();
		tester.add(555555);
		assertTrue(tester.getnArrTot() < tester.getnHashTot() && tester.getnArrTot() < tester.getnListTot());
	}
	
	@Test
	public void testRetrieve() {
		CollectionsTest tester2 = new CollectionsTest();
		tester2.retrieve(111111);
		assertTrue(tester2.getnArrTot() < tester2.getnListTot());
	}

}
