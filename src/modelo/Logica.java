package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import exception.NoSamePasswordException;
import exception.NoTextInsideException;
import exception.UsuarioNoExisteException;
import ordenamiento.OrdenarPorPuntaje;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import modelo.Login;

public class Logica {

	Mapa mapa;
	Personaje personaje;
	Enemigo enemi;
	Herramienta herramienta;
	Cafe cafe;
	Login login;


	private int estado, segundos, minutos, puntaje;

	PImage[] pantalla;
	PImage[] adornoMatriz;

	PImage[] botones;

	PImage muro1;
	PImage muro2;
	PImage muro3;
	PImage muro4;
	PImage muro5;

	PImage nivel;
	PImage enemigoI;
	PImage persona;
	PImage vida;
	PImage cafeG;

	PImage vitamina;

	ArrayList<Herramienta> listaHerramienta;
	ArrayList<Cafe> listaCafes = new ArrayList<Cafe>();
	ArrayList<Enemigo> enemigos;

	LinkedList<Usuario> usuarios;
	Register register;
	OrdenarPorPuntaje ordenarPuntaje;
	private Button btnIniciarSesion;
	private Button btnRegistro;

	public Logica(PApplet app) {
		
		estado = 5;
		segundos = 0;
		minutos = 0;
		puntaje = 0;
		


		muro1 = app.loadImage("Muro1.png");
		muro2 = app.loadImage("Muro2.png");
		muro3 = app.loadImage("Muro3.png");
		muro4 = app.loadImage("Muro4.png");
		muro5 = app.loadImage("Muro5.png");

		persona = app.loadImage("Personaje.png");
		nivel = app.loadImage("Nivel1.jpg");
		enemigoI = app.loadImage("Enemigo1.png");
		vida = app.loadImage("Vida.png");
		cafeG = app.loadImage("Cafe.png");
		vitamina = app.loadImage("Herramienta1.png");
		
		mapa = new Mapa(muro1, muro2, muro3, muro4, muro5, app);

		pantalla = new PImage[9];
		pantalla[0] = app.loadImage("PantallaInicio.jpg");
		pantalla[1] = app.loadImage("PantallaLogin.jpg");
		pantalla[2] = app.loadImage("PantallaRegistro.jpg");
		pantalla[3] = app.loadImage("Instrucciones1.jpg");
		pantalla[4] = app.loadImage("Instrucciones2.jpg");
		pantalla[5] = app.loadImage("PantallaPerdio.jpg");
		pantalla[6] = app.loadImage("PantallaGano.jpg");
		pantalla[7] = app.loadImage("PantallaResumen.jpg");
		pantalla[8] = app.loadImage("PantallaPartidas.jpg");

		adornoMatriz = new PImage[5];
		adornoMatriz[0] = app.loadImage("Arbol.png");
		adornoMatriz[1] = app.loadImage("Pala.png");
		adornoMatriz[2] = app.loadImage("Matas.png");
		adornoMatriz[3] = app.loadImage("Tronco.png");
		adornoMatriz[4] = app.loadImage("Lago.png");

		botones = new PImage[15];
		botones[0] = app.loadImage("Boton1.png");
		botones[1] = app.loadImage("BotonOprimido1.png");
		botones[2] = app.loadImage("Boton2.png");
		botones[3] = app.loadImage("BotonOprimido2.png");
		botones[4] = app.loadImage("BotonPerdio.png");
		botones[5] = app.loadImage("BotonPerdioOprimido.png");
		botones[6] = app.loadImage("BotonGano.png");
		botones[7] = app.loadImage("BotonGanoOprimido.png");
		botones[8] = app.loadImage("BotonJugar.png");
		botones[9] = app.loadImage("BotonJugarOprimido.png");
		botones[10] = app.loadImage("BotonRegistrarse.png");
		botones[11] = app.loadImage("BotonIngresar.png");
		botones[12] = app.loadImage("BotonRegistrate.png");
		botones[13] = app.loadImage("BotonSalir.png");
		botones[14] = app.loadImage("BotonSalirOprimido.png");

		listaCafes = new ArrayList<>();
		listaCafes.add(new Cafe(2, 1));
		listaCafes.add(new Cafe(4, 1));
		listaCafes.add(new Cafe(6, 1));
		listaCafes.add(new Cafe(8, 1));
		listaCafes.add(new Cafe(10, 1));
		listaCafes.add(new Cafe(4, 3));
		listaCafes.add(new Cafe(2, 3));
		listaCafes.add(new Cafe(1, 4));
		listaCafes.add(new Cafe(1, 6));
		listaCafes.add(new Cafe(2, 7));
		listaCafes.add(new Cafe(4, 7));
		listaCafes.add(new Cafe(4, 5));
		listaCafes.add(new Cafe(6, 5));
		listaCafes.add(new Cafe(8, 5));
		listaCafes.add(new Cafe(10, 5));
		listaCafes.add(new Cafe(10, 3));
		listaCafes.add(new Cafe(10, 7));
		listaCafes.add(new Cafe(10, 9));
		listaCafes.add(new Cafe(9, 10));
		listaCafes.add(new Cafe(7, 10));
		listaCafes.add(new Cafe(5, 10));
		listaCafes.add(new Cafe(4, 11));
		listaCafes.add(new Cafe(4, 13));
		listaCafes.add(new Cafe(4, 15));
		listaCafes.add(new Cafe(4, 17));
		listaCafes.add(new Cafe(4, 19));
		listaCafes.add(new Cafe(4, 22));
		listaCafes.add(new Cafe(2, 15));
		listaCafes.add(new Cafe(1, 19));
		listaCafes.add(new Cafe(2, 20));
		listaCafes.add(new Cafe(2, 22));
		listaCafes.add(new Cafe(6, 22));
		listaCafes.add(new Cafe(8, 22));
		listaCafes.add(new Cafe(10, 20));
		listaCafes.add(new Cafe(10, 18));
		listaCafes.add(new Cafe(9, 17));
		listaCafes.add(new Cafe(8, 18));
		listaCafes.add(new Cafe(8, 20));
		listaCafes.add(new Cafe(6, 20));
		listaCafes.add(new Cafe(5, 21));
		listaCafes.add(new Cafe(9, 15));
		listaCafes.add(new Cafe(9, 13));
		listaCafes.add(new Cafe(7, 15));
		listaCafes.add(new Cafe(5, 14));
		
		enemigos = new ArrayList<>();
		enemigos.add(new Enemigo(8, 1, mapa, 0));
		enemigos.add(new Enemigo(10, 5, mapa, 1));
		enemigos.add(new Enemigo(1, 15, mapa, 1));
		enemigos.add(new Enemigo(1, 20, mapa, 0));
		enemigos.add(new Enemigo(2, 22, mapa, 0));

		herramienta = new Herramienta(0, 0);
		listaHerramienta = new ArrayList<Herramienta>();
		listaHerramienta.add(new Herramienta(8, 8));
		listaHerramienta.add(new Herramienta(1, 17));
		listaHerramienta.add(new Herramienta(10, 22));

		personaje = new Personaje(1, 1, mapa);

		usuarios = new LinkedList<Usuario>();
		usuarios.add(new Usuario("master", "12345", "12345", "usuarioMaestro", new Partida("3:50", "50")));

		login = new Login(app, botones[11]);
		register = new Register(app, botones[10]);
		btnIniciarSesion = new Button(app, app.width / 2 - 150, 600, 200, 75, 0, "Iniciar Sesi�n");
		btnRegistro = new Button(app, app.width / 2 + 150, 600, 200, 75, 0, "Registro");

		ordenarPuntaje = new OrdenarPorPuntaje();
	}

	public void pintarPantalla(final PApplet app) {
		switch (estado) {

		// Pantalla inicio
		case 0:
			app.imageMode(PConstants.CORNER);
			// Imagen Fondo
			app.image(pantalla[0], 0, 0);

			// Se pinta tanto el boton para iniciar sesion como para el registro
			btnIniciarSesion.pintar();
			btnRegistro.pintar();

			break;

		// Pantalla Login
		case 1:
			app.imageMode(PConstants.CORNER);
			// Imagen Fondo
			app.image(pantalla[1], 0, 0);

			// Boton Ingresar
			login.pintar();
			break;

		// Pantalla Registro
		case 2:
			app.imageMode(PConstants.CORNER);
			// Imagen Fondo
			app.image(pantalla[1], 0, 0);

			// Boton Registrarse
			register.pintar();
			break;

		// Pantalla Instrucciones 1
		case 3:
			app.imageMode(PConstants.CORNER);
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
			app.imageMode(PConstants.CORNER);
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

		// Pantalla Escenario: Juego
		case 5:
			app.imageMode(PConstants.CORNER);
			// Imagen Fondo
			app.image(nivel, 0, 0);

			mapa.pintar();
			personaje.pintar(app, persona);

			// For para pintar los enemigos
			for (Enemigo enemigo : enemigos) {
				enemigo.pintar(app, this.enemigoI);
				enemigos.indexOf(enemigo);
			}

			// Hilo para la direccion en la que se mueven los enemigos, es decir,
			// Que cambien de direccion cuando lleguen o chocan con un muro
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
			
			app.textAlign(PConstants.BASELINE);
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
								&& personaje.getX() - 25 + 50 <= herramientaActual.getX() - 25 + 50)) {
					if ((personaje.getY() - 25 >= herramientaActual.getY() - 25
							&& personaje.getY() - 25 <= herramientaActual.getY() + 50)
							|| (personaje.getY() - 25 + persona.height >= herramientaActual.getY() - 25
									&& personaje.getY() - 25 + persona.height <= herramientaActual.getY() - 25 + 50)) {
						personaje.darVida();
						listaHerramienta.remove(i);
					}
				}
			}

			// For para pintar los cafes y validar la posicion del personaje y el cafe
			// Si coinciden se suma al puntaje y se elimina de la lista el cafe
			for (int i = 0; i < listaCafes.size(); i++) {
				listaCafes.get(i).pintar(app, cafeG);
				Cafe cafeActual = listaCafes.get(i);
				if ((personaje.getX() - 25 >= cafeActual.getX() - 20
						&& personaje.getX() - 25 <= cafeActual.getX() - 20 + 50)
						|| (personaje.getX() - 25 + 50 >= cafeActual.getX() - 20
								&& personaje.getX() - 25 + 50 <= cafeActual.getX() - 20 + 50)) {
					if ((personaje.getY() - 25 >= cafeActual.getY() - 25
							&& personaje.getY() - 25 <= cafeActual.getY() + 50)
							|| (personaje.getY() - 25 + persona.height >= cafeActual.getY() - 25
									&& personaje.getY() - 25 + persona.height <= cafeActual.getY() - 25 + 50)) {
						puntaje += 10;
						listaCafes.remove(i);
						if (listaCafes.size() == 0) {
							estado = 7;
						}
					}
				}
			}

			// Texto del puntaje
			app.fill(0);
			app.textSize(20);
			app.text(puntaje + " x", 840, 57);

			// For para perder vida cuando los enemigos toquen al personaje principal
			for (final Enemigo e : enemigos) {
				if ((e.getX() >= personaje.getX() && e.getX() <= personaje.getX() + persona.width)
						&& (e.getY() >= personaje.getY() && e.getY() <= personaje.getY() + persona.height)) {

					new Thread(new Runnable() {
						@Override
						public void run() {
							System.out.println(personaje.vidas + " " + e.getDa�oEne());
							try {
								if (app.frameCount % 90 == 0) {
									personaje.quitarVida(e.getDa�oEne());
								}
								Thread.sleep(1500);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
					}).start();
				}
			}

			// Perder el juego
			if (personaje.getVidas() <= 0) {
				estado = 6;
			}

			// visualizacionForm();

			break;

		// Pantalla Perdio
		case 6:
			// Imagen Fondo
			app.imageMode(PConstants.CORNER);
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
			app.imageMode(PConstants.CORNER);
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

			// Pintar el texto de cuanto tiempo se demoro en la partida jugada
			if (segundos <= 9) {
				app.text(minutos + ":0" + segundos, 690, 315);
			} else if (segundos > 9) {
				app.text(minutos + ":" + segundos, 690, 315);
			}

			// Pintar el texto de cuanto puntaje saco en la partida jugada
			app.text(puntaje, 515, 315);

			// Imagen Boton Ok
			app.image(botones[4], 504, 503);

			// Imagen Boton Jugar
			app.image(botones[8], 748, 503);

			// Si esta el mouse encima del Boton Ok mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 504 && app.mouseX < 504 + 231 && app.mouseY > 503 && app.mouseY < 503 + 52) {
				app.image(botones[5], 504, 503);
			}
			// Si esta el mouse encima del Boton Jugar mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 748 && app.mouseX < 748 + 231 && app.mouseY > 503 && app.mouseY < 503 + 52) {
				app.image(botones[9], 748, 503);
			}

			break;
		// Pantalla Partidas
		case 9:
			// Imagen Fondo
			app.image(pantalla[8], 0, 0);

			// Imagen Boton Salir
			app.image(botones[13], 500, 553);
			// Imagen Boton Jugar
			app.image(botones[8], 764, 553);

			// Si esta el mouse encima del Boton Salir mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 500 && app.mouseX < 500 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				app.image(botones[14], 500, 553);
			}
			
			// Si esta el mouse encima del Boton Jugar mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 764 && app.mouseX < 764 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				app.image(botones[9], 764, 553);
			}

			// Esto es una excepcion, si ya se hay alguna partida con el usuario pintar los
			// textos de Nombre, tiempo y puntaje, si no, arrojar la excepcion de que aun 
			//no hay resultados
			try {
				for (Usuario usuario : usuarios) {
					app.text(usuario.getNombre(), 587, 300 + (50 * usuarios.indexOf(usuario)));
					app.text("--------------------------    " + usuario.getP().getTime(), 745,
							300 + (50 * usuarios.indexOf(usuario)));
					app.text(usuario.getP().getPuntaje(), 975, 300 + (50 * usuarios.indexOf(usuario)));
				}
			} catch (Exception e) {

				app.text("No hay resultados", app.width / 2, 300);
			}
			break;
		}
	}

	public void clic(PApplet app) {
		// Cambio de pantallas por medio del clic
		switch (estado) {
		case 0:
			// Pantalla Inicio
			// Cuando se de clic en el boton Iniciar sesion pasar a la pantalla de Login
			if (btnIniciarSesion.isHover()) {
				estado = 1;
				System.out.println(estado);
				
			}
			// Cuando se de clic en el boton Registro pasar a la pantalla de Registro
			if (btnRegistro.isHover()) {
				estado = 2;
			}
			break;

		case 1:
			// Pantalla Login
			// Cuando se de clic al boton Ingresar validar si ese usuario ya esta registrado
			// Si el usuario ya esta registrado pasar a la pantalla de instrucciones y parar
			// la visualizacion del formulario
			if (login.getB1().isHover()) {
				try {
					validarUsuario(login.getInput().getValue(), login.getPassword().getValue());
					if (validarUsuario(login.getInput().getValue(), login.getPassword().getValue())) {
						estado = 3;
					}
					// Si el usuario aun no ha sido registrado mostrar un error o excepcion que diga
					// que el usuario aun no exite
				} catch (UsuarioNoExisteException e) {
					System.out.println(e.getMessage());
				}
			}
			break;

		case 2:
			// Pantalla Registro
			// Cuando se de clic al boton Registrarse validar si:

			// La contrase�a digitada es la correcta, es decir confirmar en el otro campo
			// del
			// formulario, si la contrase�a digitada anteriormente coincide con la
			// confirmada

			// Registrar la informacion digitada dentro de los campos del formulario
			if (register.getB1().isHover()) {
				try {
					validarContrase�as(register.getPassword().getValue(), register.getCpassword().getValue());
					if (validarContrase�as(register.getPassword().getValue(), register.getCpassword().getValue())) {
						if (validarCamposLlenos(register.getName().getValue(), register.getInput().getValue(),
								register.getPassword().getValue(), register.getCpassword().getValue())) {
							a�adirUsuarios(register.getInput().getValue(), register.getPassword().getValue(),
									register.getPassword().getValue(), register.getName().getValue());
							estado = 3;
						}

					}
				} catch (NoSamePasswordException e) {
					System.out.println(e.getMessage());
				} catch (NoTextInsideException e) {
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
			// Cuando se le de clic en el boton Ok pasar a la pantalla de partidas
			// 1
			if (app.mouseX > 504 && app.mouseX < 504 + 231 && app.mouseY > 503 && app.mouseY < 503 + 52) {
				usuarios.get(usuarios.size() - 1).setP(new Partida(minutos + ":" + segundos, puntaje + ""));
				estado = 9;
			}
			// Cuando se le de clic en el boton Jugar pasar a la pantalla de escenario y
			// reiniciar el juego
			if (app.mouseX > 748 && app.mouseX < 748 + 231 && app.mouseY > 503 && app.mouseY < 503 + 52) {
				reiniciar(app);
				estado = 5;
			}
			break;

		case 9:
			// Pantalla Partidas
			// Si esta el mouse encima del Boton Salir pasar a la pantalla inicio y
			// reiniciar el juego
			if (app.mouseX > 500 && app.mouseX < 500 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				reiniciar(app);
				estado = 0;
			}
			
			// Si esta el mouse encima del Boton Jugar pasar a la pantalla escenario y
			//reiniciar el juego
			if (app.mouseX > 764 && app.mouseX < 764 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				reiniciar(app);
				estado = 5;
			}
		}
	}

	// Esto es una excepcion, para validar al usuario, si el usuario ya fue
	// registrado esto arroja un true y deja al usuario iniciar sesion
	// Y si no le tira la excepcion, de que aun el usuario no existe
	public boolean validarUsuario(String user, String password) throws UsuarioNoExisteException {
		Usuario usuarioTemp = new Usuario(null, "", "", "", null);
		for (Usuario usuario : usuarios) {
			if (user.equals(usuario.getUsuario()) && password.equals(usuario.getContrase�a())) {
				usuarioTemp = usuario;
			}
		}
		System.out.println(usuarioTemp.getUsuario());
		if (usuarioTemp.getUsuario() != null) {
			return true;
		} else {
			throw new UsuarioNoExisteException();
		}
	}

	// Esto es una excepcion, para validar las contrase�as, si la contrase�a
	// digitada anteriormente coincide con la constrase�a confirmada 
	// entonces es true, y si no que le arroje la excepcion de que
	// Las contrase�as no coinciden
	public boolean validarContrase�as(String c1, String c2) throws NoSamePasswordException {
		boolean estado = false;

		if (c1.equals(c2)) {
			estado = true;
		} else {
			estado = false;
			throw new NoSamePasswordException();
		}
		return estado;
	}

	// Para a�adir los usuarios del registro
	public void a�adirUsuarios(String usuario, String contrase�a, String confirmarContrase�a, String nombre) {
		usuarios.add(new Usuario(usuario, contrase�a, confirmarContrase�a, nombre, null));
	}

	// Esto es una excepcion, para validar que todos los campos esten completados
	// si no estan todos los campos llenos se arroja la excepcion de que
	// Llene los campos del formulario
	public boolean validarCamposLlenos(String name, String user, String password, String cpassword)
			throws NoTextInsideException {
		String faltante;
		// Es un ternario, es como un if else resumido
		faltante = name.equals("") ? "name" : "";
		faltante = user.equals("") ? "user" : "";
		faltante = password.equals("") ? "password" : "";
		faltante = cpassword.equals("") ? "cpassword" : "";

		boolean estado = false;

		if (!name.equals("") && !user.equals("") && !password.equals("") && !cpassword.equals("")) {

			estado = true;
		} else {
			estado = false;
			throw new NoTextInsideException(faltante);
		}

		return estado;
	}

	public void visualizacionForm() {
		// Estos if son para evitar que el formulario aparezca en otras pantallas
		// Si se esta en la pantalla de login, y el isOnScreen es falso, es decir, si se
		// ve el formulario, que se vea el formulario

			if (estado == 1) {
				if (!login.isOnScreen()) {
					login.continueVisualization();
				}

				// Y si no se esta en esta pantalla que pare la visualizacion del formulario
			} else {
				login.stopVisualization();
			}

		

		// Si se esta en la pantalla de registro, y el isOnScreen es falso, es decir, si
		// se ve el formulario, que se vea el formulario
			if (estado == 2) {
				if (!register.isOnScreen()) {
					register.continueVisualization();
				}
				// Y si no se esta en esta pantalla que pare la visualizacion del formulario
			} else {
				register.stopVisualization();
			}

		
	}

	public void ordenarPuntajes(char key) {
		switch (key) {
		case 'z':
			Collections.sort(usuarios);
			break;
		case 'x':
			Collections.sort(usuarios, ordenarPuntaje);
			break;
		}
	}

	// Para poder llamar en el control el movimiento del personaje
	public Personaje getPersonaje() {
		return personaje;
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
			segundos++;
		}
		if (segundos == 60) {
			minutos++;
			segundos = 0;
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
		// Si el tiempo llega a un minuto el jugador pierde la partida
		if (minutos == 1) {
			estado = 6;
		}
	}

	public void reiniciar(PApplet app) {
		// Vuelvo todas las variables que inicialice en el constructor
		// a su estado original
		estado = 0;
		segundos = 0;
		minutos = 0;
		puntaje = 0;

		mapa = new Mapa(muro1, muro2, muro3, muro4, muro5, app);
		personaje = new Personaje(1, 1, mapa);

		listaCafes = new ArrayList<>();
		listaCafes.add(new Cafe(2, 1));
		listaCafes.add(new Cafe(4, 1));
		listaCafes.add(new Cafe(6, 1));
		listaCafes.add(new Cafe(8, 1));
		listaCafes.add(new Cafe(10, 1));
		listaCafes.add(new Cafe(4, 3));
		listaCafes.add(new Cafe(2, 3));
		listaCafes.add(new Cafe(1, 4));
		listaCafes.add(new Cafe(1, 6));
		listaCafes.add(new Cafe(2, 7));
		listaCafes.add(new Cafe(4, 7));
		listaCafes.add(new Cafe(4, 5));
		listaCafes.add(new Cafe(6, 5));
		listaCafes.add(new Cafe(8, 5));
		listaCafes.add(new Cafe(10, 5));
		listaCafes.add(new Cafe(10, 3));
		listaCafes.add(new Cafe(10, 7));
		listaCafes.add(new Cafe(10, 9));
		listaCafes.add(new Cafe(9, 10));
		listaCafes.add(new Cafe(7, 10));
		listaCafes.add(new Cafe(5, 10));
		listaCafes.add(new Cafe(4, 11));
		listaCafes.add(new Cafe(4, 13));
		listaCafes.add(new Cafe(4, 15));
		listaCafes.add(new Cafe(4, 17));
		listaCafes.add(new Cafe(4, 19));
		listaCafes.add(new Cafe(4, 22));
		listaCafes.add(new Cafe(2, 15));
		listaCafes.add(new Cafe(1, 19));
		listaCafes.add(new Cafe(2, 20));
		listaCafes.add(new Cafe(2, 22));
		listaCafes.add(new Cafe(6, 22));
		listaCafes.add(new Cafe(8, 22));
		listaCafes.add(new Cafe(10, 20));
		listaCafes.add(new Cafe(10, 18));
		listaCafes.add(new Cafe(9, 17));
		listaCafes.add(new Cafe(8, 18));
		listaCafes.add(new Cafe(8, 20));
		listaCafes.add(new Cafe(6, 20));
		listaCafes.add(new Cafe(5, 21));
		listaCafes.add(new Cafe(9, 15));
		listaCafes.add(new Cafe(9, 13));
		listaCafes.add(new Cafe(7, 15));
		listaCafes.add(new Cafe(5, 14));
		
		enemigos = new ArrayList<>();
		enemigos.add(new Enemigo(8, 1, mapa, 0));
		enemigos.add(new Enemigo(10, 5, mapa, 1));
		enemigos.add(new Enemigo(1, 15, mapa, 1));
		enemigos.add(new Enemigo(1, 20, mapa, 0));
		enemigos.add(new Enemigo(2, 22, mapa, 0));

		herramienta = new Herramienta(0, 0);
		listaHerramienta = new ArrayList<Herramienta>();
		listaHerramienta.add(new Herramienta(8, 8));
		listaHerramienta.add(new Herramienta(1, 17));
		listaHerramienta.add(new Herramienta(10, 22));

		personaje.vidas = 1;
	}
}
