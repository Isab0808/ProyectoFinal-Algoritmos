package modelo;
import interfascia.GUIController;

import interfascia.IFButton;
import interfascia.IFLabel;
import interfascia.IFTextField;
import processing.core.PApplet;


public class Register  {
	
	private GUIController c; 
	private IFTextField  input;
	private IFTextField password;
	private IFLabel l,lp,lpp,ln;
	private PApplet app;
	private IFButton b1;
	private IFTextField cpassword;
	private IFTextField name;
	


	public Register(PApplet app) {
		
		c = new GUIController(app);
		
		input = new IFTextField("Usuario",app.width/2-50,app.height/2,200 );
		input.setHeight(25);
		
		password = new IFTextField("Contraseña",app.width/2-50,app.height/2+60,200  );
		password.setHeight(25);
		
		l = new IFLabel("Usuario", app.width/2-50,app.height/2-20);
		input.addActionListener(app);
		
		lp = new IFLabel("Contraseña", app.width/2-50,app.height/2+40);
		password.addActionListener(app);
		
		cpassword = new IFTextField("CContraseña",app.width/2-50,app.height/2+120,200 );
		cpassword.setHeight(25);
		
		name = new IFTextField("Nombre",app.width/2-50,app.height/2+180,200);
		name.setHeight(25);
		
		ln = new IFLabel("CContraseña", app.width/2-50,app.height/2+100);
		name.addActionListener(app);
		
		lpp = new IFLabel("Nombre", app.width/2-50,app.height/2+160);
		cpassword.addActionListener(app);
		
		
		
		b1 = new IFButton ("Ingresar", app.width/2-50,app.height/2+220, 200, 30);
		  
			this.app = app;
			
			c.add(input);
			c.add(l);
			c.add(password);
			c.add(lp);
			c.add(b1);
			c.add(cpassword);
			c.add(name);
			c.add(lpp);
			c.add(ln);
			
			b1.addActionListener(this);

		//input.setLookAndFeel(lf);
		
	}
	
	
	
	public void stopVisualization () {
		c.remove(input);
		c.remove(l);
		c.remove(password);
		c.remove(lp);
		c.remove(cpassword);
		c.remove(name);
		c.remove(lpp);
		c.remove(ln);

	}
	
	public void continueVisualization () {
		c.add(input);
		c.add(l);
		c.add(password);
		c.add(lp);
		c.add(b1);
		c.add(cpassword);
		c.add(name);
		c.add(lpp);
		c.add(ln);
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



	public IFTextField getCpassword() {
		return cpassword;
	}



	public void setCpassword(IFTextField cpassword) {
		this.cpassword = cpassword;
	}



	public IFTextField getName() {
		return name;
	}



	public void setName(IFTextField name) {
		this.name = name;
	}



	public IFLabel getLpp() {
		return lpp;
	}



	public void setLpp(IFLabel lpp) {
		this.lpp = lpp;
	}



	public IFLabel getLn() {
		return ln;
	}



	public void setLn(IFLabel ln) {
		this.ln = ln;
	}
	
	

	
}
