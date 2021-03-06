package modelo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Personaje {

	Logica refLogica;
	Mapa refMapa;
	Herramienta refHerramientaInventario;
	PImage persona;

	int x, y, col, fil, vidas;

	public Personaje(int fil, int col, Mapa refMapa) {
		this.col = col;
		this.fil = fil;
		this.vidas = 1;
		this.x = 25 + (col * 50);
		this.y = 25 + (fil * 50) +100;
		this.refMapa = refMapa;
		
	}

	public void pintar(PApplet app, PImage persona) {
		app.imageMode(PConstants.CENTER);
		app.image(persona, x, y);
	}

	public void mover(String dir) {
		int valorDestino = 5;
		switch (dir) {
		case "arriba":
			valorDestino = refMapa.getTipoMapa(fil - 1, col);
			if (valorDestino == 5 ) {
				fil = fil - 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50)+100;
			}
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

	public void darVida() {
		if (vidas < 4) {
			vidas++;
		}
	}

	public void quitarVida(int vida) {
		vidas --;
	}

	public int getVidas() {
		return vidas;
	}

	public int getWidht() {
		return persona.width;
	}

	public int getHeight() {
		return persona.height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
