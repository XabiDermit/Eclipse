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
import Proiektua.PelikulaKatalogo;
import Salbuespenak.ErabiltzaileaEzDaExistitzenException;
import Salbuespenak.KargaMotaEzDaExistitzenException;
import Salbuespenak.PelikulaEzDaExistitzenException;

public class ProbaPelikulaKatalogo {

	static Pelikula p1;
	static Pelikula p2;
	static Erabiltzailea e1;
	static Erabiltzailea e2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayList<String> generoak1 = new ArrayList<String>();
		generoak1.add("Romance");
		generoak1.add("Disaster");
		p1 = new Pelikula(1000,"Titanic",generoak1);
		ArrayList<String> generoak2 = new ArrayList<String>();
		generoak2.add("Science Fiction");
		p2 = new Pelikula(2000,"Avatar",generoak2);
		
		e1 = new Erabiltzailea(1);
		e2 = new Erabiltzailea(2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		p1 = null;
		p2 = null;
		
		e1 = null;
		e2 = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PelikulaKatalogo.getPelikulaKatalogo().erreseteatu();
		GomendioSistema.getGomendioSistema().erreseteatu();
	}

	@Test
	public void testGetPelikulaKatalogo() {
		assertNotNull(PelikulaKatalogo.getPelikulaKatalogo());
	}
	
	@Test
	public void testGehituPelikula() throws PelikulaEzDaExistitzenException {
		PelikulaKatalogo.getPelikulaKatalogo().gehituPelikula(1000, p1);
		PelikulaKatalogo.getPelikulaKatalogo().gehituPelikula(2000, p2);
		assertEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikula(1000),p1);
		assertEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikula(2000),p2);
		assertNotEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikula(1000),p2);
	}

	@Test
	public void testGetPelikula() throws PelikulaEzDaExistitzenException {
		PelikulaKatalogo.getPelikulaKatalogo().gehituPelikula(1000, p1);
		PelikulaKatalogo.getPelikulaKatalogo().gehituPelikula(2000, p2);
		assertEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikula(1000),p1);
		System.out.println(PelikulaKatalogo.getPelikulaKatalogo().zenbatPelikula());
		assertEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikula(2000),p2);
		assertNotEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikula(1000),p2);
		//PelikulaKatalogo.getPelikulaKatalogo().getPelikula(3000);		// idMovie = 3000 duen pelikula ez da existitzen eta salbuespena emango da
	}

	@Test
	public void testPelikulakEskuratu() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
		ArrayList<String> tituluak = PelikulaKatalogo.getPelikulaKatalogo().pelikulakEskuratu();
		assertEquals(tituluak.size(), 9742); 							// 9742 pelikula desberdin irakurtzen dira
		assertNotEquals(tituluak.size(), 100);
		String lehena = tituluak.get(0);
		String azkena = tituluak.get(9741);
		assertEquals(lehena,"Toy Story (1995)");						// Eskuratutako lehen pelikularen titulua da
		assertEquals(azkena,"Andrew Dice Clay: Dice Rules (1991)");		// Eskuratutako azken pelikularen titulua da
		assertNotEquals(azkena,"Toy Story (1995)");
		assertNotEquals(lehena,"Andrew Dice Clay: Dice Rules (1991)");
	}

	@Test
	public void testDatuakEzabatu() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
		assertNotEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikulak().size(),0);
		PelikulaKatalogo.getPelikulaKatalogo().datuakEzabatu();
		assertEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikulak().size(),0);
	}

}
