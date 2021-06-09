package exception;

public class NoTextInsideException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTextInsideException(String faltante) {
		super("Por favor rellena todos los campos, falta : "+ faltante);
	}
}
