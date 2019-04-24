package Proiektua;

import java.util.ArrayList;
import java.util.HashMap;

import Salbuespenak.ErabiltzaileaEzDaExistitzenException;
import Salbuespenak.KargaMotaEzDaExistitzenException;
import Salbuespenak.PelikulaEzDaExistitzenException;

public class PelikulaKatalogo {

	private PelikulaZerrenda zerrenda;
	private static PelikulaKatalogo nPelikulak= null;
	
	private PelikulaKatalogo() {
		this.zerrenda = new PelikulaZerrenda();
	}
	
	public static synchronized PelikulaKatalogo getPelikulaKatalogo() {
		if( nPelikulak== null) {
			nPelikulak= new PelikulaKatalogo();
		}
		return nPelikulak;
	}
	
	public void gehituPelikula(Integer id, Pelikula p) {
		zerrenda.pelikulaGehitu(id, p);
	}
	
	public int zenbatPelikula() {
		return this.zerrenda.pelikulaKop();
	}
	
	public Pelikula getPelikula(int idMovie) throws PelikulaEzDaExistitzenException {
		Pelikula p = zerrenda.getPelikula(idMovie);
		if(p == null) {
			throw new PelikulaEzDaExistitzenException(idMovie);
		}
		return zerrenda.getPelikula(idMovie);
	}
	
	public ArrayList<String> pelikulakEskuratu(){
		return zerrenda.pelikulakEskuratu();
	}
	
	public void datuakEzabatu() {
		zerrenda.datuakEzabatu();
	}
	
	public HashMap<Integer, Pelikula> getPelikulak() {
		return zerrenda.getPelikulak();
	}

	public void erreseteatu() {
		PelikulaKatalogo.nPelikulak = null;
	}

	public Pelikula getPosiziokoPelikula(int pPos) {
		return zerrenda.getPosiziokoPelikula(pPos);
	}

	public boolean erregistratutaDago(int idMovie) {
		return zerrenda.erregistratutaDago(idMovie);
	}
	
	public ArrayList<Integer> idGuztiak(){
		return this.zerrenda.idGuztiak();
	}
	public ArrayList<String> tuplatikIzenakLortu(Tupla[] tuplak){
		ArrayList<String> izenak = new ArrayList<String>();
		for (int i = 0; i<tuplak.length;i++) {
			try {
				izenak.add(this.getPelikula(tuplak[i].getId()).getTitulua());
			} catch (PelikulaEzDaExistitzenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return izenak;
	}
	public static void main(String[] args) throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		GomendioSistema.getGomendioSistema().datuakKargatu();
		ArrayList<Tag> zer = PelikulaKatalogo.getPelikulaKatalogo().getPelikula(1).komentarioak();
		for(int i=0; i<zer.size(); i++) {
			System.out.println(zer.get(i).getKomentarioa() + "   " + zer.get(i).zenbatAldiz());
		}
	}
	
}
