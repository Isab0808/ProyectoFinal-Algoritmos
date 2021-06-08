package vista;
import Controlador.Control;
import Modelo.Mapa;
import Modelo.Personaje;
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
	
	
	/**PImage[] pantalla;
	PImage[] niveles;
	
	//muros
	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;**/

		
	public void setup() {
		
		/**	
	muro1 = loadImage("Muro1.jpg");	
	muro2 = loadImage("Muro2.jpg");	
	muro3 = loadImage("Muro3.jpg");	
	muro4 = loadImage("Muro4.jpg");	
			
	pantalla = new PImage[5];
	pantalla[0] = loadImage("pantallainicio.jpg");	
	pantalla[1] = loadImage("PantallaLogin.jpg");	
	pantalla[2] = loadImage("PantallaRegistro.jpg");	
	pantalla[3] = loadImage("Instrucciones1.jpg");	
	pantalla[4] = loadImage("Instrucciones2.jpg");	

	niveles = new PImage[4];
	niveles[0] = loadImage("Nivel1.png");	
	niveles[1] = loadImage("Nivel2.png");	
	niveles[2] = loadImage("Nivel3.png");	
	niveles[3] = loadImage("Nivel4.png");	**/

	control = new Control(this);

	
	
	}
	
	
	public void draw() {
		background(255);
		
	control.pintarPantalla(this);
		
		
		
		
	}
	
	

	
	
	

	
}//FINAL
