package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Herramienta {
	
	protected int x, y, fil, col, aumentoVida;
	
	Logica refLogica;
	PImage herramienta1;
	
	public Herramienta(int fil, int col) {
		this.fil = fil;
		this.col = col;
		this.x =25+(col*50);
		this.y =25+(fil*50)+100;
	}
	
	public void pintar(PApplet app, PImage herramienta1) {
		app.image(herramienta1, x, y);
		//app.fill(255,255,0);
		//app.ellipse(x, y, 25, 25);
	}
	
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}

}
