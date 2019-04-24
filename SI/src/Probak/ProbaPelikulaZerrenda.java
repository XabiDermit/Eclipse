package Probak;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Proiektua.Pelikula;
import Proiektua.PelikulaZerrenda;

public class ProbaPelikulaZerrenda {
	
	static PelikulaZerrenda z1;
	static PelikulaZerrenda z2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		z1 = new PelikulaZerrenda();
		z2 = null;
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
	public void testPelikulaZerrenda() {
		assertNotNull(z1);
		assertNull(z2);
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
		
		z1.pelikulaGehitu(1000, p1);
		
		assertTrue(z1.badago(1000));
		assertFalse(z1.badago(2000));
	}

	@Test
	public void testPelikulakEskuratu() {
		ArrayList<String> generoak1 = new ArrayList<String>();
		ArrayList<String> generoak2 = new ArrayList<String>();
		generoak1.add("Romance");
		generoak1.add("Disaster");
		generoak2.add("Science fiction");
		
		Pelikula p1 = new Pelikula(3000,"Titanic",generoak1);
		Pelikula p2 = new Pelikula(5000,"Avatar",generoak2);
		
		z1.pelikulaGehitu(3000, p1);
		z1.pelikulaGehitu(4000, p2);
		
		assertTrue(z1.pelikulakEskuratu().get(0).equals(p1.getTitulua()));
		assertFalse(z1.pelikulakEskuratu().get(1).equals(p1.getTitulua()));
	}

	@Test
	public void testDatuakEzabatu() {
		ArrayList<String> generoak1 = new ArrayList<String>();
		generoak1.add("Romance");
		generoak1.add("Disaster");
		
		Pelikula p1 = new Pelikula(5000,"Titanic",generoak1);
		z1.pelikulaGehitu(5000, p1);
		
		assertFalse(z1.getPelikulak().isEmpty());
		assertFalse(z1.getIdPelikulak().isEmpty());
		
		z1.datuakEzabatu();
		
		assertTrue(z1.getPelikulak().isEmpty());
		assertTrue(z1.getIdPelikulak().isEmpty());
	}
	
	@Test
	public void testBadago() {
		ArrayList<String> generoak1 = new ArrayList<String>();
		ArrayList<String> generoak2 = new ArrayList<String>();
		generoak1.add("Romance");
		generoak1.add("Disaster");
		generoak2.add("Science fiction");
		
		Pelikula p1 = new Pelikula(6000,"Titanic",generoak1);
		Pelikula p2 = new Pelikula(7000,"Avatar",generoak2);
		
		z1.pelikulaGehitu(6000, p1);
		
		assertTrue(z1.badago(6000));
		assertFalse(z1.badago(7000));
	}

}
