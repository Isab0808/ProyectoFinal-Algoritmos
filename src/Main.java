import processing.core.PApplet;
import processing.core.PImage;



public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Main");	
	}

	
	public void settings() {
		size(1200, 700);
	}
	
	PImage[] pantalla;
	PImage[] niveles;
	
	//muros
	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;

		
	public void setup() {
		
	muro1 = loadImage("muro1.jpg");	
	muro2 = loadImage("muro2.jpg");	
	muro3 = loadImage("muro3.jpg");	
	muro4 = loadImage("muro4.jpg");	
			
	pantalla = new PImage[5];
	pantalla[0] = loadImage("Pantallainicio.jpg");	
	pantalla[1] = loadImage("PantallaLogin.jpg");	
	pantalla[2] = loadImage("PantallaRegistro.jpg");	
	pantalla[3] = loadImage("Instrucciones1.jpg");	
	pantalla[4] = loadImage("Instrucciones2.jpg");	

	niveles = new PImage[4];
	niveles[0] = loadImage("Nivel1.jpg");	
	niveles[1] = loadImage("Nivel2.jpg");	
	niveles[2] = loadImage("Nivel3.jpg");	
	niveles[3] = loadImage("Nivel4.jpg");	

	}
	
	
	public void draw() {
		background(255);
		
	
	}
	
	
public void keyPressed() {
	
	}
	
	
	

	
}//FINAL
