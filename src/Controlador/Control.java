package Controlador;

import Modelo.Logica;
import processing.core.PApplet;

public class Control {
	
	
	private Logica logica;
	
	public Control (PApplet app) {logica = new Logica (app); }
	
	
	public void pintarPantalla (PApplet app) {
		
		logica.pintarPantalla(app);
		
	}
	
	public void mover() {
		
	}
}


