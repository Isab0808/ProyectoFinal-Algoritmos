package modelo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {

	private int estado,segundos,minutos;
	PImage[] pantalla;
	PImage[] niveles;
	PImage[] enemigo;
	PImage[] adornoMatriz;

	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;
	
	PImage persona;
	PImage herramienta1;
	
	PImage vida;

	Mapa mapa;
	Personaje personaje;
	Enemigo enemi;
	Herramienta herramienta;
	
	ArrayList<Herramienta> listaHerramienta;
	
	int dir;

	public Logica(PApplet app) {

		estado = 5;
		segundos = 59;
		minutos = 2;

		muro1 = app.loadImage("Muro1.png");
		muro2 = app.loadImage("Muro2.png");
		muro3 = app.loadImage("Muro3.png");
		muro4 = app.loadImage("Muro4.png");
		muro5 = app.loadImage("Muro5.png");
		
		persona = app.loadImage("Personaje.png");
		
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
		
		enemigo = new PImage[4];
		enemigo[0] = app.loadImage("Enemigo1.png");
		enemigo[1] = app.loadImage("Enemigo2.png");
		enemigo[2] = app.loadImage("Enemigo3.png");
		enemigo[3] = app.loadImage("Enemigo4.png");
		
		adornoMatriz = new PImage[5];
		adornoMatriz[0] = app.loadImage("Arbol.png");
		adornoMatriz[1] = app.loadImage("Pala.png");
		adornoMatriz[2] = app.loadImage("Matas.png");
		adornoMatriz[3] = app.loadImage("Tronco.png");
		adornoMatriz[4] = app.loadImage("Lago.png");
		
		herramienta1 = app.loadImage("Herramienta1.png");
		
		vida = app.loadImage("Vida.png");
		
		mapa = new Mapa(muro1, muro2, muro3, muro4, muro5, app);
		personaje = new Personaje(1, 1, mapa);
		enemi = new Enemigo(8,1,mapa);
		dir =-1;
	}

	public void pintarPantalla(PApplet app) {

		switch (estado) {

		// Pantalla inicio
		case 0:
			app.image(pantalla[0], 0, 0);
			break;

		// Pantalla Login
		case 1:
			app.image(pantalla[1], 0, 0);
			break;

		// Pantalla Registro
		case 2:
			app.image(pantalla[2], 0, 0);
			break;

		// Pantalla Instrucciones 1
		case 3:
			app.image(pantalla[3], 0, 0);
			break;

		// Pantalla Instrucciones 2
		case 4:
			app.image(pantalla[4], 0, 0);
			break;

		// Pantalla nivel 1
		case 5:
			app.imageMode(PConstants.CORNER);
			app.image(niveles[0], 0, 0);
			
			mapa.pintar();
			personaje.pintar(app,persona);
			enemi.pintar(app, enemigo[0]);
			if(app.frameCount%60==0) {
				
				//dir = 1 o -1
				enemi.tipoDireccion();
			}
			app.imageMode(PConstants.CORNER);
			pintarAdornos(app);
			
			temporizador(app);
			
			app.imageMode(PConstants.CENTER);
			for (int i = 0; i < personaje.getVidas(); i++) {
				app.image(vida, 990 + i*30, 50);}
			break;

		// Pantalla nivel 2
		case 6:
			app.image(niveles[1], 0, 0);
			break;

		// Pantalla nivel 3
		case 7:
			app.image(niveles[2], 0, 0);
			break;
			
		// Pantalla nivel 4
		case 8:
			app.image(niveles[3], 0, 0);
			break;
		}
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public void pintarAdornos(PApplet app) {
		app.image(adornoMatriz[0], 89, 309);
		app.image(adornoMatriz[0], 140, 415);
		app.image(adornoMatriz[0], 307, 380);
		app.image(adornoMatriz[0], 405, 164);
		app.image(adornoMatriz[0], 392, 256);
		app.image(adornoMatriz[0], 545, 306);
		app.image(adornoMatriz[0], 638, 407);
		app.image(adornoMatriz[0], 784, 314);
		
		app.image(adornoMatriz[4], 875, 400);
		
		app.image(adornoMatriz[3], 820, 231);
		app.image(adornoMatriz[3], 880, 231);
		app.image(adornoMatriz[3], 845, 260);
		
		app.image(adornoMatriz[2], 567, 200);
		app.image(adornoMatriz[2], 515, 265);
		app.image(adornoMatriz[2], 600, 265);
		app.image(adornoMatriz[2], 843, 465);
		app.image(adornoMatriz[2], 919, 465);
		
		app.image(adornoMatriz[1], 297, 206 );
	}
	
	public void temporizador(PApplet app) {
		if (app.frameCount % 60 == 0 && minutos >= 0) {
			segundos--;
		}
		if (segundos == 0) {
			minutos--;
			segundos = 59;
		}
		if (minutos < 0) {
			app.fill(255);
			app.textSize(23);
			app.text("0:00", 141, 60);
		} else if (segundos <= 9) {
			app.fill(255);
			app.textSize(23);
			app.text(minutos + ":0" + segundos, 141, 60);
		} else if (segundos > 9) {
			app.fill(255);
			app.textSize(23);
			app.text(minutos + ":" + segundos, 141, 60);
		}
	}

}
