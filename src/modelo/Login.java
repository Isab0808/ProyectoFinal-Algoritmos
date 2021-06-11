package modelo;

import interfascia.GUIController;

import interfascia.IFLabel;
import interfascia.IFTextField;
import processing.core.PApplet;
import processing.core.PImage;

public class Login {

	private GUIController c;
	private IFTextField user;
	private IFTextField password;
	private IFLabel textUser, textPassword;
	private PApplet app;
	private Button botonIngresar;
	private boolean onScreen;

	public Login(PApplet app, PImage btnImage) {

		onScreen = false;
		
		//Libreria para el formulario
		c = new GUIController(app);

		// Formulario: Iniciar Sesion
		// Cajon Usuario
		user = new IFTextField("Usuario", app.width / 2 - 85, app.height / 2, 200, "Usuario");
		user.setHeight(25);

		// Texto Cajon Usuario
		textUser = new IFLabel("Usuario", app.width / 2 - 85, app.height / 2 - 20);
		user.addActionListener(app);

		// Cajon Contraseña
		password = new IFTextField("Contraseña", app.width / 2 - 85, app.height / 2 + 60, 200, "Contraseña");
		password.setHeight(25);

		// Texto Cajon Contraseña
		textPassword = new IFLabel("Contraseña", app.width / 2 - 85, app.height / 2 + 40);
		user.addActionListener(app);

		// Boton Ingresar
		botonIngresar = new Button(app, app.width / 2, 600, 200, 30, 2, "Ingresar", btnImage);

		this.app = app;
	}

	public void pintar() {
		botonIngresar.pintar();
	}

	// Para que se deje de pintar el formulario
	public void stopVisualization() {
		try {
			c.remove(user);
			c.remove(textUser);
			c.remove(password);
			c.remove(textPassword);
			onScreen = false;
		} catch (Exception e) {
		}
	}

	// Para que se pinte el formulario
	public void continueVisualization() {
		try {
			c.add(user);
			c.add(textUser);
			c.add(password);
			c.add(textPassword);
			onScreen = true;
		} catch (Exception e) {
		}
	}

	public GUIController getC() {
		return c;
	}

	public void setC(GUIController c) {
		this.c = c;
	}

	public IFTextField getInput() {
		return user;
	}

	public void setInput(IFTextField input) {
		this.user = input;
	}

	public IFTextField getPassword() {
		return password;
	}

	public void setPassword(IFTextField password) {
		this.password = password;
	}

	public IFLabel getL() {
		return textUser;
	}

	public void setL(IFLabel l) {
		this.textUser = l;
	}

	public IFLabel getLp() {
		return textPassword;
	}

	public void setLp(IFLabel lp) {
		this.textPassword = lp;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public Button getB1() {
		return botonIngresar;
	}

	public void setB1(Button b1) {
		this.botonIngresar = b1;
	}

	public boolean isOnScreen() {
		return onScreen;
	}

	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}

}
