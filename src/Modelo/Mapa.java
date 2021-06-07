package Modelo;

import java.util.Iterator;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import vista.Main;

public class Mapa {
	
	private int [][]mapa;
	
	private Herramienta herramienta;
	
	private Cafe cafe;
	
Main refMain;
	
	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;
	
	Mapa myMuro1;
	Mapa myMuro2;
	Mapa myMuro3;
	Mapa myMuro4;
	Mapa myMuro5;
	
	
	public Mapa() {
		
		mapa= new int[12][24];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 24; j++) {
				mapa [i][j]=0;
			}
		}
		
		mapa [2][2]= 2;
		mapa [3][3]= 5;
		mapa [4][4]= 3;
		mapa [2][9]= 2;
		mapa [2][8]= 4;
		mapa [8][2]= 5;
		mapa [8][3]= 3;
		
	
		
	}
	
	public void pintar (PApplet app, PImage muro1, PImage muro2, PImage muro3, PImage muro4, PImage muro5) {
		int x=25;
		int y=110;
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 24; j++) {
				
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
					//app.image(muro2, x, y); 
					app.fill(255);
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
			if (x>1000) {
				x=25;
				y+=50;
			}
				
			
			}
		}
	public int getTipoMapa (int fil,int col) {
		if (col>=24 || fil>=12 ||col<0||fil<0) {
			return 1;
		} else {
			return mapa[fil][col];
		}
	}
	}
	
		
	
	


