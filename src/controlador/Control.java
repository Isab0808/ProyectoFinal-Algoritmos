package controlador;

import exception.NoMoreCoffee;
import modelo.Logica;
import processing.core.PApplet;

public class Control {
	
	private Logica logica;
	
	public Control (PApplet app) {logica = new Logica (app); }
	
	public void pintarPantalla (PApplet app) {
		try {
			logica.pintarPantalla(app);
		} catch (NoMoreCoffee e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void ordenar(char key) {
		switch (key) {
		case 'z':
			logica.ordenarPuntajes('z');
			break;
		case 'x':
			logica.ordenarPuntajes('x');
			break;
		default:
			break;
		}
	}
	
	public void clic (PApplet app) {
		logica.clic(app);
	}
}


