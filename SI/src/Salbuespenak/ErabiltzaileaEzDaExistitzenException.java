package Salbuespenak;

public class ErabiltzaileaEzDaExistitzenException extends Exception {
	
	public ErabiltzaileaEzDaExistitzenException(int idUser) {
		super();
		mezua(idUser);
	}
	
	private void mezua(int idUser) {
		System.out.println("'" + idUser + "' erabiltzailea ez da existitzen.");
	}

	
}
