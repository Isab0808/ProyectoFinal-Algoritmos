package modelo;

public class Partida {

	private String time;
	private String puntaje;

	public Partida(String time, String puntaje) {
		this.time = time;
		this.puntaje = puntaje;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}
}
