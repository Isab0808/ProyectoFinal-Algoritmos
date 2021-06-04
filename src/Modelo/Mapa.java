package Modelo;

import java.util.Iterator;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Mapa {
	
	private int [][]mapa;
	
	private Herramienta herramienta;
	
	private Cafe cafe;
	
	Logica refLogica;
	
	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;
	
	public Mapa() {
		
		mapa= new int[10][25];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 25; j++) {
				mapa [i][j]=0;
			}
		}
		
		mapa [2][2]= 0;
		mapa [3][3]= 1;
		mapa [4][4]= 0;
		mapa [2][9]= 1;
		mapa [2][8]= 0;
		mapa [8][2]= 0;
		mapa [8][3]= 0;
	
		
	}
	
	public void pintar (PApplet app) {
		int x=7;
		int y=100;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 25; j++) {
				
				switch (mapa[i][j]) {
				
				case 0: 
					app.stroke(20);
					app.fill(0);
					
					break;
					
				case 1:
					//app.image(muro1, x, y);
					app.fill(255);
					break;
					
				case 2: 
					app.image(muro2, x, y);
					break;
					
				case 3:
					app.image(muro3, x, y);
					break;
					
				case 4:
					app.image(muro4, x, y);
					break;
					
				case 5:
					app.image(muro5, x, y);
					break;
					
				}
				
				/*x+=50;
				if (x>1000) {
					x=1;
				y+=50;*/
				
				app.rectMode(PConstants.CENTER);
				app.rect(x, y, 50, 50);
				app.rectMode(PConstants.CORNER);
				x+=50;
				
				}
				x=0;
				y+=50;
			
			}
		}
	
	}
	
			//public int getTipoMapa () {
	
	


