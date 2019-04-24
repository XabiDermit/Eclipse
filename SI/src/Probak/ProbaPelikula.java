package Probak;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Proiektua.Balorazioa;
import Proiektua.Pelikula;

public class ProbaPelikula {
	
	static Pelikula p1;
	static Pelikula p2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayList<String> generoak1 = new ArrayList<String>();
		generoak1.add("Romance");
		generoak1.add("Disaster");
		
		p1 = new Pelikula(1000,"Titanic",generoak1);
		p2 = null;
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
	public void testPelikula() {
		assertNotNull(p1);
		assertNull(p2);
	}

	@Test
	public void testBalorazioaGehitu() {
		p1.balorazioaGehitu(1, 3.0);
		
		assertTrue(p1.getBalorazioa(3.0).baloratuDu(1));
		assertFalse(p1.getBalorazioa(2.0).baloratuDu(1));
		assertFalse(p1.getBalorazioa(3.0).baloratuDu(2));
	}

	@Test
	public void testKomentarioaGehitu() {
		p1.komentarioaGehitu(1, "Aspergarria");
		p1.komentarioaGehitu(2, "Pelikula ona");
		
		assertTrue(p1.getKomentarioa("Aspergarria").komentatuDu(1));
		assertFalse(p1.getKomentarioa("Pelikula ona").komentatuDu(1));
		assertFalse(p1.getKomentarioa("Aspergarria").komentatuDu(2));
	}

	@Test
	public void testBaloratuDu() {
		p1.balorazioaGehitu(1, 2.5);
		
		assertTrue(p1.baloratuDu(1));
		assertFalse(p1.baloratuDu(2));
		
	}
	@Test
	public void testKomentatuDu() {
		p1.komentarioaGehitu(1, "Dibertigarria");
		
		assertTrue(p1.komentatuDu(1));
		assertFalse(p1.komentatuDu(2));
	}

}
