package vista;
import controlador.Control;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	private Control control;

	public static void main(String[] args) {
		PApplet.main("vista.Main");
	}

	public void settings() {
		size(1200, 700);
	}
	PImage[] pantalla;
	PImage[] niveles;

	public void setup() {
		control = new Control(this);
	} 

	public void draw() {
		background(255);

		control.pintarPantalla(this);
	}
	
	public void mousePressed() {
		control.clic(this);
	}
	
	public void keyPressed() {
		control.moverPersonaje(key);
	}
}
