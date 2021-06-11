package modelo;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class Button {

	private PApplet app;
	private int posX;
	private int posY;
	private int tamX;
	private int tamY;
	private int tipo;
	private String textInfo;

	private PImage img;

	public Button(PApplet app, int posX, int posY, int tamX, int tamY, int tipo, String textInfo) {
		super();
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.tamX = tamX;
		this.tamY = tamY;
		this.tipo = tipo;
		this.textInfo = textInfo;


	}
	
	public Button(PApplet app, int posX, int posY, int tamX, int tamY, int tipo, String textInfo, PImage img) {
		super();
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.tamX = tamX;
		this.tamY = tamY;
		this.tipo = tipo;
		this.textInfo = textInfo;
		this.img = img;

	}

	public void pintar() {

		this.app.rectMode(PConstants.CENTER);
		this.app.textAlign(PConstants.CENTER, PConstants.CENTER);
		this.app.imageMode(PConstants.CENTER);
		this.app.textSize(16);
		this.app.noStroke();
		switch (this.tipo) {
		case 0:
			this.app.fill(255, 112, 51);
			this.app.rect(posX, posY, tamX, tamY);
			this.app.fill(255);
			this.app.text(this.textInfo, posX, posY);
			break;
		case 1:
			this.app.fill(255);
			this.app.rect(posX, posY, tamX, tamY);
			this.app.fill(255, 112, 51);
			this.app.text(this.textInfo, posX, posY);
			break;
		case 2:
			this.app.image(img, posX, posY);
			break;

		}

		if (this.app.mouseX > (this.posX - (this.tamX / 2)) && this.app.mouseX < (this.posX + (this.tamX / 2))
				&& this.app.mouseY > (this.posY - (this.tamY / 2)) && this.app.mouseY < (this.posY + (this.tamY / 2))) {
			switch (this.tipo) {
			case 0:
				this.app.fill(217, 89, 72);
				this.app.rect(posX, posY, tamX, tamY);
				this.app.fill(200);
				this.app.text(this.textInfo, posX, posY);
				break;
			case 1:
				this.app.fill(200);
				this.app.rect(posX, posY, tamX, tamY);
				this.app.fill(217, 89, 721);
				this.app.text(this.textInfo, posX, posY);
				break;
			case 2:
				break;

			}
		}
	}

	public boolean isHover() {
		boolean isSobre = false;

		if (this.app.mouseX > (this.posX - (this.tamX / 2)) && this.app.mouseX < (this.posX + (this.tamX / 2))
				&& this.app.mouseY > (this.posY - (this.tamY / 2)) && this.app.mouseY < (this.posY + (this.tamY / 2))) {
			isSobre = true;
		}
		return isSobre;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getTamX() {
		return tamX;
	}

	public void setTamX(int tamX) {
		this.tamX = tamX;
	}

	public int getTamY() {
		return tamY;
	}

	public void setTamY(int tamY) {
		this.tamY = tamY;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTextInfo() {
		return textInfo;
	}

	public void setTextInfo(String textInfo) {
		this.textInfo = textInfo;
	}

	public PImage getImg() {
		return img;
	}

	public void setImg(PImage img) {
		this.img = img;
	}

}
