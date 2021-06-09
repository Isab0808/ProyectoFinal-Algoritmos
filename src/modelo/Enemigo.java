package modelo;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Enemigo {
	
	Logica refLogica;
	Mapa refMapa;
	int valorDestino;
	PImage persona;
	int dir;

	
	int x, y, col, fil, vidas;

	public Enemigo(int fil, int col, Mapa refMapa) {
		this.col = col;
		this.fil = fil;
		this.vidas = 1;
		this.x = 25 + (col * 50);
		this.y = 25 + (fil * 50) +100;
		this.refMapa = refMapa;
		this.dir = 1;
		
	}
	
	public void pintar(PApplet app, PImage persona) {
		app.imageMode(PConstants.CENTER);
		app.image(persona, x, y);
		
	}
	
	public void mover(String dir) {

		valorDestino = 5;
		switch (dir) {
		case "arriba":
			valorDestino = refMapa.getTipoMapa(fil - 1, col);
			if (valorDestino == 5) {
				fil = fil - 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50)+100;
				
			}
			System.out.println(valorDestino);
			break;

		case "abajo":
			valorDestino = refMapa.getTipoMapa(fil + 1, col);
			fil = fil + 1;
			if (valorDestino == 5) {
				
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50)+100;
				
			}
			break;

		case "derecha":
			valorDestino = refMapa.getTipoMapa(fil, col + 1);
			if (valorDestino == 5) {
				col = col + 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50)+100;
				
			}
			break;

		case "izquierda":
			valorDestino = refMapa.getTipoMapa(fil, col - 1);
			if (valorDestino == 5 ) {
				col = col - 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50)+100;
				
			}
			break;
		}
	}
	
	public void tipoDireccion() {
		// si se hoca no sea boludo cambie de direccion
		if(dir==1) {
			mover("arriba");
		}
		
		if(dir==-1) {
			mover("abajo");
		}
		
		if(valorDestino!=5) {
			//System.out.println("enenmi"+" "+ enemi.valorDestino + " " + dir);
			dir*=-1; // dir = dir * -1  // - * - = + // +* - = -
		}
	}
}
