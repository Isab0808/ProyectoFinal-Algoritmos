package modelo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {
	
	Mapa mapa;
	Personaje personaje;
	Enemigo enemi;
	Herramienta herramienta;

	private int estado,segundos,minutos;
	
	PImage[] pantalla;
	PImage[] adornoMatriz;
	PImage[] herramientas;

	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;
	
	PImage nivel;
	PImage enemigo;
	PImage persona;
	PImage vida;
	
	PImage herramienta1;
	
	ArrayList<Herramienta> listaHerramienta;
	ArrayList<Enemigo> enemigos;
	
	
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

		nivel = app.loadImage("Nivel1.jpg");
	
		enemigo = app.loadImage("Enemigo1.png");
		
		adornoMatriz = new PImage[5];
		adornoMatriz[0] = app.loadImage("Arbol.png");
		adornoMatriz[1] = app.loadImage("Pala.png");
		adornoMatriz[2] = app.loadImage("Matas.png");
		adornoMatriz[3] = app.loadImage("Tronco.png");
		adornoMatriz[4] = app.loadImage("Lago.png");
		
		herramientas = new PImage[2];
		herramientas[0] = app.loadImage("Herramienta1.png");
		herramientas[1] = app.loadImage("Herramienta2.png");
		
		vida = app.loadImage("Vida.png");
		
		herramienta1 = app.loadImage("Herramienta1.png");
		
		mapa = new Mapa(muro1, muro2, muro3, muro4, muro5, app);
		personaje = new Personaje(1, 1, mapa);
		
		enemigos  = new ArrayList<>();
		enemigos.add(new Enemigo(8,1,mapa,0));
		enemigos.add(new Enemigo(10,5,mapa,1));
		enemigos.add(new Enemigo(4,10,mapa,0));
		enemigos.add(new Enemigo(1,15,mapa,1));
		enemigos.add(new Enemigo(1,20,mapa,0));
		enemigos.add(new Enemigo(2,22,mapa,0));
		
		herramienta = new Herramienta(0, 0);
		listaHerramienta = new ArrayList<Herramienta>();
		listaHerramienta.add(new Herramienta(8, 8));
		listaHerramienta.add(new Herramienta(1, 17));
		listaHerramienta.add(new Herramienta(10, 22));
	}

	public void pintarPantalla(final PApplet app) {

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
			app.image(nivel, 0, 0);
			
			mapa.pintar();
			personaje.pintar(app,persona);
			
			// int index, condicion, accion a srguir
			//tipo de referencia instancio => lista 
			for (Enemigo enemigo : enemigos) {
				enemigo.pintar(app, this.enemigo);
				enemigos.indexOf(enemigo);
			}
			new Thread(
					new Runnable() {
						@Override
						public void run() {
							try {
								if(app.frameCount%60==0) {
									for (Enemigo enemigo : enemigos) {
										enemigo.tipoDireccion();
									}
								}
								Thread.sleep(1000);
								
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					).start();
				
			app.imageMode(PConstants.CORNER);
			pintarAdornos(app);
			
			temporizador(app);
			
			//For para pintar las vidas del personaje
			app.imageMode(PConstants.CENTER);
			for (int i = 0; i < personaje.getVidas(); i++) {
				app.image(vida, 993 + i*30, 50);}
			
			//For para pintar la lista de herramientas, para validar el area sensible de personaje y herramienta
			//Si se coincide con el area sensible de los dos, el personaje obtiene 1 vida y la herramienta se elimina de la lista de herramientas
			for (int i = 0; i < listaHerramienta.size(); i++) {
				listaHerramienta.get(i).pintar(app, herramienta1);
				Herramienta herramientaActual = listaHerramienta.get(i);
				if ((personaje.getX() -25 >= herramientaActual.getX()-25 && personaje.getX() -25 <= herramientaActual.getX()-25 + 50)
						|| (personaje.getX() -25 + 50 >= herramientaActual.getX()-25
								&& personaje.getX()-25 + 50 <= herramientaActual.getX()-9 + 50)) {
					if ((personaje.getY()-25 >= herramientaActual.getY()-25
							&& personaje.getY()-25 <= herramientaActual.getY() + 50)
						|| (personaje.getY()-25 + persona.height >= herramientaActual.getY() -25
								&& personaje.getY()-25 + persona.height <= herramientaActual.getY()-25 + 50)) {
						personaje.darVida();
						listaHerramienta.remove(i);
					}
				}
			}
			break;

		// Pantalla nivel 2
		case 6:
			
			break;

		// Pantalla nivel 3
		case 7:
			
			break;
			
		// Pantalla nivel 4
		case 8:
			
			break;
		}
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	// Se pintaron los objetos del mapa
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
