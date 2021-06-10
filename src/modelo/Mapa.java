package modelo;

import java.util.Iterator;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import vista.Main;

public class Mapa {

	private int[][] mapa;
	private Herramienta herramienta;

	private Cafe cafe;

	Main refMain;

	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;
	
	PImage herramienta1;
	PImage cafeG;

	PApplet app;

	public Mapa(PImage muro1, PImage muro2, PImage muro3, PImage muro4, PImage muro5, PApplet app) {

		this.muro1 = muro1;
		this.muro2 = muro2;
		this.muro3 = muro3;
		this.muro4 = muro4;
		this.muro5 = muro5;
		this.app = app;

		mapa = new int[12][24];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 24; j++) {
				mapa[i][j] = 0;
			}
		}

		mapa[0][0] = 1;
		mapa[0][1] = 1;
		mapa[0][2] = 1;
		mapa[0][3] = 1;
		mapa[0][4] = 1;
		mapa[0][5] = 1;
		mapa[0][6] = 1;
		mapa[0][7] = 1;
		mapa[0][8] = 1;
		mapa[0][9] = 1;
		mapa[0][10] = 1;
		mapa[0][11] = 1;
		mapa[0][12] = 1;
		mapa[0][13] = 1;
		mapa[0][14] = 1;
		mapa[0][15] = 1;
		mapa[0][16] = 1;
		mapa[0][17] = 1;
		mapa[0][18] = 1;
		mapa[0][19] = 1;
		mapa[0][20] = 1;
		mapa[0][21] = 1;
		mapa[0][22] = 1;
		mapa[0][23] = 1;

		mapa[1][0] = 1;
		mapa[1][1] = 5;
		mapa[1][2] = 2;
		mapa[1][3] = 2;
		mapa[1][4] = 5;
		mapa[1][5] = 5;
		mapa[1][6] = 5;
		mapa[1][7] = 5;
		mapa[1][8] = 2;
		mapa[1][9] = 2;
		mapa[1][10] = 2;
		mapa[1][11] = 3;
		mapa[1][12] = 3;
		mapa[1][13] = 2;
		mapa[1][14] = 2;
		mapa[1][15] = 5;
		mapa[1][16] = 5;
		mapa[1][17] = 5;
		mapa[1][18] = 5;
		mapa[1][19] = 5;
		mapa[1][20] = 5;
		mapa[1][21] = 2;
		mapa[1][22] = 2;
		mapa[1][23] = 1;

		mapa[2][0] = 1;
		mapa[2][1] = 5;
		mapa[2][2] = 5;
		mapa[2][3] = 5;
		mapa[2][4] = 5;
		mapa[2][5] = 4;
		mapa[2][6] = 4;
		mapa[2][7] = 5;
		mapa[2][8] = 2;
		mapa[2][9] = 2;
		mapa[2][10] = 2;
		mapa[2][11] = 2;
		mapa[2][12] = 2;
		mapa[2][13] = 2;
		mapa[2][14] = 3;
		mapa[2][15] = 5;
		mapa[2][16] = 4;
		mapa[2][17] = 4;
		mapa[2][18] = 4;
		mapa[2][19] = 4;
		mapa[2][20] = 5;
		mapa[2][21] = 3;
		mapa[2][22] = 5;
		mapa[2][23] = 1;

		mapa[3][0] = 1;
		mapa[3][1] = 5;
		mapa[3][2] = 3;
		mapa[3][3] = 5;
		mapa[3][4] = 4;
		mapa[3][5] = 4;
		mapa[3][6] = 4;
		mapa[3][7] = 5;
		mapa[3][8] = 2;
		mapa[3][9] = 2;
		mapa[3][10] = 2;
		mapa[3][11] = 2;
		mapa[3][12] = 2;
		mapa[3][13] = 2;
		mapa[3][14] = 2;
		mapa[3][15] = 5;
		mapa[3][16] = 4;
		mapa[3][17] = 4;
		mapa[3][18] = 4;
		mapa[3][19] = 4;
		mapa[3][20] = 5;
		mapa[3][21] = 2;
		mapa[3][22] = 5;
		mapa[3][23] = 1;

		mapa[4][0] = 1;
		mapa[4][1] = 5;
		mapa[4][2] = 2;
		mapa[4][3] = 5;
		mapa[4][4] = 5;
		mapa[4][5] = 5;
		mapa[4][6] = 5;
		mapa[4][7] = 5;
		mapa[4][8] = 2;
		mapa[4][9] = 2;
		mapa[4][10] = 5;
		mapa[4][10] = 5;
		mapa[4][11] = 5;
		mapa[4][12] = 5;
		mapa[4][13] = 5;
		mapa[4][14] = 5;
		mapa[4][15] = 5;
		mapa[4][16] = 5;
		mapa[4][17] = 5;
		mapa[4][18] = 5;
		mapa[4][19] = 5;
		mapa[4][20] = 5;
		mapa[4][21] = 2;
		mapa[4][22] = 5;
		mapa[4][23] = 1;

		mapa[5][0] = 1;
		mapa[5][1] = 5;
		mapa[5][2] = 2;
		mapa[5][3] = 3;
		mapa[5][4] = 2;
		mapa[5][5] = 5;
		mapa[5][6] = 2;
		mapa[5][7] = 2;
		mapa[5][8] = 2;
		mapa[5][9] = 3;
		mapa[5][10] = 5;
		mapa[5][11] = 2;
		mapa[5][12] = 2;
		mapa[5][13] = 3;
		mapa[5][14] = 5;
		mapa[5][15] = 5;
		mapa[5][16] = 2;
		mapa[5][17] = 2;
		mapa[5][18] = 3;
		mapa[5][19] = 2;
		mapa[5][20] = 5;
		mapa[5][21] = 5;
		mapa[5][22] = 5;
		mapa[5][23] = 1;

		mapa[6][0] = 1;
		mapa[6][1] = 5;
		mapa[6][2] = 2;
		mapa[6][3] = 2;
		mapa[6][4] = 2;
		mapa[6][5] = 5;
		mapa[6][6] = 2;
		mapa[6][7] = 2;
		mapa[6][8] = 3;
		mapa[6][9] = 2;
		mapa[6][10] = 5;
		mapa[6][11] = 3;
		mapa[6][12] = 2;
		mapa[6][13] = 2;
		mapa[6][14] = 2;
		mapa[6][15] = 5;
		mapa[6][16] = 2;
		mapa[6][17] = 2;
		mapa[6][18] = 3;
		mapa[6][19] = 2;
		mapa[6][20] = 5;
		mapa[6][21] = 2;
		mapa[6][22] = 5;
		mapa[6][23] = 1;

		mapa[7][0] = 1;
		mapa[7][1] = 5;
		mapa[7][2] = 3;
		mapa[7][3] = 2;
		mapa[7][4] = 2;
		mapa[7][5] = 5;
		mapa[7][6] = 3;
		mapa[7][7] = 2;
		mapa[7][8] = 2;
		mapa[7][9] = 2;
		mapa[7][10] = 5;
		mapa[7][11] = 2;
		mapa[7][12] = 2;
		mapa[7][13] = 2;
		mapa[7][14] = 3;
		mapa[7][15] = 5;
		mapa[7][16] = 3;
		mapa[7][17] = 2;
		mapa[7][18] = 2;
		mapa[7][19] = 2;
		mapa[7][20] = 5;
		mapa[7][21] = 3;
		mapa[7][22] = 5;
		mapa[7][23] = 1;

		mapa[8][0] = 1;
		mapa[8][1] = 5;
		mapa[8][2] = 2;
		mapa[8][3] = 2;
		mapa[8][4] = 2;
		mapa[8][5] = 5;
		mapa[8][6] = 2;
		mapa[8][7] = 2;
		mapa[8][8] = 5;
		mapa[8][9] = 3;
		mapa[8][10] = 5;
		mapa[8][11] = 2;
		mapa[8][12] = 2;
		mapa[8][13] = 2;
		mapa[8][14] = 2;
		mapa[8][15] = 5;
		mapa[8][16] = 2;
		mapa[8][17] = 5;
		mapa[8][18] = 5;
		mapa[8][19] = 5;
		mapa[8][20] = 5;
		mapa[8][21] = 2;
		mapa[8][22] = 5;
		mapa[8][23] = 1;

		mapa[9][0] = 1;
		mapa[9][1] = 5;
		mapa[9][2] = 3;
		mapa[9][3] = 2;
		mapa[9][4] = 3;
		mapa[9][5] = 5;
		mapa[9][6] = 2;
		mapa[9][7] = 2;
		mapa[9][8] = 5;
		mapa[9][9] = 2;
		mapa[9][10] = 5;
		mapa[9][11] = 3;
		mapa[9][12] = 5;
		mapa[9][13] = 5;
		mapa[9][14] = 5;
		mapa[9][15] = 5;
		mapa[9][16] = 5;
		mapa[9][17] = 5;
		mapa[9][18] = 2;
		mapa[9][19] = 2;
		mapa[9][20] = 2;
		mapa[9][21] = 3;
		mapa[9][22] = 5;
		mapa[9][23] = 1;

		mapa[10][0] = 1;
		mapa[10][1] = 5;
		mapa[10][2] = 5;
		mapa[10][3] = 5;
		mapa[10][4] = 5;
		mapa[10][5] = 5;
		mapa[10][6] = 5;
		mapa[10][7] = 5;
		mapa[10][8] = 5;
		mapa[10][9] = 5;
		mapa[10][10] = 5;
		mapa[10][11] = 2;
		mapa[10][12] = 2;
		mapa[10][13] = 2;
		mapa[10][14] = 2;
		mapa[10][15] = 3;
		mapa[10][16] = 2;
		mapa[10][17] = 5;
		mapa[10][18] = 5;
		mapa[10][19] = 5;
		mapa[10][20] = 5;
		mapa[10][21] = 5;
		mapa[10][22] = 5;
		mapa[10][23] = 1;

		mapa[11][0] = 1;
		mapa[11][1] = 1;
		mapa[11][2] = 1;
		mapa[11][3] = 1;
		mapa[11][4] = 1;
		mapa[11][5] = 1;
		mapa[11][6] = 1;
		mapa[11][7] = 1;
		mapa[11][8] = 1;
		mapa[11][9] = 1;
		mapa[11][10] = 1;
		mapa[11][10] = 1;
		mapa[11][11] = 1;
		mapa[11][12] = 1;
		mapa[11][13] = 1;
		mapa[11][14] = 1;
		mapa[11][15] = 1;
		mapa[11][16] = 1;
		mapa[11][17] = 1;
		mapa[11][18] = 1;
		mapa[11][19] = 1;
		mapa[11][20] = 1;
		mapa[11][21] = 1;
		mapa[11][22] = 1;
		mapa[11][23] = 1;
	}

	public void pintar() {
		int x = 25;
		int y = 110;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 24; j++) {

				switch (mapa[i][j]) {
				case 0:
					app.image(muro1, j * 50, i * 50 + 100);
					break;
				case 1:
					app.image(muro1, j * 50, i * 50 + 100);
					break;
				case 2:
					app.image(muro2, j * 50, i * 50 + 100);
					break;
				case 3:
					app.image(muro3, j * 50, i * 50 + 100);
					break;
				case 4:
					app.image(muro4, j * 50, i * 50 + 100);
					break;
				case 5:
					app.image(muro5, j * 50, i * 50 + 100);
					break;
				}
				x += 50;
			}
			if (x > 1000) {
				x = 25;
				y += 50;
			}
		}
		if (herramienta != null) {
			herramienta.pintar(app, herramienta1);
		}
		
		if (cafe != null) {
			cafe.pintar(app, cafeG);
		}
	}

	public int getTipoMapa(int fil, int col) {
		if (col >= 24 || fil >= 12 || col < 0 || fil < 0) {
			return 1;
		} else {
			return mapa[fil][col];
		}
	}

	public boolean validarHerramienta(int px, int py) {
		if (herramienta != null) {
			double dx = (herramienta.getX() - px) * (herramienta.getX() - px);
			double dy = (herramienta.getY() - py) * (herramienta.getY() - py);

			double resultado = Math.sqrt(dx + dy);
			if (resultado < 25) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validarCafe(int px, int py) {
		if (cafe != null) {
			double dx = (cafe.getX() - px) * (cafe.getX() - px);
			double dy = (cafe.getY() - py) * (cafe.getY() - py);

			double resultado = Math.sqrt(dx + dy);
			if (resultado < 25) {
				return true;
			}
		}
		return false;
	}
	
	public Herramienta getHerramienta() {
		if (herramienta != null) {
			Herramienta tempHerramienta = herramienta;
			herramienta = null;
			return tempHerramienta;
		}
		return null;
	}
	
	public Cafe getCafe() {
		if (cafe != null) {
			Cafe tempCafe = cafe;
			cafe = null;
			return tempCafe;
		}
		return null;
	}
}
