package controlador;

import modelo.Logica;
import processing.core.PApplet;

public class Control {
	
	private Logica logica;
	
	public Control (PApplet app) {logica = new Logica (app); }
	
	public void pintarPantalla (PApplet app) {
		logica.pintarPantalla(app);
	}
	
	public void moverPersonaje(char key) {
		switch (key) {
		case 'w':
			logica.getPersonaje().mover("arriba");
			break;
		case 's':
			logica.getPersonaje().mover("abajo");
			break;
		case 'd':
			logica.getPersonaje().mover("derecha");
			break;
		case 'a':
			logica.getPersonaje().mover("izquierda");
			break;
		}
	}
	
	public void clic (PApplet app) {
		logica.clic(app);
	}
}


