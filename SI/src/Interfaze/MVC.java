package Interfaze;

import java.util.ArrayList;


import Proiektua.GomendioSistema;
import Proiektua.IragazteSistema;
import Proiektua.PelikulaKatalogo;
import Salbuespenak.ErabiltzaileaEzDaExistitzenException;
import Salbuespenak.KargaMotaEzDaExistitzenException;
import Salbuespenak.PelikulaEzDaExistitzenException;
public class MVC {

	private static MVC nireDatuak = null;
	
	private MVC() {}
	
	public static synchronized MVC getNireDatuak() {
		if (nireDatuak == null) {
			nireDatuak = new MVC();
		}
		return nireDatuak;
	}
	
	public void Datuak_Kargatu() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
	}
	
	public void datuakEzabatu() {
		PelikulaKatalogo.getPelikulaKatalogo().datuakEzabatu();
		GomendioSistema.getGomendioSistema().datuakEzabatu();
	}
	
	public ArrayList<String> getPelikulak(){
		return PelikulaKatalogo.getPelikulaKatalogo().pelikulakEskuratu();
	}
	
	public ArrayList<String> getErabiltzaileak() throws ErabiltzaileaEzDaExistitzenException{
		return GomendioSistema.getGomendioSistema().erabiltzaileakEskuratu();
	}
	
	public double erabiltzaileaBalorazioaEstimazioa(int idUser, int idMovie) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException {
		return IragazteSistema.getIragazteSistema().erabiltzaileaBalorazioaEstimazioa(idUser, idMovie);
	}
	
	public double produktuaBalorazioaEstimazioa(int idUser, int idMovie) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException {
		return IragazteSistema.getIragazteSistema().produktuaBalorazioaEstimazioa(idUser, idMovie);
		
	}
	public double ezaugarriaBalorazioaEstimazioa(int idUser, int idMovie) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException {
		return IragazteSistema.getIragazteSistema().ezaugarriaBalorazioaEstimazioa(idUser, idMovie);
}
	
}