package Modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	
	private int estado;
	PImage[] pantalla;
	PImage[] niveles;
	
	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;

	
	
	public Logica (PApplet app) {
		
		estado = 0;
		
		muro1 = app.loadImage("Muro1.jpg");	
		muro2 = app.loadImage("Muro2.jpg");	
		muro3 = app.loadImage("Muro3.jpg");	
		muro4 = app.loadImage("Muro4.jpg");	
				
		pantalla = new PImage[5];
		pantalla[0] = app.loadImage("pantallainicio.jpg");	
		pantalla[1] = app.loadImage("PantallaLogin.jpg");	
		pantalla[2] = app.loadImage("PantallaRegistro.jpg");	
		pantalla[3] = app.loadImage("Instrucciones1.jpg");	
		pantalla[4] = app.loadImage("Instrucciones2.jpg");	

		niveles = new PImage[4];
		niveles[0] = app.loadImage("Nivel1.png");	
		niveles[1] = app.loadImage("Nivel2.png");	
		niveles[2] = app.loadImage("Nivel3.png");	
		niveles[3] = app.loadImage("Nivel4.png");	

		
		
	}
	
	public void pintarPantalla (PApplet app) {
		
	switch (estado) {
	
	//Pantalla inicio
	case 0: {
		app.image(pantalla [0],0,0);
		
	
	}
	
	default:
		
	}	
		
	}
	
	
	
	
	

}//END
