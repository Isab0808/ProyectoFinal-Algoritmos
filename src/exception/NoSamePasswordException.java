package exception;

public class NoSamePasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSamePasswordException() {
		super("Las contraseñas no coinciden");
	}

}
