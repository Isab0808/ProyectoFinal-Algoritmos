package modelo;



import interfascia.GUIController;

import interfascia.IFLabel;
import interfascia.IFTextField;
import processing.core.PApplet;
import processing.core.PImage;


public class Login  {
	
	
	private GUIController c; 
	private IFTextField  input;
	private IFTextField password;
	private IFLabel l,lp;
	private PApplet app;
	private Button b1;
	private boolean onScreen;


	public Login(PApplet app, PImage btnImage) {
		
		onScreen = false;
		c = new GUIController(app);
		
		input = new IFTextField("Usuario",app.width/2-50,app.height/2,200, "Usuario" );
		input.setHeight(25);
		
		password = new IFTextField("Contraseña",app.width/2-50,app.height/2+60,200, "Contraseña" );
		password.setHeight(25);
		
		l = new IFLabel("Usuario", app.width/2-50,app.height/2-20);
		input.addActionListener(app);
		
		lp = new IFLabel("Contraseña", app.width/2-50,app.height/2+40);
		input.addActionListener(app);
		
		  b1 = new Button(app, app.width/2-50, 600, 200, 30, 2, "Ingresar", btnImage) ;
		  
			this.app = app;
			

			
			
			

		//input.setLookAndFeel(lf);
		
	}
	
	public void pintar() {
		b1.pintar();
	}
	
	
	
	public void stopVisualization () {
		try {
			c.remove(input);
			c.remove(l);
			c.remove(password);
			c.remove(lp);
			onScreen = false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

	}
	
	public void continueVisualization () {
		try {
			c.add(input);
			c.add(l);
			c.add(password);
			c.add(lp);
			onScreen = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

	}



	public GUIController getC() {
		return c;
	}



	public void setC(GUIController c) {
		this.c = c;
	}



	public IFTextField getInput() {
		return input;
	}



	public void setInput(IFTextField input) {
		this.input = input;
	}



	public IFTextField getPassword() {
		return password;
	}



	public void setPassword(IFTextField password) {
		this.password = password;
	}



	public IFLabel getL() {
		return l;
	}



	public void setL(IFLabel l) {
		this.l = l;
	}



	public IFLabel getLp() {
		return lp;
	}



	public void setLp(IFLabel lp) {
		this.lp = lp;
	}



	public PApplet getApp() {
		return app;
	}



	public void setApp(PApplet app) {
		this.app = app;
	}



	public Button getB1() {
		return b1;
	}



	public void setB1(Button b1) {
		this.b1 = b1;
	}

	public boolean isOnScreen() {
		// TODO Auto-generated method stub
		return onScreen;
	}
	
	
	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}
	
	
}
