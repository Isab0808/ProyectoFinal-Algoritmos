package exception;

public class UsuarioNoExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioNoExisteException() {
		super("El usuario no existe");
	}
}
