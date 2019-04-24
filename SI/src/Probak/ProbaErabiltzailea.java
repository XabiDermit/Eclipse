package Probak;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Proiektua.Erabiltzailea;
import Proiektua.GomendioSistema;
import Proiektua.Pelikula;
import Salbuespenak.PelikulaEzDaExistitzenException;

public class ProbaErabiltzailea {
	
	static Erabiltzailea e1;
	static Erabiltzailea e2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		e1 = new Erabiltzailea(1);
		e2 = null;
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
	public void testErabiltzailea() {
		assertNotNull(e1);
		assertNull(e2);
	}

	@Test
	public void testPelikulaGehitu() {
		ArrayList<String> generoak1 = new ArrayList<String>();
		ArrayList<String> generoak2 = new ArrayList<String>();
		generoak1.add("Romance");
		generoak1.add("Disaster");
		generoak2.add("Science fiction");
		
		Pelikula p1 = new Pelikula(1000,"Titanic",generoak1);
		Pelikula p2 = new Pelikula(2000,"Avatar",generoak2);
		
		e1.pelikulaGehitu(1000,p1);
		assertTrue(e1.ikusiDu(1000));
		assertFalse(e1.ikusiDu(2000));
	}
	
	@Test
	public void testIkusiDu() {
		ArrayList<String> generoak3 = new ArrayList<String>();
		ArrayList<String> generoak4 = new ArrayList<String>();
		generoak3.add("Romance");
		generoak3.add("Disaster");
		generoak4.add("Science fiction");
		
		Pelikula p3 = new Pelikula(3000,"Toy Story",generoak3);
		Pelikula p4 = new Pelikula(4000,"Star Wars",generoak4);
		
		e1.pelikulaGehitu(3000,p3);
		assertTrue(e1.ikusiDu(3000));
		assertFalse(e1.ikusiDu(4000));
	}

}
