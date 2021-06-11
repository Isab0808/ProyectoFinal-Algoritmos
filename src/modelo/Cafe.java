package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Cafe {

	protected int x, y, fil, col;

	Logica refLogica;
	PImage cafe;
	
	public Cafe (int fil, int col) {
		this.fil = fil;
		this.col = col;
		this.x =20+(col*50);
		this.y =25+(fil*50)+100;
	}
	
	public void pintar(PApplet app, PImage cafe) {
		app.image(cafe, x, y);
	}
	
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}

}
