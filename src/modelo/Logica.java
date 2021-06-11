package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import exception.NoMoreCoffee;
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

	private int estado, segundos, minutos, puntaje, inicio;
	private boolean win;

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

		estado = 0;
		segundos = 0;
		minutos = 0;
		puntaje = 0;

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

		enemigoI = app.loadImage("Enemigo1.png");

		adornoMatriz = new PImage[5];
		adornoMatriz[0] = app.loadImage("Arbol.png");
		adornoMatriz[1] = app.loadImage("Pala.png");
		adornoMatriz[2] = app.loadImage("Matas.png");
		adornoMatriz[3] = app.loadImage("Tronco.png");
		adornoMatriz[4] = app.loadImage("Lago.png");

		botones = new PImage[13];
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
		botones[10] = app.loadImage("BotonStart.png");
		botones[11] = app.loadImage("BotonStartOprimido.png");
		botones[12] = app.loadImage("BotonRegistrate.png");

		vida = app.loadImage("Vida.png");
		cafeG = app.loadImage("Cafe.png");

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

		int randomX = (int) app.random(0, 22);
		int randomY = (int) app.random(0, 10);
		listaCafes = new ArrayList<>();
		listaCafes.add(new Cafe(randomX, randomY));
		listaCafes.add(new Cafe(5, 1));

		usuarios = new LinkedList<Usuario>();
		usuarios.add(new Usuario("master", "12345", "12345", "usuarioMaestro", new Partida("3:50", "50")));

		login = new Login(app, botones[12]);
		register = new Register(app,botones[12]);

		ordenarPuntaje = new OrdenarPorPuntaje();
		btnIniciarSesion = new Button(app, app.width/2-150, 600, 200, 75, 0, "Iniciar Sesión");
		btnRegistro = new Button(app, app.width/2+150, 600, 200, 75, 0, "Registro");
	}

	public void pintarPantalla(final PApplet app) throws NoMoreCoffee {

		switch (estado) {

		// Pantalla inicio
		case 0:
			app.imageMode(PConstants.CORNER);
			// Imagen Fondo
			app.image(pantalla[0], 0, 0);

			// Imagen Boton Start
			
			// aqui se agregaron los botones para ir a registro o pantalla
			btnIniciarSesion.pintar();
			btnRegistro.pintar();

			break;

		// Pantalla Login
		case 1:
			app.imageMode(PConstants.CORNER);
			//Imagen Fondo
			app.image(pantalla[1], 0, 0);
			
			

			//btn pasar
			login.pintar();
			break;

		// Pantalla Registro
		case 2:
			app.imageMode(PConstants.CORNER);
			app.image(pantalla[2], 0, 0);
			
			//btn pasar
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

		// Pantalla nivel 1
		case 5:
			app.imageMode(PConstants.CORNER);
			app.image(nivel, 0, 0);

			mapa.pintar();
			personaje.pintar(app, persona);

			// Cuando se recojan todos los cafes se indica que el jugador gano la partida
			// Es decir la lista de Cafes este en 0
			if (listaCafes.size() == 0) {
				estado = 7;
			}

			// int index, condicion, accion a srguir
			// tipo de referencia instancio => lista
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
							throw new NoMoreCoffee();
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
							System.out.println(personaje.vidas + " " + e.getDañoEne());
							try {
								if (app.frameCount % 90 == 0) {
									personaje.quitarVida(e.getDañoEne());
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

			if (segundos <= 9) {
				app.text(minutos + ":0" + segundos, 690, 315);
			} else if (segundos > 9) {
				app.text(minutos + ":" + segundos, 690, 315);
			}

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

			// Imagen Boton Ok
			app.image(botones[4], 500, 553);

			// Si esta el mouse encima del Boton Ok mostrar imagen Boton Oprimido
			// Esto es mas que todo estetica
			if (app.mouseX > 500 && app.mouseX < 500 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				app.image(botones[5], 500, 553);
			}
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
		
		//aqui se evita q el form aparezca donde quiera
		if(estado==1) {
			if(!login.isOnScreen()) {
				login.continueVisualization();
			}
			
		} else {
			login.stopVisualization();
		}
		
		if(estado==2) {
			if(!register.isOnScreen()) {
				register.continueVisualization();
			}
			
		} else {
			register.stopVisualization();
		}
		
		//switch de estado
		switch (estado) {
		case 0:
			//Pantalla Inicio
		
			//aqui se le ayude lo que hacen los botones cuando se les hace clic
			//btn iniciar sesión == estado =2
			if(btnIniciarSesion.isHover()) {
				estado = 1;
			}
			if(btnRegistro.isHover()) {
				estado = 2;
			}
			// si,necesito ver si funciona la desactivación, y ps tmb
			break;
		case 1:
		//Pantalla Login

			
			if (login.getB1().isHover()) {
				try {
					validarUsuario(login.getInput().getValue(), login.getPassword().getValue());
					if (validarUsuario(login.getInput().getValue(), login.getPassword().getValue())) {
						estado = 3;
						login.stopVisualization();
					}
				} catch (UsuarioNoExisteException e) {
					System.out.println(e.getMessage());
				}
			}

			break;
		case 2:
		//Pantalla Registro
			if (register.getB1().isHover()) {
				try {
					validarContraseñas(register.getPassword().getValue(), register.getCpassword().getValue());
					if (validarContraseñas(register.getPassword().getValue(), register.getCpassword().getValue())) {

						if (validarCamposLlenos(register.getName().getValue(), register.getInput().getValue(),
								register.getPassword().getValue(), register.getCpassword().getValue())) {
							añadirUsuarios(register.getInput().getValue(), register.getPassword().getValue(),
									register.getPassword().getValue(), register.getName().getValue());
							estado = 3;
							register.stopVisualization();
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
			// Cuando se le de clic en el boton Jugar pasar a la pantalla de escenario
			if (app.mouseX > 748 && app.mouseX < 748 + 231 && app.mouseY > 503 && app.mouseY < 503 + 52) {
				reiniciar(app);
				estado = 5;
			}
			break;

		case 9:
			// Pantalla Partidas
			// Si esta el mouse encima del Boton Ok pasar a la pantalla escenario
			if (app.mouseX > 500 && app.mouseX < 500 + 231 && app.mouseY > 553 && app.mouseY < 553 + 52) {
				estado = 5;
			}
		}
	}

	public boolean validarUsuario(String user, String password) throws UsuarioNoExisteException {
		for (Usuario usuario : usuarios) {
			if (user.equals(usuario.getUsuario()) && password.equals(usuario.getContraseña())) {
				return true;
			} else {
				throw new UsuarioNoExisteException();
			}
		}
		return false;
	}

	public boolean validarContraseñas(String c1, String c2) throws NoSamePasswordException {
		boolean estado = false;

		if (c1.equals(c2)) {
			estado = true;
		} else {
			estado = false;
			throw new NoSamePasswordException();
		}
		return estado;
	}

	public void añadirUsuarios(String usuario, String contraseña, String confirmarContraseña, String nombre) {
		usuarios.add(new Usuario(usuario, contraseña, confirmarContraseña, nombre, null));
	}

	public boolean validarCamposLlenos(String name, String user, String password, String cpassword)
			throws NoTextInsideException {
		String faltante;
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

	public void ordenarPuntajes(char key) {
		switch (key) {
		case 'z':
			Collections.sort(usuarios);
			break;
		case 'x':
			Collections.sort(usuarios, ordenarPuntaje);
			break;

		default:
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
	}

	public void reiniciar(PApplet app) {

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

		enemigoI = app.loadImage("Enemigo1.png");

		adornoMatriz = new PImage[5];
		adornoMatriz[0] = app.loadImage("Arbol.png");
		adornoMatriz[1] = app.loadImage("Pala.png");
		adornoMatriz[2] = app.loadImage("Matas.png");
		adornoMatriz[3] = app.loadImage("Tronco.png");
		adornoMatriz[4] = app.loadImage("Lago.png");

		botones = new PImage[10];
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

		vida = app.loadImage("Vida.png");
		cafeG = app.loadImage("Cafe.png");

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

		int randomX = (int) app.random(0, 1200);
		int randomY = (int) app.random(0, 70);
		listaCafes = new ArrayList<>();
		listaCafes.add(new Cafe(randomX, randomY));
		listaCafes.add(new Cafe(5, 1));

		usuarios = new LinkedList<Usuario>();
		usuarios.add(new Usuario("master", "12345", "12345", "usuarioMaestro", new Partida("3:50", "50")));

		login = new Login(app,botones[12]);
		register = new Register(app,botones[12]);
		personaje.vidas = 1;
		ordenarPuntaje = new OrdenarPorPuntaje();
	}
}
