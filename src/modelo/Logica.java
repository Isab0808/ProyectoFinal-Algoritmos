package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

import exception.NoSamePasswordException;
import exception.NoTextInsideException;
import exception.UsuarioNoExisteException;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {

	Mapa mapa;
	Personaje personaje;
	Enemigo enemi;
	Herramienta herramienta;
	Login login;

	private int estado, segundos, minutos;

	PImage[] pantalla;
	PImage[] adornoMatriz;

	PImage[] botones;

	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;

	PImage nivel;
	PImage enemigo;
	PImage persona;
	PImage vida;

	PImage vitamina;

	ArrayList<Herramienta> listaHerramienta;
	ArrayList<Enemigo> enemigos;
	
	LinkedList<Usuario> usuarios;
	Register register;

	public Logica(PApplet app) {

		estado = 9;
		segundos = 59;
		minutos = 2;

		muro1 = app.loadImage("Muro1.png");
		muro2 = app.loadImage("Muro2.png");
		muro3 = app.loadImage("Muro3.png");
		muro4 = app.loadImage("Muro4.png");
		muro5 = app.loadImage("Muro5.png");

		persona = app.loadImage("Personaje.png");

		pantalla = new PImage[9];
		pantalla[0] = app.loadImage("pantallainicio.jpg");
		pantalla[1] = app.loadImage("iniciarSesion.jpeg");
		pantalla[2] = app.loadImage("PantallaRegistro.jpg");
		pantalla[3] = app.loadImage("Instrucciones1.jpg");
		pantalla[4] = app.loadImage("Instrucciones2.jpg");
		pantalla[5] = app.loadImage("PantallaPerdio.jpg");
		pantalla[6] = app.loadImage("PantallaGano.jpg");
		pantalla[7] = app.loadImage("PantallaResumen.jpg");
		pantalla[8] = app.loadImage("PantallaPartidas.jpg");

		nivel = app.loadImage("Nivel1.jpg");

		enemigo = app.loadImage("Enemigo1.png");

		adornoMatriz = new PImage[5];
		adornoMatriz[0] = app.loadImage("Arbol.png");
		adornoMatriz[1] = app.loadImage("Pala.png");
		adornoMatriz[2] = app.loadImage("Matas.png");
		adornoMatriz[3] = app.loadImage("Tronco.png");
		adornoMatriz[4] = app.loadImage("Lago.png");

		botones = new PImage[8];
		botones[0] = app.loadImage("Boton1.png");
		botones[1] = app.loadImage("BotonOprimido1.png");
		botones[2] = app.loadImage("Boton2.png");
		botones[3] = app.loadImage("BotonOprimido2.png");
		botones[4] = app.loadImage("BotonPerdio.png");
		botones[5] = app.loadImage("BotonPerdioOprimido.png");
		botones[6] = app.loadImage("BotonGano.png");
		botones[7] = app.loadImage("BotonGanoOprimido.png");

		vida = app.loadImage("Vida.png");

		vitamina = app.loadImage("Herramienta1.png");

		mapa = new Mapa(muro1, muro2, muro3, muro4, muro5, app);
		personaje = new Personaje(1, 1, mapa);

		enemigos = new ArrayList<>();
		enemigos.add(new Enemigo(8, 1, mapa, 0));
		enemigos.add(new Enemigo(10, 5, mapa, 1));
		enemigos.add(new Enemigo(4, 10, mapa, 0));
		enemigos.add(new Enemigo(1, 15, mapa, 1));
		enemigos.add(new Enemigo(1, 20, mapa, 0));
		enemigos.add(new Enemigo(2, 22, mapa, 0));

		herramienta = new Herramienta(0, 0);
		listaHerramienta = new ArrayList<Herramienta>();
		listaHerramienta.add(new Herramienta(8, 8));
		listaHerramienta.add(new Herramienta(1, 17));
		listaHerramienta.add(new Herramienta(10, 22));
		
		usuarios = new LinkedList<Usuario>();
		usuarios.add(new Usuario("master", "12345", "12345", "usuarioMaestro", null));
		
		login = new Login(app);
		register = new Register(app);
	}

	public void pintarPantalla(final PApplet app) {

		switch (estado) {

		// Pantalla inicio
		case 0:
			app.image(pantalla[0], 0, 0);
			
			break;

		// Pantalla Login
		case 1:
			app.image(pantalla[1], 0, 0);
			
			break;

		// Pantalla Registro
		case 2:
			app.image(pantalla[2], 0, 0);
			break;

		// Pantalla Instrucciones 1
		case 3:
			// Imagen Fondo
			app.image(pantalla[3], 0, 0);

			// Imagen Boton
			app.image(botones[0], 498, 520);

			// Si esta el mouse encima del Boton mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 498 && app.mouseX < 498 + 208 && app.mouseY > 520 && app.mouseY < 520 + 80) {
				app.image(botones[1], 498, 520);
			}
			break;

		// Pantalla Instrucciones 2
		case 4:
			// Imagen Fondo
			app.image(pantalla[4], 0, 0);

			// Imagen Boton
			app.image(botones[2], 425, 520);

			// Si esta el mouse encima del Boton mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 425 && app.mouseX < 425 + 350 && app.mouseY > 520 && app.mouseY < 520 + 75) {
				app.image(botones[3], 425, 520);
			}
			break;

		// Pantalla nivel 1
		case 5:
			app.imageMode(PConstants.CORNER);
			app.image(nivel, 0, 0);

			mapa.pintar();
			personaje.pintar(app, persona);

			// int index, condicion, accion a srguir
			// tipo de referencia instancio => lista
			for (Enemigo enemigo : enemigos) {
				enemigo.pintar(app, this.enemigo);
				enemigos.indexOf(enemigo);
			}
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						if (app.frameCount % 60 == 0) {
							for (Enemigo enemigo : enemigos) {
								enemigo.tipoDireccion();
							}
						}
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();

			app.imageMode(PConstants.CORNER);
			pintarAdornos(app);

			temporizador(app);

			// For para pintar las vidas del personaje
			app.imageMode(PConstants.CENTER);
			for (int i = 0; i < personaje.getVidas(); i++) {
				app.image(vida, 993 + i * 30, 50);
			}

			// For para pintar la lista de herramientas, para validar el area sensible de
			// personaje y herramienta
			// Si se coincide con el area sensible de los dos, el personaje obtiene 1 vida y
			// la herramienta se elimina de la lista de herramientas
			for (int i = 0; i < listaHerramienta.size(); i++) {
				listaHerramienta.get(i).pintar(app, vitamina);
				Herramienta herramientaActual = listaHerramienta.get(i);
				if ((personaje.getX() - 25 >= herramientaActual.getX() - 25
						&& personaje.getX() - 25 <= herramientaActual.getX() - 25 + 50)
						|| (personaje.getX() - 25 + 50 >= herramientaActual.getX() - 25
								&& personaje.getX() - 25 + 50 <= herramientaActual.getX() - 9 + 50)) {
					if ((personaje.getY() - 25 >= herramientaActual.getY() - 25
							&& personaje.getY() - 25 <= herramientaActual.getY() + 50)
							|| (personaje.getY() - 25 + persona.height >= herramientaActual.getY() - 25
									&& personaje.getY() - 25 + persona.height <= herramientaActual.getY() - 25 + 50)) {
						personaje.darVida();
						listaHerramienta.remove(i);
					}
				}
			}
			break;

		// Pantalla Perdio
		case 6:
			// Imagen Fondo
			app.image(pantalla[5], 0, 0);

			// Imagen Boton
			app.image(botones[4], 500, 553);

			// Si esta el mouse encima del Boton mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 500 && app.mouseX < 500 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				app.image(botones[5], 500, 553);
			}
			break;

		// Pantalla Gano
		case 7:
			// Imagen Fondo
			app.image(pantalla[6], 0, 0);

			// Imagen Boton
			app.image(botones[6], 507, 479);

			// Si esta el mouse encima del Boton mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 507 && app.mouseX < 507 + 186 && app.mouseY > 479 && app.mouseY < 479 + 70) {
				app.image(botones[7], 507, 479); 
			}

			break;

		// Pantalla Resumen
		case 8:
			// Imagen Fondo
			app.image(pantalla[7], 0, 0);

			// Imagen Boton
			app.image(botones[6], 504, 503);

			// Si esta el mouse encima del Boton mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 504 && app.mouseX < 504 + 231 && app.mouseY > 503 && app.mouseY < 503 + 52) {
				app.image(botones[7], 504, 503);
			}

			break;
		case 9:
			app.image(pantalla[8], 0, 0);
			try {
				for (Usuario usuario : usuarios) {
					app.text(usuario.getNombre(), 50, 100);
					app.text(usuario.getP().getTime(), 100, 100);
					app.text(usuario.getP().getPuntaje(), 150, 100);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("No hay resultados");
				app.text("No hay resultados", app.width/2, 300);
			}
			
			break;
		}
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	// Objetos decorativos que van encima de la matriz
	public void pintarAdornos(PApplet app) {
		app.image(adornoMatriz[0], 89, 309);
		app.image(adornoMatriz[0], 140, 415);
		app.image(adornoMatriz[0], 307, 380);
		app.image(adornoMatriz[0], 405, 164);
		app.image(adornoMatriz[0], 392, 256);
		app.image(adornoMatriz[0], 545, 306);
		app.image(adornoMatriz[0], 638, 407);
		app.image(adornoMatriz[0], 784, 314);

		app.image(adornoMatriz[4], 875, 400);

		app.image(adornoMatriz[3], 820, 231);
		app.image(adornoMatriz[3], 880, 231);
		app.image(adornoMatriz[3], 845, 260);

		app.image(adornoMatriz[2], 567, 200);
		app.image(adornoMatriz[2], 515, 265);
		app.image(adornoMatriz[2], 600, 265);
		app.image(adornoMatriz[2], 843, 465);
		app.image(adornoMatriz[2], 919, 465);

		app.image(adornoMatriz[1], 297, 206);
	}

	public void temporizador(PApplet app) {
		if (app.frameCount % 60 == 0 && minutos >= 0) {
			segundos--;
		}
		if (segundos == 0) {
			minutos--;
			segundos = 59;
		}
		if (minutos < 0) {
			app.fill(255);
			app.textSize(23);
			app.text("0:00", 141, 60);
		} else if (segundos <= 9) {
			app.fill(255);
			app.textSize(23);
			app.text(minutos + ":0" + segundos, 141, 60);
		} else if (segundos > 9) {
			app.fill(255);
			app.textSize(23);
			app.text(minutos + ":" + segundos, 141, 60);
		}
	}

	
	public void clic(PApplet app) {
		switch (estado) {
		case 1:
			if(login.getB1().isMouseOver(app.mouseX, app.mouseY)) {
				try {
					validarUsuario(login.getInput().getValue(), login.getPassword().getValue());
					if(validarUsuario(login.getInput().getValue(), login.getPassword().getValue())) {
						estado = 3;
						login.stopVisualization();
					}
				} catch (UsuarioNoExisteException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					
				}
			}			
			
			
			break;
		case 2: 
			if(register.getB1().isMouseOver(app.mouseX, app.mouseY)) {
				try {
					validarContraseñas(register.getPassword().getValue(), register.getCpassword().getValue());
					if(validarContraseñas(register.getPassword().getValue(), register.getCpassword().getValue())) {
						
						if(validarCamposLlenos(register.getName().getValue(), register.getInput().getValue(),
								register.getPassword().getValue(), register.getCpassword().getValue())) {
							
							estado = 3;
							register.stopVisualization();
						}
						
					}
				} catch (NoSamePasswordException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (NoTextInsideException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					
				
			}
			break;
		case 3:
			// Pantalla Instrucciones 1
			// Cuando se le de clic en el boton pasar a la otra pantalla de
			// instrucciones
			if (app.mouseX > 498 && app.mouseX < 498 + 208 && app.mouseY > 520 && app.mouseY < 520 + 80) {
				estado = 4;
			}
			break;
		case 4:
			// Pantalla Instrucciones 2
			// Cuando se le de clic en el boton Inicio pasar a la pantalla del escenario
			if (app.mouseX > 425 && app.mouseX < 425 + 350 && app.mouseY > 520 && app.mouseY < 520 + 75) {
				estado = 5;
			}
			break;
		case 6:
			// Pantalla Perdio
			// Cuando se le de clic en el boton Ok pasar a la pantalla del Resumen
			if (app.mouseX > 500 && app.mouseX < 500 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				estado = 8;
			}
			break;
		case 7:
			// Pantalla Gano
			// Cuando se le de clic en el boton Ok pasar a la pantalla del Resumen
			if (app.mouseX > 507 && app.mouseX < 507 + 186 && app.mouseY > 479 && app.mouseY < 479 + 70) {
				estado = 8;
			}
			break;
		case 8:
			// Pantalla Resumen
			// Cuando se le de clic en el boton Ok pasar a la pantalla de las instrucciones 1
			if (app.mouseX > 504 && app.mouseX < 504 + 231 && app.mouseY > 503 && app.mouseY < 503 + 52) {
				estado = 3;
			}
			break;
		}
	}
	
	public boolean validarUsuario(String user,String password) throws UsuarioNoExisteException {
		for (Usuario usuario : usuarios) {
			if(user.equals(usuario.getUsuario()) && password.equals(usuario.getContraseña())) {
				return true;
			} else {
				throw new UsuarioNoExisteException();
			}
		}
		return false;
		
	}
	
	public boolean validarContraseñas(String c1, String c2) throws NoSamePasswordException{
		boolean estado = false;
		//c1.equals(c2)? true : throw new NoSamePasswordException();
		
		if(c1.equals(c2)) {
			estado = true;
		} else {
			estado = false;
			throw new NoSamePasswordException();
			
		}
		
		return estado;
	}
	
	public void añadirUsuarios(String usuario,String contraseña, String confirmarContraseña,String nombre) {
		usuarios.add(new Usuario(usuario, contraseña, confirmarContraseña, nombre, null));
	}
	
	public boolean validarCamposLlenos(String name,String user,String password,String cpassword) throws NoTextInsideException {
		String faltante;
		faltante = name.equals("")? "name" : "";
		faltante = user.equals("")? "user" : "";
		faltante = password.equals("")? "password" : "";
		faltante = cpassword.equals("")? "cpassword" : "";
		
		boolean estado = false;
		
		if(!name.equals("") && !user.equals("") && !password.equals("") && !cpassword.equals("")) {
			System.out.println("entra 1");
			estado = true;
		} else {
			estado = false;
			throw new NoTextInsideException(faltante);
		}
		
		return estado;
	}
}
