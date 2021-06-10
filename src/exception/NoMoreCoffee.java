package exception;

public class NoMoreCoffee extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMoreCoffee() {
		super("No hay más café");
	}
}
