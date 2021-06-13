package modelo;
import interfascia.GUIController;

import interfascia.IFLabel;
import interfascia.IFTextField;
import processing.core.PApplet;
import processing.core.PImage;

public class Register  {
	
	private GUIController c; 
	private IFTextField user;
	private IFTextField password;
	private IFLabel textUser,textPassword,textName,textCpassword;
	private PApplet app;
	private Button botonRegistrarse;
	private IFTextField cPassword;
	private IFTextField name;
	private boolean onScreen;
	
	public Register(PApplet app, PImage btnRegister) {
		
		onScreen= false;
		
		//Libreria para el formulario
		c = new GUIController(app);
		
		// Formulario: Registro
		// Cajon Usuario
		user = new IFTextField("Usuario",app.width/2- 85,app.height/2-80,200 );
		user.setHeight(25);
		
		// Texto Cajon Usuario
		textUser = new IFLabel("Usuario", app.width/2- 85,app.height/2-100);
		user.addActionListener(app);
		
		// Cajon Constraseña
		password = new IFTextField("Contraseña",app.width/2- 85,app.height/2-20,200);
		password.setHeight(25);
		
		// Texto Cajon Constraseña
		textPassword = new IFLabel("Contraseña", app.width/2- 85,app.height/2-40);
		password.addActionListener(app);
		
		// Cajon Confirmar Constraseña
		cPassword = new IFTextField("CContraseña",app.width/2- 85,app.height/2+40,200 );
		cPassword.setHeight(25);
		
		// Texto Cajon Confirmar Contraseña
		textCpassword = new IFLabel("CContraseña", app.width/2- 85,app.height/2+20);
		cPassword.addActionListener(app);
		
		// Cajon Nombre
		name = new IFTextField("Nombre",app.width/2- 85,app.height/2+100,200);
		name.setHeight(25);
		
		// Texto Cajon Nombre
		textName = new IFLabel("Nombre", app.width/2-85,app.height/2+80);
		name.addActionListener(app);
		
		// Boton Registrarse
		botonRegistrarse = new Button(app, app.width/2+10,app.height/2+220, 200, 30, 2, "Registrarse", btnRegister);
		
		this.app = app;
	}
	
	public void pintar() {
		botonRegistrarse.pintar();
	}
	
	public void stopVisualization () {
		try {
			c.setVisible(false);
			onScreen = false;
		} catch (Exception e) {
		}
	}
	
	public void continueVisualization () {
		try {
			c.setVisible(true);
			onScreen = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		return botonRegistrarse;
	}

	public void setB1(Button b1) {
		this.botonRegistrarse = b1;
	}

	public IFTextField getCpassword() {
		return cPassword;
	}

	public void setCpassword(IFTextField cpassword) {
		this.cPassword = cpassword;
	}

	public IFTextField getName() {
		return name;
	}

	public void setName(IFTextField name) {
		this.name = name;
	}

	public IFLabel getLpp() {
		return textName;
	}

	public void setLpp(IFLabel lpp) {
		this.textName = lpp;
	}

	public IFLabel getLn() {
		return textCpassword;
	}

	public void setLn(IFLabel ln) {
		this.textCpassword = ln;
	}

	public boolean isOnScreen() {
		return onScreen;
	}

	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}
}
