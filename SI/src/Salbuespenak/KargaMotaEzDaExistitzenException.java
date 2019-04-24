package Salbuespenak;

public class KargaMotaEzDaExistitzenException extends Exception {
	
	public KargaMotaEzDaExistitzenException(String kargaMota) {
		super();
		mezua(kargaMota);
	}

	private void mezua(String kargaMota) {
		System.out.println("'" + kargaMota + "' datuak kargatzeko era ez da existitzen.");
	}
}
