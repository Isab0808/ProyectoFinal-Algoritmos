package modelo;

public class Usuario {

	private String usuario;
	private String contraseña;
	private String confirmarContraseña;
	private String nombre;
	private Partida p;

	public  Usuario(String usuario,String contraseña, String confirmarContraseña, String nombre, Partida p) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.confirmarContraseña = confirmarContraseña;
		this.nombre = nombre;
		this.p = p;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getConfirmarContraseña() {
		return confirmarContraseña;
	}

	public void setConfirmarContraseña(String confirmarContraseña) {
		this.confirmarContraseña = confirmarContraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Partida getP() {
		return p;
	}

	public void setP(Partida p) {
		this.p = p;
	}
	
	
}
