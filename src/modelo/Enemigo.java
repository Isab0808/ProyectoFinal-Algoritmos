package modelo;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Enemigo {
	
	private int x, y, col, fil, valorDestino, dañoEne, dir, tipoDir;
	
	Logica refLogica;
	Mapa refMapa;
	PImage enemigoI;

	public Enemigo(int fil, int col, Mapa refMapa, int tipoDir) {
		this.col = col;
		this.fil = fil;
		this.x = 25 + (col * 50);
		this.y = 25 + (fil * 50) +100;
		this.refMapa = refMapa;
		this.dir = 1;
		this.tipoDir = tipoDir;
		this.dañoEne = 1;
		
	}
	
	public void pintar(PApplet app, PImage enemigoI) {
		app.imageMode(PConstants.CENTER);
		app.image(enemigoI, x, y);
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
		//El cambio de direccion que va a tomar el enemigo
		switch (tipoDir) {
		case 0:
			if(dir==1) {
				mover("arriba");
			}
			
			if(dir==-1) {
				mover("abajo");
			}
			break;

		case 1:
			if(dir==1) {
				mover("izquierda");
			}
			
			if(dir==-1) {
				mover("derecha");
			}
			break;
		default:
			break;
		}
		
		//Si el valor del destino, es decir, a donde se dirige o esta el enemigo, es un muro distinto de 5
		//Entonces que su direccion se multiplique por -1, o se movera a la derecha, abajo, a la izquierda
		//a la derecha segun sea el caso del enemigo
		if(valorDestino!=5) {
			dir*=-1;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidht() {
		return enemigoI.width;
	}

	public int getHeight() {
		return enemigoI.height;
	}

	public int getDañoEne() {
		return dañoEne;
	}

	public void setDañoEne(int dañoEne) {
		this.dañoEne = dañoEne;
	}
}
