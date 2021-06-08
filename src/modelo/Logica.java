package modelo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {

	private int estado;
	PImage[] pantalla;
	PImage[] niveles;
	PImage[] enemigo;
	PImage[] herramientas;

	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;
	
	PImage persona;

	Mapa mapa;
	Personaje personaje;
	Herramienta herramienta;
	
	ArrayList<Herramienta> listaHerramienta;

	public Logica(PApplet app) {

		estado = 5;

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
		
		herramientas = new PImage[4];
		herramientas[0] = app.loadImage("Herramienta1.png");
		herramientas[1] = app.loadImage("Herramienta2.png");
		herramientas[2] = app.loadImage("Herramienta3.png");
		herramientas[3] = app.loadImage("Herramienta4.png");
		
		mapa = new Mapa(muro1, muro2, muro3, muro4, muro5, app);
		personaje = new Personaje(1, 1, mapa);
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

}