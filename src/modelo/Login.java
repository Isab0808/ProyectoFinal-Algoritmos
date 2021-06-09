package modelo;

import interfascia.GUIController;
import interfascia.IFLabel;
import interfascia.IFTextField;
import processing.core.PApplet;


public class Login {
	
	private GUIController c; 
	private IFTextField  input;
	private IFLabel l;
	private PApplet app;

	public Login(PApplet app) {

		c = new GUIController(app);
		input = new IFTextField("Usuario",app.width/2-50,app.height/2,200, "Usuario" );
		input.setHeight(30);
		l = new IFLabel("Usuario", app.width/2-50,app.height/2-20);
		input.addActionListener(app);
		this.app = app;
		
		c.add(input);
		c.add(l);
		//input.setLookAndFeel(lf);
	}
	
	public void pintar() {
		app.textSize(18);
		l.draw();
		input.draw();
		
		
		
	}
}
