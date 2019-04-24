package Proiektua;

import java.util.ArrayList;

import Salbuespenak.ErabiltzaileaEzDaExistitzenException;
import Salbuespenak.KargaMotaEzDaExistitzenException;
import Salbuespenak.PelikulaEzDaExistitzenException;

public class IragazteSistema {
	private ErabiltzaileIragaztea erab;
	private ProduktuIragaztea produk;
	private EzaugarriIragaztea ezau;
	private static IragazteSistema nIragazteSistema = null;
	
	private IragazteSistema() {
		erab = new ErabiltzaileIragaztea();
		produk = new ProduktuIragaztea();
		ezau = new EzaugarriIragaztea();
	}
	
	public static synchronized IragazteSistema getIragazteSistema() {
		if(nIragazteSistema==null) {
			nIragazteSistema = new IragazteSistema();
		}
		return nIragazteSistema;
	}
	
	public ArrayList<String> gomendatu(int idUser){  
		ArrayList<String> gomendioak = new ArrayList<String>();
		Tupla[] balorazioak = this.estimazioak(idUser);
		TuplaOrdenazioa.getTuplaAntzekOrdenazioa().handTxikOrdenatu(balorazioak);
		Tupla[] balorazioFinala = new Tupla[10];
		for (int i=0;i<10;i++) {
			balorazioFinala[i]= balorazioak[i];
		}
		gomendioak = PelikulaKatalogo.getPelikulaKatalogo().tuplatikIzenakLortu(balorazioFinala);
		return gomendioak;
	}
	
	public double erabiltzaileaBalorazioaEstimazioa(int idUser, int idMovie) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException {
		if (!GomendioSistema.getGomendioSistema().erregistratutaDago(idUser)) {
			throw new ErabiltzaileaEzDaExistitzenException(idUser);
		}
		else if(!PelikulaKatalogo.getPelikulaKatalogo().erregistratutaDago(idMovie)) {
			throw new PelikulaEzDaExistitzenException(idMovie);
		}
		return erab.balorazioEstimazioa(idUser, idMovie);
	}
	
	public double produktuaBalorazioaEstimazioa(int idUser, int idMovie) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException {
		if (!GomendioSistema.getGomendioSistema().erregistratutaDago(idUser)) {
			throw new ErabiltzaileaEzDaExistitzenException(idUser);
		}
		else if(!PelikulaKatalogo.getPelikulaKatalogo().erregistratutaDago(idMovie)) {
			throw new PelikulaEzDaExistitzenException(idMovie);
		}
		return produk.balorazioEstimazioa(idUser,idMovie);
	}
	
	public double ezaugarriaBalorazioaEstimazioa(int idUser, int idMovie) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException {
		if (!GomendioSistema.getGomendioSistema().erregistratutaDago(idUser)) {
			throw new ErabiltzaileaEzDaExistitzenException(idUser);
		}
		else if(!PelikulaKatalogo.getPelikulaKatalogo().erregistratutaDago(idMovie)) {
			throw new PelikulaEzDaExistitzenException(idMovie);
		}
		return ezau.balorazioEstimazioa(idUser, idMovie);
	}
	
	private Tupla[] estimazioak(int idUser){
		ArrayList<Integer> pelikulenIdak = new ArrayList<Integer>();
		pelikulenIdak = PelikulaKatalogo.getPelikulaKatalogo().idGuztiak();
		Erabiltzailea erabiltzailea = null;
		try {
			erabiltzailea = GomendioSistema.getGomendioSistema().getErabiltzailea(idUser);
		} catch (ErabiltzaileaEzDaExistitzenException e) {
			e.printStackTrace();
		}
		Tupla[] balorazioak = new Tupla[pelikulenIdak.size()-erabiltzailea.ikusitakoPelikulaKop()];
		int kont = 0;
		for (int i=0; i<pelikulenIdak.size();i++) {
			if (!erabiltzailea.ikusiDu(pelikulenIdak.get(i))) {
				int idMovie = pelikulenIdak.get(i);
				double notaerab = erab.balorazioEstimazioa(idUser, idMovie);
				double notaezaug = ezau.balorazioEstimazioa(idUser, idMovie);
				double notaproduk = produk.balorazioEstimazioa(idUser, idMovie);
				double batazBeste= this.notaMediaLortu(notaerab, notaezaug, notaproduk);
				balorazioak[kont] = new Tupla(idMovie,batazBeste);
				kont ++;
			}
		}
		return balorazioak;
	}
	
	private double notaMediaLortu(double erab, double ezaug, double produk) {
		return (0.5*erab)+(ezaug*0.25)+(produk*0.25);
	}
	
	public static void main(String[] args) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
		ArrayList<String> zer = IragazteSistema.getIragazteSistema().gomendatu(555);
		for(int i=0; i<zer.size(); i++) {
			System.out.println(zer.get(i));
		}
	}
}
