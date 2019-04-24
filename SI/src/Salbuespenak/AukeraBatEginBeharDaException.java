package Salbuespenak;

public class AukeraBatEginBeharDaException extends Exception {
	
	public AukeraBatEginBeharDaException() {
		super();
		mezua();
	}

	private void mezua() {
		System.out.println("Iragazte teknika bat aukeratu behar da.");
	}
}
