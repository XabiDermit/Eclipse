package Salbuespenak;

public class PelikulaEzDaExistitzenException extends Exception {
	
	public PelikulaEzDaExistitzenException(int idMovie) {
		super();
		mezua(idMovie);
	}
	
	private void mezua(int idMovie) {
		System.out.println("'" + idMovie + "' pelikula ez da existitzen.");
	}

	
}
