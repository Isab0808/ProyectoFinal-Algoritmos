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
	PImage muro5;
	
	Mapa mapa;

	
	
	public Logica (PApplet app) {
		
		estado = 5;
		
		muro1 = app.loadImage("Muro1.png");	
		muro2 = app.loadImage("Muro2.png");	
		muro3 = app.loadImage("Muro3.png");	
		muro4 = app.loadImage("Muro4.png");
		muro5 = app.loadImage("Muro5.png");
				
		pantalla = new PImage[5];
		pantalla[0] = app.loadImage("pantallainicio.jpg");	
		pantalla[1] = app.loadImage("PantallaLogin.jpg");	
		pantalla[2] = app.loadImage("PantallaRegistro.jpg");	
		pantalla[3] = app.loadImage("Instrucciones1.jpg");	
		pantalla[4] = app.loadImage("Instrucciones2.jpg");	

		niveles = new PImage[4];
		niveles[0] = app.loadImage("Nivel1.jpg");	
		niveles[1] = app.loadImage("Nivel2.jpg");	
		niveles[2] = app.loadImage("Nivel3.jpg");	
		niveles[3] = app.loadImage("Nivel4.jpg");

		
		
	}
	
	public void pintarPantalla (PApplet app) {
		
	switch (estado) {
	
	//Pantalla inicio
	
	case 0: 
		app.image(pantalla [0],0,0);
		
		
	break;
	
	//Pantalla Login
	case 1: 
		app.image(pantalla [1],0,0);
			
	break;		
	
	//Pantalla Registro
	case 2: 
		app.image(pantalla [2],0,0);
		
		
	break;
	
	//Pantalla Instrucciones 1
		case 3: 
			app.image(pantalla [3],0,0);

	break;
	
	//Pantalla Instrucciones 2
	case 4: 
	app.image(pantalla [4],0,0);
								
	break;
	
	//Pantalla nivel 1
	case 5: 
	app.image(niveles [0],0,0);
	
		mapa = new Mapa();
		mapa.pintar(app, muro1, muro2, muro3, muro4, muro5);
									
	break;
	
	//Pantalla nivel 2
	case 6: 
	app.image(niveles [1],0,0);
									
	break;
	
	//Pantalla nivel 3
	case 7: 
	app.image(niveles [2],0,0);
									
	break;
	
	//Pantalla nivel 4
	case 8: 
	app.image(niveles [3],0,0);
									
	break;
		}	
		
	
	}
	

}//END
