package modelo;

public class Usuario {

	private String usuario;
	private String contrase�a;
	private String confirmarContrase�a;
	private String nombre;
	private Partida p;

	public  Usuario(String usuario,String contrase�a, String confirmarContrase�a, String nombre, Partida p) {
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.confirmarContrase�a = confirmarContrase�a;
		this.nombre = nombre;
		this.p = p;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getConfirmarContrase�a() {
		return confirmarContrase�a;
	}

	public void setConfirmarContrase�a(String confirmarContrase�a) {
		this.confirmarContrase�a = confirmarContrase�a;
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
