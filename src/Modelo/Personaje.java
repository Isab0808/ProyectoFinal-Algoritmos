package Modelo;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Personaje {
	
	
Logica refLogica;
Mapa refMapa;
Herramienta refHerramienta;
PImage personaje;




double tiempoInicial;
int x, y, col,fil,vidas;

public Personaje (int fil, int col, Mapa refMapa) {
this.col=col;
this.fil = fil;
this.vidas=1;
this.x=25+(col*50); //En donde se encuentra el personaje 
this.y=15+(fil*50);
this.refMapa=refMapa;

tiempoInicial=0;
	
	
}

public void pintar (PApplet app, PImage personaje, PImage herramienta) { //Parametros mapa pinta personaje + herramienta
	//app.imageMode(PConstants.CENTER);
	//app.image(personaje, x, y);
	app.fill(255,81,58);
	app.ellipse(x, y, 25, 25);
	if (refHerramienta!=null) {
		//refHerramienta.pintar(app,herramienta,this);
		tiempo();
	}
	//app.imageMode(PConstants.CORNER);
	
}


public void tiempo () {
	
	double tiempoActual=System.currentTimeMillis();
	if (tiempoActual-tiempoInicial>15) {
		refHerramienta=null;
	}
}

public void darVida () {
if (vidas<3) {
	vidas++;}
}

public void quitarVida (int vida) {
	vidas-=vida;
}
public int getVidas() {
	return vidas;
}
public int getWidht () {
	return personaje.width;
}public int getHeight () {
	return personaje.height;
}
public int getX() {
	return x;
	
}
public int getY() {
	return y;
	
}
}
