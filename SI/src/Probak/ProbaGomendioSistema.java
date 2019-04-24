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

public class ProbaGomendioSistema {

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
	public void testGetGomendioSistema() {
		assertNotNull(GomendioSistema.getGomendioSistema());
	}

	@Test
	public void testDatuakKargatu() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
		
		// datuakKargatu() metodoan datuen karga mota sortzen da (KargaFactory.createKarga() metodoan frogatu duguna)
		// eta karga motaren arabera DatuenKarga.datuakKargatu() metodoa exekutatzen du (DatuenKarga.datuakKargatu() metodoan frogatu duguna).
		// Beraz, froga honetan GomendioSistema klaseko atributuak (pelikulak eta erabiltzaileak) hutsik ez daudela frogatuko dugu:
		
		assertNotEquals(GomendioSistema.getGomendioSistema().getErabiltzaileak().size(),0);
		assertNotEquals(PelikulaKatalogo.getPelikulaKatalogo().getPelikulak().size(),0);
	}

	@Test
	public void testGehituErabiltzailea() throws ErabiltzaileaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().gehituErabiltzailea(1, e1);
		GomendioSistema.getGomendioSistema().gehituErabiltzailea(2, e2);
		assertEquals(GomendioSistema.getGomendioSistema().getErabiltzailea(1),e1);
		assertEquals(GomendioSistema.getGomendioSistema().getErabiltzailea(2),e2);
		assertNotEquals(GomendioSistema.getGomendioSistema().getErabiltzailea(1),e2);
	}

	@Test
	public void testErregistratutaDago() {
		GomendioSistema.getGomendioSistema().gehituErabiltzailea(1, e1);
		GomendioSistema.getGomendioSistema().gehituErabiltzailea(2, e2);
		assertTrue(GomendioSistema.getGomendioSistema().erregistratutaDago(1));
		assertTrue(GomendioSistema.getGomendioSistema().erregistratutaDago(2));
		assertFalse(GomendioSistema.getGomendioSistema().erregistratutaDago(3));

	}

	@Test
	public void testGetErabiltzailea() throws ErabiltzaileaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().gehituErabiltzailea(1, e1);
		GomendioSistema.getGomendioSistema().gehituErabiltzailea(2, e2);
		assertEquals(GomendioSistema.getGomendioSistema().getErabiltzailea(1),e1);
		assertEquals(GomendioSistema.getGomendioSistema().getErabiltzailea(2),e2);
		assertNotEquals(GomendioSistema.getGomendioSistema().getErabiltzailea(1),e2);
		//GomendioSistema.getGomendioSistema().getErabiltzailea(3);		// idUser = 3 duen erabiltzailea ez da existitzen eta salbuespena emango da
	}

	@Test
	public void testErabiltzaileakEskuratu() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
		ArrayList<String> idUser = GomendioSistema.getGomendioSistema().erabiltzaileakEskuratu();
		assertEquals(idUser.size(), 610); 							// 610 erabiltzaile desberdin irakurtzen dira
		assertNotEquals(idUser.size(), 100);
		String lehena = idUser.get(0);
		String azkena = idUser.get(609);
		assertEquals(lehena,"'1' erabiltzaileak 232 pelikula ikusi ditu.");			// Lehen erabiltzaileak 232 pelikula ikusi ditu
		assertEquals(azkena,"'610' erabiltzaileak 1302 pelikula ikusi ditu.");		// Azken erabiltzaileak 1302 pelikula ikusi ditu
		assertNotEquals(azkena,"'1' erabiltzaileak 232 pelikula ikusi ditu.");
		assertNotEquals(lehena,"'610' erabiltzaileak 1302 pelikula ikusi ditu.");
	}

	@Test
	public void testDatuakEzabatu() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
		assertNotEquals(GomendioSistema.getGomendioSistema().getErabiltzaileak().size(),0);
		GomendioSistema.getGomendioSistema().datuakEzabatu();
		assertEquals(GomendioSistema.getGomendioSistema().getErabiltzaileak().size(),0);
	}

}
