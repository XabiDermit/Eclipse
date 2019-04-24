package Probak;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Proiektua.Erabiltzailea;
import Proiektua.Pelikula;
import Proiektua.PelikulaKatalogo;
import Proiektua.ProduktuIragaztea;

public class ProbaProduktuIragaztea {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayList<String> generoak = new ArrayList<String>();
		generoak.add("Adibidea");
		Pelikula p1 = new Pelikula(1,"Titanic",generoak);
		Pelikula p2 = new Pelikula(2,"Avatar",generoak);
		Pelikula p3 = new Pelikula(3,"Matrix",generoak);
		
		Erabiltzailea e1 = new Erabiltzailea(1);
		Erabiltzailea e2 = new Erabiltzailea(2);
		Erabiltzailea e3 = new Erabiltzailea(3);
		
		PelikulaKatalogo.getPelikulaKatalogo().gehituPelikula(1,p1);
		PelikulaKatalogo.getPelikulaKatalogo().gehituPelikula(2,p2);
		PelikulaKatalogo.getPelikulaKatalogo().gehituPelikula(3,p3);
		
		p1.balorazioaGehitu(1, 3.5);
		p1.balorazioaGehitu(2, 5.0);
		p2.balorazioaGehitu(1, 2.5);
		p2.balorazioaGehitu(3, 0.5);
		p3.balorazioaGehitu(1, 1.5);
		p3.balorazioaGehitu(2, 4.0);
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
	public void testBalorazioEstimazioa() {
		ProduktuIragaztea prodIr = new ProduktuIragaztea();
		Double est = prodIr.balorazioEstimazioa(3, 3);
		assertTrue()
	}

}
