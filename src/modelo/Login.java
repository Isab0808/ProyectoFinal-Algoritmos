package modelo;

import java.awt.event.MouseEvent;

import interfascia.GUIController;
import interfascia.GUIEvent;
import interfascia.IFButton;
import interfascia.IFLabel;
import interfascia.IFTextField;
import processing.core.PApplet;


public class Login {
	
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
	
	public boolean actionPerformed () {
		
		  if (b1.isMouseOver(app.mouseX, app.mouseY)) {
			    input.getValue();
			    password.getValue();
			    System.out.println(input.getValue() + " "+ password.getValue());
			    return true;
			  }
		return false;
	}
	
	
}
