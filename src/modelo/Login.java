package modelo;



import interfascia.GUIController;

import interfascia.IFButton;
import interfascia.IFLabel;
import interfascia.IFTextField;
import processing.core.PApplet;


public class Login  {
	
	private GUIController c; 
	private IFTextField  input;
	private IFTextField password;
	private IFLabel l,lp;
	private PApplet app;
	private IFButton b1;


	public Login(PApplet app) {
		
		c = new GUIController(app);
		
		input = new IFTextField("Usuario",app.width/2-50,app.height/2,200, "Usuario" );
		input.setHeight(25);
		
		password = new IFTextField("Contraseña",app.width/2-50,app.height/2+60,200, "Contraseña" );
		password.setHeight(25);
		
		l = new IFLabel("Usuario", app.width/2-50,app.height/2-20);
		input.addActionListener(app);
		
		lp = new IFLabel("Contraseña", app.width/2-50,app.height/2+40);
		input.addActionListener(app);
		
		  b1 = new IFButton ("Ingresar", app.width/2-50,app.height/2+110, 200, 30);
		  
			this.app = app;
			
			c.add(input);
			c.add(l);
			c.add(password);
			c.add(lp);
			c.add(b1);
			
			b1.addActionListener(this);

		//input.setLookAndFeel(lf);
		
	}
	
	
	
	public void stopVisualization () {
		c.remove(input);
		c.remove(l);
		c.remove(password);
		c.remove(lp);
		b1.setPosition(-200, -2000);
		

	}
	
	public void continueVisualization () {
		c.add(input);
		c.add(l);
		c.add(password);
		c.add(lp);
		c.add(b1);
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



	public IFButton getB1() {
		return b1;
	}



	public void setB1(IFButton b1) {
		this.b1 = b1;
	}
	
	

	
}
