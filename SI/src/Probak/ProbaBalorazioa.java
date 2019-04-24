package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Proiektua.Balorazioa;
import Proiektua.Erabiltzailea;

public class ProbaBalorazioa {
	
	static Balorazioa b1;
	static Balorazioa b2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		b1 = new Balorazioa(2, 2.5);
		b2 = null;
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
	public void testBalorazioa() {
		assertNotNull(b1);
		assertNull(b2);
	}

	@Test
	public void testGehituErabiltzailea() {
		Erabiltzailea e1 = new Erabiltzailea(1);
		Erabiltzailea e2 = new Erabiltzailea(2);
		
		b1.gehituErabiltzailea(1);
		assertTrue(b1.baloratuDu(1));
		assertFalse(b1.baloratuDu(2));
	}
	
	@Test
	public void testBaloratuDu() {
		Erabiltzailea e3 = new Erabiltzailea(3);
		Erabiltzailea e4 = new Erabiltzailea(4);
		
		b1.gehituErabiltzailea(3);
		assertTrue(b1.baloratuDu(3));
		assertFalse(b1.baloratuDu(4));
	}

}
