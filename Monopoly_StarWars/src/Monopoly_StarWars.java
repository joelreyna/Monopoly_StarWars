import java.util.*;

public class Monopoly_StarWars {
	static String adelante, jugador1, jugador2;
	static Scanner reader = new Scanner(System.in);
	static boolean band = false, turnoPersonaje1 = false, turnoPersonaje2 = false, juego = false, vuelta = false,
			comparada = false, nuevoTurno = true, jugador1EnPrision = false, jugador2EnPrision = false,
			cartaSalirPrisionJ1 = false, cartaSalirPrisionJ2 = false;
	static int numPersonaje, personajeEscogido, posJugador1 = 0, posJugador2 = 0, cuentaJugador1 = 0,
			cuentaJugador2 = 0, turnosEnPrisionJ1 = 0, turnosEnPrisionJ2 = 0, cantEstacionesJ1 = 0, cantEstacionesJ2 = 0;
	static String[] nombreCasilla = { "GO", "Polis Massa", "Carta del Imperio", "Mustafar", "Impuestos",
			"Estación espacial Dibrook", "Stalgasin", "Carta de los Rebeldes", "Base eco", "Eadu",
			"Prisión Imperial Bakura", "Iziz", "Servicio de reparación de naves espaciales", "Tipoca", "El prisma",
			"Estación espacial Zygerriana", "Arena  de Geonosis", "Carta del Imperio", "Mos Espa", "Ciudad Nube",
			"Cantina de Mos Eisley", "Planeta Rodia", "Carta de los Rebeldes", "Cuevas de Cristal", "Palacio de Jabba",
			"Estación espacial Kwenn", "Theed", "Tatooine", "Servicio de noticias galáctico", "Bosque de Endor",
			"Váyase a Prisión", "Otoh Gunga", "Naboo", "Carta del Imperio", "Valle de los Jedi",
			"Estación espacial Valor", "Carta de los Rebeldes", "Jedha", "Impuestos", "La Estrella de la Muerte" };
	static int[] precioCasilla = { 0, 60, 0, 60, 0, 200, 100, 0, 100, 120, 0, 140, 150, 140, 160, 200, 180, 0, 180, 200,
			0, 220, 0, 220, 240, 200, 260, 260, 150, 280, 0, 300, 300, 0, 320, 200, 0, 350, 0, 400 };
	static int[] numeroCasilla = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 };
	static boolean[] casillaComprada = { false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false };
	static String[] propietarioCasilla = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", };
	static int[] alquilerCasilla = { 0, 2, 0, 4, 0, 25, 6, 0, 6, 8, 0, 10, 0, 10, 12, 25, 14, 0, 14, 16, 0, 18, 0, 18,
			20, 25, 22, 22, 0, 24, 0, 26, 26, 0, 28, 25, 0, 35, 0, 50 };
	static int[] precioDeCasa = {0,50,0,50,0,0,50,0,50,50,0,100,0,100,100,0,100,0,100,100,0,150,0,150,150,0,150,150,0,150,0,200,200,0,200,0,0,200,0,200};
	static int[] numDeCasasEnCasilla = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] alquilerCasillaCon1Casa = {0,10,0,20,0,0,30,0,30,40,0,50,0,50,60,0,70,0,70,80,0,90,0,90,100,0,110,110,0,120,0,130,130,0,150,0,0,175,0,200};
	static int[] alquilerCasillaCon2Casa = {0,30,0,60,0,0,90,0,90,100,0,150,0,150,180,0,200,0,200,220,0,250,0,250,300,0,330,330,0,360,0,390,390,0,450,0,0,500,0,600};
	static int[] alquilerCasillaCon3Casa = {0,10,0,20,0,0,30,0,30,40,0,50,0,50,60,0,70,0,70,80,0,90,0,90,100,0,110,110,0,120,0,130,130,0,150,0,0,1750,0,200};
	static int[] alquilerCasillaCon4Casa = {0,10,0,20,0,0,30,0,30,40,0,50,0,50,60,0,70,0,70,80,0,90,0,90,100,0,110,110,0,120,0,130,130,0,150,0,0,1750,0,200};

	public static void main(String[] args) {
		
		Inicio();

		while (juego) {
			if (turnoPersonaje1) {
				ASCIICambioDeTurno();
				while (nuevoTurno) {
					nuevoTurno = false;
					ChecarSiEnBancarrota(1);
					System.out
							.println("\n///////////////////////////////////////////////////////\nTURNO DE " + jugador1);
					System.out.println("Saldo actual: $" + cuentaJugador1 + " Wupiupis\n");
					if(!jugador1EnPrision) {
						posJugador1 += AvanzarCasillas();
						posJugador1 = ChecarSiVuelta(posJugador1);
						if (vuelta) {
							cuentaJugador1 += 200;
							System.out.println("Saldo actual: $" + cuentaJugador1 + " Wupiupis");
							vuelta = false;
						}
					}
					InfoCasilla(posJugador1, 1);
					ComprarCasilla(1);
					while (!band) {
						Menu(1);
					}
					band = false;
				}
				nuevoTurno = true;
				// FIN de TURNO
				turnoPersonaje1 = false;
				turnoPersonaje2 = true;
				if(!juego) {
					break;
				}
			} else if (turnoPersonaje2) {
				ASCIICambioDeTurno();
				while (nuevoTurno) {
					nuevoTurno = false;
					ChecarSiEnBancarrota(2);
					System.out
							.println("\n///////////////////////////////////////////////////////\nTURNO DE " + jugador2);
					System.out.println("Saldo actual: $" + cuentaJugador2 + " Wupiupis");
					if(!jugador2EnPrision) {
						posJugador2 += AvanzarCasillas();
						posJugador2 = ChecarSiVuelta(posJugador2);
						if (vuelta) {
							cuentaJugador2 += 200;
							System.out.println("Saldo actual: $" + cuentaJugador2 + " Wupiupis\n");
							vuelta = false;
						}
					}
					InfoCasilla(posJugador2, 2);
					ComprarCasilla(2);
					while (!band) {
						Menu(2);
					}
					band = false;
				}

				nuevoTurno = true;
				// FIN de TURNO
				turnoPersonaje1 = true;
				turnoPersonaje2 = false;
				if(!juego) {
					break;
				}
			}
		}

	}

	/*
	 * Funciones
	 */

	//Estaciones espaciales en posesión
	public static int CantidadEstaciones(int jugador) {
		if(jugador==1) {
			for(int i=5;i<=35;i+=5) {
				if(propietarioCasilla[i].equals(jugador1)) {
					cantEstacionesJ1++;
				}
			}
			return cantEstacionesJ1;
		} else if (jugador == 2) {
			for(int i=5;i<=35;i+=5) {
				if(propietarioCasilla[i].equals(jugador2)) {
					cantEstacionesJ2++;
				}
			}
			return cantEstacionesJ2;
		}
		return 0;
	}
	
	// Menu por turno
	public static void Menu(int jugador) {
		int numeroDePropiedadJugador = 1;
		System.out.println("\n¿Qué desea hacer?");
		/*
		 * GOD MODE
		 */
		//System.out.println("4. GOD MODE");
		if (jugador == 1) {
			System.out.println("1. Ver propiedades\n2. Checar saldo\n3. Comprar casas\n4. Terminar turno");
			try {
				int opcion = reader.nextInt();
				switch (opcion) {
				case 1:
					for (int i = 0; i < propietarioCasilla.length; i++) {
						if (propietarioCasilla[i].equals(jugador1)) {
							System.out.println(numeroDePropiedadJugador + ". " + nombreCasilla[i] + ". Numero de casilla: "
									+ numeroCasilla[i]);
							numeroDePropiedadJugador++;
						}
					}
					break;
				case 2:
					System.out.println("Tu saldo es: $" + cuentaJugador1);
					break;
				case 3: 
					for (int i = 0; i < propietarioCasilla.length; i++) {
						if (propietarioCasilla[i].equals(jugador1)) {
							if(!((numeroCasilla[i]==5)||(numeroCasilla[i]==15)||(numeroCasilla[i]==25)||(numeroCasilla[i]==35)||(numeroCasilla[i]==12)||(numeroCasilla[i]==28))) {
								System.out.println(numeroDePropiedadJugador + ". " + nombreCasilla[i] + ". Numero de casilla: "
										+ numeroCasilla[i]);
								numeroDePropiedadJugador++;
							}
						}
					}
					while (!band) {
						System.out.println("¿En que casilla quieres comprar una casa? (Ingresa numero de casilla)");
						try {
							int casilla = reader.nextInt();
							if (propietarioCasilla[casilla].equals(jugador1)) {
								System.out.println("Una casa en esta casilla cuesta $" + precioDeCasa[casilla]);
								System.out.println("¿Desea comprarla? Ingrese 'si' o 'no'");
								adelante = reader.next();
								adelante = adelante.toUpperCase();
								if(adelante.equals("SI")) {
									numDeCasasEnCasilla[casilla]++;
									cuentaJugador1 -= precioDeCasa[casilla];
								} 
							} else {
								System.out.println("Usted no posee esa casilla");
							}
						} catch (Exception e) {
							System.out.print("Favor de solo ingresar un numero");
							reader.nextInt();
						}
						System.out.println("Salir de 'Comprar casas', 'si' o 'no'");
						adelante = reader.next();
						adelante = adelante.toUpperCase();
						if(adelante.equals("SI")) {
							band = true;
						} 
					}
					band = false;
					break;
				case 4:
					band = true;
					break;
				/*
				 * GOD MODE
				 */
				/*case 4:
					System.out.print("A que casilla quiere ir: ");
					opcion = reader.nextInt();
					posJugador1 = opcion;
					InfoCasilla(posJugador1, 1);
					ComprarCasilla(1);
				 */
				}

			} catch (Exception e) {
				System.out.println("Favor de solo ingresar un numero del 1-4");
				reader.next();
			}
		} else if (jugador == 2) {
			System.out.println("1. Ver propiedades\n2. Checar saldo\n3. Comprar casas\n4. Terminar turno");
			try {
				int opcion = reader.nextInt();
				switch (opcion) {
				case 1:
					for (int i = 0; i < propietarioCasilla.length; i++) {
						if (propietarioCasilla[i].equals(jugador2)) {
							System.out.println(numeroDePropiedadJugador + ". " + nombreCasilla[i] + ". Numero de casilla: "
									+ numeroCasilla[i]);
							numeroDePropiedadJugador++;
						}
					}
					break;
				case 2:
					System.out.println("Tu saldo es: $" + cuentaJugador2);
					break;
				case 3:
					for (int i = 0; i < propietarioCasilla.length; i++) {
						if (propietarioCasilla[i].equals(jugador2)) {
							if(!((numeroCasilla[i]==5)||(numeroCasilla[i]==15)||(numeroCasilla[i]==25)||(numeroCasilla[i]==35)||(numeroCasilla[i]==12)||(numeroCasilla[i]==28))) {
								System.out.println(numeroDePropiedadJugador + ". " + nombreCasilla[i] + ". Numero de casilla: "
										+ numeroCasilla[i]);
								numeroDePropiedadJugador++;
							}
						}
					}
					while (!band) {
						System.out.println("¿En que casilla quieres comprar una casa? (Ingresa numero de casilla)");
						try {
							int casilla = reader.nextInt();
							if (propietarioCasilla[casilla].equals(jugador2)) {
								System.out.println("Una casa en esta casilla cuesta $" + precioDeCasa[casilla]);
								System.out.println("¿Desea comprarla? Ingrese 'si' o 'no'");
								adelante = reader.next();
								adelante = adelante.toUpperCase();
								if(adelante.equals("SI")) {
									numDeCasasEnCasilla[casilla]++;
									cuentaJugador2 -= precioDeCasa[casilla];
								} 
							} else {
								System.out.println("Usted no posee esa casilla");
							}
						} catch (Exception e) {
							System.out.print("Favor de solo ingresar un numero");
							reader.nextInt();
						}
						System.out.println("Salir de 'Comprar casas', 'si' o 'no'");
						adelante = reader.next();
						adelante = adelante.toUpperCase();
						if(adelante.equals("SI")) {
							band = true;
						} 
					}
					band = false;
					break;
				case 4:
					band = true;
					break;
				/*
				 * GOD MODE
				 */
				/*case 4:
					System.out.print("A que casilla quiere ir: ");
					opcion = reader.nextInt();
					posJugador2 = opcion;
					InfoCasilla(posJugador2, 2);
					ComprarCasilla(2);
				 */
				}

			} catch (Exception e) {
				System.out.println("Favor de solo ingresar un numero del 1-4");
				reader.next();
			}
		}
	}

	// Tirar un dado
	public static int Dado() {
		int dado;
		dado = (int) Math.floor((Math.random() * 6) + 1);
		while (dado > 6) {
			dado = (int) Math.floor((Math.random() * 6) + 1);
		}
		return dado;
	}

	// Tirar dos dados
	public static int TirarDados() {
		System.out.println("Presiona una tecla y enter para tirar dados: ");
		adelante = reader.next();
		int dado1 = Dado();
		int dado2 = Dado();
		int result = dado1 + dado2;
		return result;
	}

	// Tirar dados y avanzar
	public static int AvanzarCasillas() {
		int dado1, dado2, casillas;
		dado1 = Dado();
		dado2 = Dado();

		System.out.print("Presiona una tecla y 'Enter' para lanzar los dados: ");
		adelante = reader.next();

		System.out.println("Dado 1: " + dado1);
		System.out.println("Dado 2: " + dado2);
		casillas = dado1 + dado2;

		if (dado1 == dado2) {
			System.out.println("Tienes un nuevo turno al final de este!");
			nuevoTurno = true;
		}

		System.out.println("Anvanzas " + casillas + " casillas.");
		return casillas;
	}

	// Checar si son cartas especiales
	public static boolean EsCasillaEspecial(int posicion) {
		if ((numeroCasilla[posicion] == 2) || (numeroCasilla[posicion] == 17) || (numeroCasilla[posicion] == 33)
				|| (numeroCasilla[posicion] == 7) || (numeroCasilla[posicion] == 22) || (numeroCasilla[posicion] == 36)
				|| (numeroCasilla[posicion] == 4) || (numeroCasilla[posicion] == 38) || (numeroCasilla[posicion] == 10)
				|| (numeroCasilla[posicion] == 30) || (numeroCasilla[posicion] == 20)
				|| (numeroCasilla[posicion] == 0)) {
			return true;
		} else {
			return false;
		}
	}

	// Informacion de casilla
	public static void InfoCasilla(int posicion, int jugador) {
		System.out.println("\nLlegaste a: ");
		System.out.println(nombreCasilla[posicion]);
		System.out.println("Numero de casilla: " + (numeroCasilla[posicion] + 1));
		if ((numeroCasilla[posicion] == 2) || (numeroCasilla[posicion] == 17) || (numeroCasilla[posicion] == 33)) {
			CartaDelImperio(jugador);
		} else if ((numeroCasilla[posicion] == 7) || (numeroCasilla[posicion] == 22)
				|| (numeroCasilla[posicion] == 36)) {
			CartaDeLosRebeldes(jugador);
		} else if ((numeroCasilla[posicion] == 4) || (numeroCasilla[posicion] == 38)) {
			// Impuestos
			if (jugador == 1) {
				if (numeroCasilla[posicion] == 4) {
					System.out.println("Tiene que pagar $200 al banco");
					cuentaJugador1 -= 200;
				} else if (numeroCasilla[posicion] == 38) {
					System.out.println("Tiene que pagar $100 al banco");
					cuentaJugador1 -= 100;
				}
			} else if (jugador == 2) {
				if (numeroCasilla[posicion] == 4) {
					System.out.println("Tiene que pagar $200 al banco");
					cuentaJugador2 -= 200;
				} else if (numeroCasilla[posicion] == 38) {
					System.out.println("Tiene que pagar $100 al banco");
					cuentaJugador2 -= 100;
				}
			}
		} else if (numeroCasilla[posicion] == 10) {
			// Prision
			if (jugador == 1) {
				if (jugador1EnPrision) {
					turnosEnPrisionJ1++;
					System.out.println("Está encerrado en prisión");
					System.out.println("LLeva " + turnosEnPrisionJ1 + " turno/s en prisión.");
					if (cartaSalirPrisionJ1) {
						System.out.println("¿Utilizar carta para salir de prisión gratis?");
						while (!band) {
							adelante = reader.next();
							adelante = adelante.toUpperCase();
							if (adelante.equals("SI")) {
								cartaSalirPrisionJ1 = false;
								jugador1EnPrision = false;
								turnosEnPrisionJ1 = 0;
								System.out.println("Podrá salir al siguiente turno");
								band = true;
							} else if (adelante.equals("NO")) {
								band = true;
							} else {
								System.out.println("Ingrese solamente 'si' o 'no'");
							}
						}
						band = false;
					}
					if (jugador1EnPrision) {
						System.out.print(
								"Tira los dados para ver si sacas dobles. Presiona una tecla y enter para continuar: ");
						adelante = reader.next();
						int dado1 = Dado();
						int dado2 = Dado();
						int result = dado1 + dado2;
						System.out.println("Dado 1: " + dado1 + "\nDado 2: " + dado2);
						if (dado1 == dado2) {
							System.out.println("¡Ha obtenido dobles!");
							jugador1EnPrision = false;
							turnosEnPrisionJ1 = 0;
							posJugador1 += result;
							InfoCasilla(posJugador1, jugador);
						}
					}
					if (jugador1EnPrision) {
						System.out.println("¿Desea pagar una multa de $50 para salir?");
						while (!band) {
							adelante = reader.next();
							adelante = adelante.toUpperCase();
							if (adelante.equals("SI")) {
								cuentaJugador1 -= 50;
								jugador1EnPrision = false;
								System.out.println("Podrá salir al siguiente turno");
								turnosEnPrisionJ1 = 0;
								band = true;
							} else if (adelante.equals("NO")) {
								band = true;
							} else {
								System.out.println("Ingrese solamente 'si' o 'no'");
							}
						}
						band = false;
					}
					if (jugador1EnPrision) {
						if (turnosEnPrisionJ1 >= 3) {
							turnosEnPrisionJ1 = 0;
							System.out.println(
									"Ya ha estado 3 turnos en prisión, tiene que pagar $50, y sale el proximo turno");
							cuentaJugador1 -= 50;
							System.out.println("Saldo jugador 1: $" + cuentaJugador1);
							jugador1EnPrision = false;
						}
					}
				} else {
					System.out.println("Está aqui de visita.");
				}
			} else if (jugador == 2) {

				if (jugador2EnPrision) {
					turnosEnPrisionJ2++;
					System.out.println("Está encerrado en prisión");
					System.out.println("LLeva " + turnosEnPrisionJ2 + " turno/s en prisión.");
					if (cartaSalirPrisionJ2) {
						System.out.println("¿Utilizar carta para salir de prisión gratis?");
						while (!band) {
							adelante = reader.next();
							adelante = adelante.toUpperCase();
							if (adelante.equals("SI")) {
								cartaSalirPrisionJ2 = false;
								jugador2EnPrision = false;
								turnosEnPrisionJ2 = 0;
								band = true;
							} else if (adelante.equals("NO")) {
								band = true;
							} else {
								System.out.println("Ingrese solamente 'si' o 'no'");
							}
						}
						band = false;
					}
					if (jugador2EnPrision) {
						System.out.print(
								"Tira los dados para ver si sacas dobles. Presiona una tecla y enter para continuar: ");
						adelante = reader.next();
						int dado1 = Dado();
						int dado2 = Dado();
						int result = dado1 + dado2;
						System.out.println("Dado 1: " + dado1 + "\nDado 2: " + dado2);
						if (dado1 == dado2) {
							System.out.println("¡Ha obtenido dobles!");
							jugador2EnPrision = false;
							turnosEnPrisionJ2 = 0;
							posJugador2 += result;
							InfoCasilla(posJugador2, jugador);
						}
					}
					if (jugador2EnPrision) {
						System.out.println("¿Desea pagar una multa de $50 para salir?");
						while (!band) {
							adelante = reader.next();
							adelante = adelante.toUpperCase();
							if (adelante.equals("SI")) {
								cuentaJugador2 -= 50;
								jugador2EnPrision = false;
								turnosEnPrisionJ2 = 0;
								System.out.println("Podrá salir al siguiente turno");
								band = true;
							} else if (adelante.equals("NO")) {
								band = true;
							} else {
								System.out.println("Ingrese solamente 'si' o 'no'");
							}
						}
						band = false;
					}
					if (jugador2EnPrision) {
						if (turnosEnPrisionJ2 >= 3) {
							System.out.println("Ya ha estado 3 turnos en prisión, tiene que pagar $50, y sale el proximo turno");
							cuentaJugador2 -= 50;
							System.out.println("Saldo jugador 2: $" + cuentaJugador2);
							jugador2EnPrision = false;
							turnosEnPrisionJ2 = 0;
						}
					}
				} else {
					System.out.println("Está aqui de visita");
				}
			}
		} else if ((numeroCasilla[posicion] == 12) || (numeroCasilla[posicion] == 28)) {
			// Servicios
			if (!casillaComprada[posicion]) {
				if (jugador == 1) {
					//ComprarCasilla(1);
				} else if (jugador == 2) {
					//ComprarCasilla(2);
				}
			} else if (casillaComprada[posicion]) {
				if (jugador == 1) {
					if (!propietarioCasilla[posicion].equals(jugador1)) {
						if ((!propietarioCasilla[posicion].equals(propietarioCasilla[12]))
								|| (!propietarioCasilla[posicion].equals(propietarioCasilla[28]))) {
							System.out.println(
									"El propietario solo cuenta con una de las casillas de servicios. Total a pagar: Dados * 4");
							System.out.print("Tire los dados para ver cuanto pagará.");
							int result = TirarDados();
							System.out.println(
									"Ha obtenido " + result + ". Usted paga " + result + " * 4: $" + (result * 4));
							int totalAPagar = result * 4;
							cuentaJugador1 -= totalAPagar;
							cuentaJugador2 += totalAPagar;
						} else if ((propietarioCasilla[posicion].equals(propietarioCasilla[12]))
								|| (propietarioCasilla[posicion].equals(propietarioCasilla[28]))) {
							System.out.println(
									"El propietario cuenta con las dos casillas de servicios. Total a pagar: Dados * 10");
							System.out.print("Tire los dados para ver cuanto pagará.");
							int result = TirarDados();
							System.out.println(
									"Ha obtenido " + result + ". Usted paga " + result + " * 10: $" + (result * 10));
							int totalAPagar = result * 10;
							cuentaJugador1 -= totalAPagar;
							cuentaJugador2 += totalAPagar;
						}
					}
				} else if (jugador == 2) {
					// System.out.println("Propietario: " + propietarioCasilla[posicion]);
					if (!propietarioCasilla[posicion].equals(jugador2)) {
						if ((!propietarioCasilla[posicion].equals(propietarioCasilla[12]))
								|| (!propietarioCasilla[posicion].equals(propietarioCasilla[28]))) {
							System.out.println(
									"El propietario solo cuenta con una de las casillas de servicios. Total a pagar: Dados * 4");
							System.out.print("Tire los dados para ver cuanto pagará.");
							int result = TirarDados();
							System.out.println(
									"Ha obtenido " + result + ". Usted paga " + result + " * 4: $" + (result * 4));
							int totalAPagar = result * 4;
							cuentaJugador2 -= totalAPagar;
							cuentaJugador1 += totalAPagar;
						} else if ((propietarioCasilla[posicion].equals(propietarioCasilla[12]))
								|| (propietarioCasilla[posicion].equals(propietarioCasilla[28]))) {
							System.out.println(
									"El propietario cuenta con las dos casillas de servicios. Total a pagar: Dados * 10");
							System.out.print("Tire los dados para ver cuanto pagará.");
							int result = TirarDados();
							System.out.println(
									"Ha obtenido " + result + ". Usted paga " + result + " * 10: $" + (result * 10));
							int totalAPagar = result * 10;
							cuentaJugador2 -= totalAPagar;
							cuentaJugador1 += totalAPagar;
						}
					}
				}
			}
		} else if (numeroCasilla[posicion] == 30) {
			// Vayase a prisión
			if (jugador == 1) {
				System.out.println("¡Váyase directamente a prisión por bandalismo!");
				jugador1EnPrision = true;
				posJugador1 = 10;
			} else if (jugador == 2) {
				System.out.println("¡Váyase directamente a prisión por bandalismo!");
				jugador2EnPrision = true;
				posJugador2 = 10;
			}
		} else if (numeroCasilla[posicion] == 20) {
			// Cantina Mos Eisley
			System.out.println("Esta aquí de paso, puede descansar un poco antes de continuar");
		} else if (numeroCasilla[posicion] == 0) {
			// GO
		} else {
			// Precio, comprada o no (si no, propietario, alquiler)
			/*
			 * if(casillaComprada[posicion]) { System.out.println("Propietario: " +
			 * propietarioCasilla[posicion]); }
			 */
		}
	}

	// Compra de casilla
	public static void ComprarCasilla(int jugador) {
		if (jugador == 1) {
			if (!EsCasillaEspecial(posJugador1)) {
				if (!casillaComprada[posJugador1]) {
					System.out.println(
							"Esta casilla no está comprada.\nPrecio de la casilla: $" + precioCasilla[posJugador1]);
					// QUIERES COMPRAR SI O NO
					System.out.println("¿Deseas comprar esta casilla? (Si o No)");
					adelante = reader.next();
					adelante = adelante.toUpperCase();
					while (!band) {
						if (adelante.equals("SI")) {
							casillaComprada[posJugador1] = true;
							propietarioCasilla[posJugador1] = jugador1;
							cuentaJugador1 -= precioCasilla[posJugador1];
							band = true;
						} else if (adelante.equals("NO")) {
							band = true;
							break;
						} else {
							System.out.println("Favor de solo ingresar 'si' o 'no'");
							adelante = reader.next();
							adelante = adelante.toUpperCase();
						}
					}
					band = false;
				} else {
					if ((posJugador1 == 5) || (posJugador1 == 15) || (posJugador1 == 25) || (posJugador1 ==35)) {
						System.out.println("Propietario: " + propietarioCasilla[posJugador1]);
						if (!propietarioCasilla[posJugador1].equals(jugador1)) {
							System.out.println("El propietario cuenta con " + CantidadEstaciones(2) + " estaciones. (Pagar $50 por estacion)");
							System.out.println("Se ha pagado $ " + (25 * CantidadEstaciones(2)) + " al jugador 2.");
							cuentaJugador1 -= 25 * CantidadEstaciones(2);
							cuentaJugador2 += 25 * CantidadEstaciones(2);
						}
					}
					if ((posJugador1 != 12) && (posJugador1 != 28) && !((posJugador1 == 5) || (posJugador1 == 15) || (posJugador1 == 25) || (posJugador1 ==35))) {
						System.out.println("Propietario: " + propietarioCasilla[posJugador1]);
						if (!propietarioCasilla[posJugador1].equals(jugador1)) {
							System.out.println("Se ha pagado $ " + alquilerCasilla[posJugador1] + " al jugador 2.");
							cuentaJugador1 -= alquilerCasilla[posJugador1];
							cuentaJugador2 += alquilerCasilla[posJugador1];
						}
					}
				}
			}
		} else if (jugador == 2) {
			if (!EsCasillaEspecial(posJugador2)) {
				if (!casillaComprada[posJugador2]) {
					System.out.println(
							"Esta casilla no está comprada.\nPrecio de la casilla: $" + precioCasilla[posJugador2]);
					// QUIERES COMPRAR SI O NO
					System.out.println("¿Deseas comprar esta casilla? (Si o No)");
					adelante = reader.next();
					adelante = adelante.toUpperCase();
					while (!band) {
						if (adelante.equals("SI")) {
							casillaComprada[posJugador2] = true;
							propietarioCasilla[posJugador2] = jugador2;
							cuentaJugador2 -= precioCasilla[posJugador2];
							band = true;
						} else if (adelante.equals("NO")) {
							band = true;
							break;
						} else {
							System.out.println("Favor de solo ingresar 'si' o 'no'");
							adelante = reader.next();
							adelante = adelante.toUpperCase();
						}
					}
					band = false;
				} else {
					if ((posJugador2 == 5) || (posJugador2 == 15) || (posJugador2 == 25) || (posJugador2 ==35)) {
						System.out.println("Propietario: " + propietarioCasilla[posJugador2]);
						if (!propietarioCasilla[posJugador2].equals(jugador2)) {
							System.out.println("El propietario cuenta con " + CantidadEstaciones(1) + " estaciones. (Pagar $50 por estacion)");
							System.out.println("Se ha pagado $ " + (25 * CantidadEstaciones(1)) + " al jugador 1.");
							cuentaJugador2 -= 25 * CantidadEstaciones(1);
							cuentaJugador1 += 25 * CantidadEstaciones(1);
						}
					}
					if ((posJugador2 != 12) && (posJugador2 != 28) && !((posJugador2 == 5) || (posJugador2 == 15) || (posJugador2 == 25) || (posJugador2 ==35))) {
						// System.out.println("Propietario: " + propietarioCasilla[posJugador2]);
						if (!propietarioCasilla[posJugador2].equals(jugador2)) {
							System.out.println("Se ha pagado $ " + alquilerCasilla[posJugador2] + " al jugador 1.");
							cuentaJugador2 -= alquilerCasilla[posJugador2];
							cuentaJugador1 += alquilerCasilla[posJugador2];
						}
					}
				}
			}
		}

	}

	// Chechar si pasa por GO
	public static int ChecarSiVuelta(int posicion) {
		if (posicion > 39) {
			posicion -= 40;
			System.out.println("Pasa por GO, recibe $200 Wupiupis");
			vuelta = true;
		}
		return posicion;
	}

	// Cartas del imperio
	public static void CartaDelImperio(int jugador) {
		int numCarta = (int) Math.floor((Math.random() * 15) + 1);
		if (numCarta > 15) {
			numCarta = 15;
		}
		if (jugador == 1) {
			switch (numCarta) {
			case 1:
				System.out.println("Usted hereda $100 de un pariente lejos de esta galaxia");
				cuentaJugador1 += 100;
				break;
			case 2:
				System.out.println("Usted ha ganado $10 en un concurso de tiro");
				cuentaJugador1 += 10;
				break;
			case 3:
				System.out.println("El Banco Estelar le pagará $45 debido a una deuda pendiente");
				cuentaJugador1 += 45;
				break;
			case 4:
				System.out.println("Se ha herido en una batalla, pague al banco estelar $50 para el médico");
				cuentaJugador1 -= 50;
				break;
			case 5:
				System.out.println("Le ha ganado una apuesta al otro jugador, cóbrele $50");
				cuentaJugador1 += 50;
				cuentaJugador2 -= 50;
				break;
			case 6:
				System.out.println("Se le reembolsaran $20 debido a sus contribuciones para salvar a la galaxia");
				cuentaJugador1 += 20;
				break;
			case 7:
				System.out.println(
						"¡Hay que reparar nuestras ciudades destruidas! Pague $100 para las reparaciones");
				cuentaJugador1 -= 100;
				break;
			case 8:
				System.out.println(
						"Se ha cumplido el plazo de sus ahorros para la compra de un nuevo sable de luz, cobre $100");
				cuentaJugador1 += 100;
				break;
			case 9:
				System.out.println("El Banco Intergaláctico le paga $100 por devolución de impuestos imperiales");
				cuentaJugador1 += 100;
				break;
			case 10:
				System.out.println("Pague $100 por impuestos espaciales");
				cuentaJugador1 += 100;
				break;
			case 11:
				System.out.println("Viaje a través del hiperespacio a GO, cobre $200");
				posJugador1 = 0;
				System.out.println("Pasa por GO, recibe $200 Wupiupis");
				cuentaJugador1 += 200;
				break;
			case 12:
				System.out.println("Tiene que renovar su licencia intergaláctica, pague $150");
				cuentaJugador1 -= 150;
				break;
			case 13:
				System.out.println("¡Ha sido capturado! Váyase directamente a prisión sin pasar por GO ni cobrar $200");
				jugador1EnPrision = true;
				posJugador1 = 10;
				break;
			case 14:
				System.out.println("¡La Gran Apertura de la cantina de Mos Eisley! Recibe $25");
				cuentaJugador1 += 25;
				break;
			case 15:
				System.out.println("¡Salga de la prisión gratis! Puede guardar esta tarjeta");
				cartaSalirPrisionJ1 = true;
				break;
			}
		} else if (jugador == 2) {
			switch (numCarta) {
			case 1:
				System.out.println("Usted hereda $100 de un pariente lejos de esta galaxia");
				cuentaJugador2 += 100;
				break;
			case 2:
				System.out.println("Usted ha ganado $10 en un concurso de tiro");
				cuentaJugador2 += 10;
				break;
			case 3:
				System.out.println("El Banco Estelar le pagará $45 debido a una deuda pendiente");
				cuentaJugador2 += 45;
				break;
			case 4:
				System.out.println("Se ha herido en una batalla, pague al banco estelar $50 para el médico");
				cuentaJugador2 -= 50;
				break;
			case 5:
				System.out.println("Le ha ganado una apuesta al otro jugador, cóbrele $50");
				cuentaJugador2 += 50;
				cuentaJugador1 -= 50;
				break;
			case 6:
				System.out.println("Se le reembolsaran $20 debido a sus contribuciones para salvar a la galaxia");
				cuentaJugador2 += 20;
				break;
			case 7:
				System.out.println(
						"¡Hay que reparar nuestras ciudades destruidas! Pague $100 para las reparaciones");
				cuentaJugador2 -= 100;
				break;
			case 8:
				System.out.println(
						"Se ha cumplido el plazo de sus ahorros para la compra de un nuevo sable de luz, cobre $100");
				cuentaJugador2 += 100;
				break;
			case 9:
				System.out.println("El Banco Intergaláctico le paga $100 por devolución de impuestos imperiales");
				cuentaJugador2 += 100;
				break;
			case 10:
				System.out.println("Pague $100 por impuestos espaciales");
				cuentaJugador2 += 100;
				break;
			case 11:
				System.out.println("Viaje a través del hiperespacio a GO, cobre $200");
				posJugador2 = 0;
				System.out.println("Pasa por GO, recibe $200 Wupiupis");
				cuentaJugador2 += 200;
				break;
			case 12:
				System.out.println("Tiene que renovar su licencia intergaláctica, pague $150");
				cuentaJugador2 -= 150;
				break;
			case 13:
				System.out.println("¡Ha sido capturado! Váyase directamente a prisión sin pasar por GO ni cobrar $200");
				jugador2EnPrision = true;
				posJugador2 = 10;
				break;
			case 14:
				System.out.println("¡La Gran Apertura de la cantina de Mos Eisley! Recibe $25");
				cuentaJugador2 += 25;
				break;
			case 15:
				System.out.println("¡Salga de la prisión gratis! Puede guardar esta tarjeta");
				cartaSalirPrisionJ2 = true;
				break;
			}
		}
	}

	// Cartas de los Rebeldes
	public static void CartaDeLosRebeldes(int jugador) {
		int numCarta = (int) Math.floor((Math.random() * 15) + 1);
		if (numCarta > 15) {
			numCarta = 15;
		}
		if (jugador == 1) {
			switch (numCarta) {
			case 1:
				System.out.println(
						"Avance hasta la siguiente estacion espacial y pague al dueño el alquiler correspondiente");
				if(posJugador1==7) {
					posJugador1=15;
					InfoCasilla(posJugador1, 1);
				} else if (posJugador1==22) {
					posJugador1=25;
					InfoCasilla(posJugador1, 1);
				} else if (posJugador1==36) {
					posJugador1=5;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador1 += 200;
					InfoCasilla(posJugador1, 1);
				}
				break;
			case 2:
				System.out.println(
						"Avance hasta la siguiente estacion espacial y pague al dueño el alquiler correspondiente");
				if(posJugador1==7) {
					posJugador1=15;
					InfoCasilla(posJugador1, 1);
				} else if (posJugador1==22) {
					posJugador1=25;
					InfoCasilla(posJugador1, 1);
				} else if (posJugador1==36) {
					posJugador1=5;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador1 += 200;
					InfoCasilla(posJugador1, 1);
				}
				break;
			case 3:
				System.out.println("¡Atrás!, retroceda 3 casillas");
				posJugador1 = posJugador1 - 3;
				InfoCasilla(posJugador1, 1);
				break;
			case 4:
				System.out.println(
						"Muévase a la siguiente casilla de Servicios. Si tiene propietario, pague al propietario lo que corresponda");
				if((posJugador1>28)||(posJugador1<12)) {
					posJugador1 = 12;
					InfoCasilla(posJugador1, 1);
				} else {
					posJugador1 = 28;
					InfoCasilla(posJugador1, 1);
				}
				break;
			case 5:
				System.out.println(
						"Surge una rebelión en todos los planetas, page $200 para evitar ser saqueado");
				cuentaJugador1 -= 200;
				break;
			case 6:
				System.out.println("Se vence el plazo de su caja de ahorros integaláctica, cobre al banco $150");
				cuentaJugador1 += 150;
				break;
			case 7:
				System.out.println("Ha sido capturado por el Imperio, avance hasta la Estrella de la Muerte");
				posJugador1 = 39;
				InfoCasilla(posJugador1, 1);
				break;
			case 8:
				System.out.println("Viaje a través del Hiperespacio hasta GO, cobrese $200");
				posJugador1 = 0;
				System.out.println("Pasa por GO, recibe $200 Wupiupis");
				cuentaJugador1 += 200;
				break;
			case 9:
				System.out.println("Pague un impuesto de $15 por tener droids ilegales");
				cuentaJugador1 -= 15;
				break;
			case 10:
				System.out.println("Tomese un paseo por la estación espacial Dibrook, si pasa por GO cobre $200");
				if(posJugador1 > 5) {
					posJugador1 = 5;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador1 += 200;
					InfoCasilla(posJugador1, 1);
				} else {
					posJugador1 = 5;
					InfoCasilla(posJugador1, 1);
				}
				break;
			case 11:
				System.out.println(
						"Váyase directamente a la prisión Bakura por pelearse con un Stormtrooper, sin pasar por GO ni y cobrar los $200");
				jugador1EnPrision = true;
				posJugador1 = 10;
				break;
			case 12:
				System.out.println(
						"Ha ganado unas vacaciones de lujo en Iziz, adelántase hacia la casilla, si pasa sobre GO, cóbrense $200");
				if(posJugador1 > 11) {
					posJugador1 = 11;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador1 += 200;
					InfoCasilla(posJugador1, 1);
				} else {
					posJugador1 = 11;
					InfoCasilla(posJugador1, 1);
				}
				break;
			case 13:
				System.out.println(
						"Ha sido obligado a huir tu ciudad, avánzase hasta el Palacio de Jabba, si pasa sobre GO, cóbrense $200");
				if(posJugador1 > 24) {
					posJugador1 = 24;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador1 += 200;
					InfoCasilla(posJugador1, 1);
				} else {
					posJugador1 = 24;
					InfoCasilla(posJugador1, 1);
				}
				break;
			case 14:
				System.out.println("Ha sido elegido como Senador de Naboo, pague $50 al otro jugador");
				cuentaJugador1 -= 50;
				cuentaJugador2 += 50;
				break;
			case 15:
				System.out.println(
						"PUEDES SALIR DE LA CÁRCEL con ayuda de los rebeldes, guardarse esta tarjeta hasta que se necesite");
				cartaSalirPrisionJ1 = true;
				break;
			}
		} else if (jugador == 2) {
			switch (numCarta) {
			case 1:
				System.out.println(
						"Avance hasta la siguiente estacion espacial y pague al dueño el alquiler correspondiente");
				if(posJugador2==7) {
					posJugador2=15;
					InfoCasilla(posJugador2, 1);
				} else if (posJugador2==22) {
					posJugador2=25;
					InfoCasilla(posJugador2, 2);
				} else if (posJugador2==36) {
					posJugador2=5;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador2 += 200;
					InfoCasilla(posJugador2, 2);
				}
				break;
			case 2:
				System.out.println(
						"Avance hasta la siguiente estacion espacial y pague al dueño el alquiler correspondiente");
				if(posJugador2==7) {
					posJugador2=15;
					InfoCasilla(posJugador2, 1);
				} else if (posJugador2==22) {
					posJugador2=25;
					InfoCasilla(posJugador2, 2);
				} else if (posJugador2==36) {
					posJugador2=5;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador2 += 200;
					InfoCasilla(posJugador2, 2);
				}
				break;
			case 3:
				System.out.println("¡Atrás!, retroceda 3 casillas");
				posJugador2 = posJugador2 - 3;
				InfoCasilla(posJugador2, 2);
				break;
			case 4:
				System.out.println(
						"Muévase a la siguiente casilla de Servicios. Si tiene propietario, pague al propietario lo que corresponda");
				if((posJugador2>28)||(posJugador2<12)) {
					posJugador2 = 12;
					InfoCasilla(posJugador2, 2);
				} else {
					posJugador2 = 28;
					InfoCasilla(posJugador2, 2);
				}
				break;
			case 5:
				System.out.println(
						"Surge una rebelión en todos los planetas, page $200 para evitar ser saqueado");
				cuentaJugador2 -= 200;
				break;
			case 6:
				System.out.println("Se vence el plazo de su caja de ahorros integaláctica, cobre al banco $150");
				cuentaJugador2 += 150;
				break;
			case 7:
				System.out.println("Ha sido capturado por el Imperio, avance hasta la Estrella de la Muerte");
				posJugador2 = 39;
				InfoCasilla(posJugador2, 2);
				break;
			case 8:
				System.out.println("Viaje a través del Hiperespacio hasta GO, cobrese $200");
				posJugador2 = 0;
				System.out.println("Pasa por GO, recibe $200 Wupiupis");
				cuentaJugador2 += 200;
				break;
			case 9:
				System.out.println("Pague un impuesto de $15 por tener droids ilegales");
				cuentaJugador2 -= 15;
				break;
			case 10:
				System.out.println("Tomese un paseo por la estación espacial Dibrook, si pasa por GO cobre $200");
				if(posJugador2 > 5) {
					posJugador2 = 5;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador2 += 200;
					InfoCasilla(posJugador2, 2);
				} else {
					posJugador2 = 5;
					InfoCasilla(posJugador2, 2);
				}
				break;
			case 11:
				System.out.println(
						"Váyase directamente a la prisión Bakura por pelearse con un Stormtrooper, sin pasar por GO ni y cobrar los $200");
				jugador2EnPrision = true;
				posJugador2 = 10;
				break;
			case 12:
				System.out.println(
						"Ha ganado unas vacaciones de lujo en Iziz, adelántase hacia la casilla, si pasa sobre GO, cóbrense $200");
				if(posJugador2 > 11) {
					posJugador2 = 11;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador2 += 200;
					InfoCasilla(posJugador2, 2);
				} else {
					posJugador2 = 11;
					InfoCasilla(posJugador2, 2);
				}
				break;
			case 13:
				System.out.println(
						"Ha sido obligado a huir tu ciudad, avánzase hasta el Palacio de Jabba, si pasa sobre GO, cóbrense $200");
				if(posJugador2 > 24) {
					posJugador2 = 24;
					System.out.println("Pasa por GO, recibe $200 Wupiupis");
					cuentaJugador2 += 200;
					InfoCasilla(posJugador2, 1);
				} else {
					posJugador2 = 24;
					InfoCasilla(posJugador2, 1);
				}
				break;
			case 14:
				System.out.println("Ha sido elegido como Senador de Naboo, pague $50 al otro jugador");
				cuentaJugador2 -= 50;
				cuentaJugador1 += 50;
				break;
			case 15:
				System.out.println(
						"PUEDES SALIR DE LA CÁRCEL con ayuda de los rebeldes, guardarse esta tarjeta hasta que se necesite");
				cartaSalirPrisionJ2 = true;
				break;
			}
		}
	}

	// Bienvenida al juego/escoger personajes
	public static void Inicio() {
		int caliz1, caliz2;
		String[] personajes = { "Luke", "R2D2", "Leia", "Chewbacca", "Han Solo", "Darth Vader" };

		// Bienvenida
		ImprimirLogo();
		System.out.println(
				"\t\t    Bienvenidos a Monopoly Star Wars!\nLas reglas son sencillas, juega estrategicamente para ganar la mayor cantidad de dinero,\nel primero que quede en bancarrota pierde.");
		System.out.print("\nPresione una tecla y enter para continuar.");
		adelante = reader.next();

		System.out.println("\tEscojan sus personajes.");
		System.out.println("Lista de personajes:");
		for (int i = 0; i < personajes.length; i++) {
			System.out.println((i + 1) + ". " + personajes[i]); // Mostrar personajes
		}

		// Jugador 1 escoge
		System.out.print("Jugador 1, escoja su personaje: ");
		while (!band) {
			try {
				numPersonaje = reader.nextInt();
				if ((numPersonaje < 1) || (numPersonaje > 6)) {
					System.out.print("Favor de solo ingresar un numero del 1 - 6: ");
				} else {
					band = true;
				}
			} catch (Exception e) {
				System.out.print("Favor de solo ingresar un numero del 1 - 6: ");
				reader.next();
			}
		}
		band = false;
		jugador1 = personajes[numPersonaje - 1];
		personajeEscogido = numPersonaje;
		personajes[numPersonaje - 1] = "Escogido";

		System.out.println();

		for (int i = 0; i < personajes.length; i++) {
			System.out.println((i + 1) + ". " + personajes[i]); // Mostrar personajes
		}

		// Jugador 2 escoge
		System.out.print("Jugador 2, escoja su personaje: ");
		while (!band) {
			while (!band) {
				try {
					numPersonaje = reader.nextInt();
					if ((numPersonaje < 1) || (numPersonaje > 6)) {
						System.out.print("Favor de solo ingresar un numero del 1 - 6: ");
					} else {
						band = true;
					}
				} catch (Exception e) {
					System.out.print("Favor de solo ingresar un numero del 1 - 6: ");
					reader.next();
				}
			}
			band = false;
			if (numPersonaje != personajeEscogido) {
				band = true;
			} else {
				System.out.print("Ese personaje ya está escogido.\nEscoja otro personaje: ");
			}
		}
		band = false;
		jugador2 = personajes[numPersonaje - 1];

		System.out.println("\nJugador 1: " + jugador1);
		System.out.println("Jugador 2: " + jugador2);
		System.out.println("Se han añadido $1500 Wupiupis a cada una de las cuentas.");
		cuentaJugador1 += 1500;
		cuentaJugador2 += 1500;

		// ¿Quién comienza?
		System.out.println("\nTiren un dado para ver quien comienza.");
		while (!band) {
			// Jugador 1
			System.out.print("\n" + jugador1 + ", presione una tecla y 'Enter' para tirar el dado: ");
			adelante = reader.next();
			caliz1 = Dado();
			System.out.println("Ha obtenido: " + caliz1);
			// Jugador 2
			System.out.print("\n" + jugador2 + ", presione una tecla y 'Enter' para tirar el dado: ");
			adelante = reader.next();
			caliz2 = Dado();
			System.out.println("Ha obtenido: " + caliz2);
			// Checar
			System.out.println();
			if (caliz1 > caliz2) {
				System.out.println(jugador1 + " (Jugador 1) comienza");
				turnoPersonaje1 = true;
				band = true;
			} else if (caliz1 < caliz2) {
				System.out.println(jugador2 + " (Jugador 2) comienza");
				turnoPersonaje2 = true;
				band = true;
			} else if (caliz1 == caliz2) {
				System.out.println("Los números han salido iguales, favor de tirar de nuevo.");
			}
		}
		band = false;
		juego = true;
	}
	
	public static void ChecarSiEnBancarrota(int jugador) {
		if (jugador == 1) {
			if (cuentaJugador1 < 0) {
				Fin();
				System.out.println("El jugador 1 ha quedado en bancarrota.\nGANA " + jugador2 + " (JUGADOR 2)");
				juego = false;
			}
		} else if (jugador == 2) {
			if (cuentaJugador2 < 0) {
				Fin();
				System.out.println("El jugador 2 ha quedado en bancarrota.\nGANA " + jugador2 + " (JUGADOR 2)");
				juego = false;
			}
		}
	}

	public static void ImprimirLogo() {
		System.out.println("                  ________________.  ___     .______  \n"
				+ "                 /                | /   \\    |   _  \\\n"
				+ "                |   (-----|  |----`/  ^  \\   |  |_)  |\n"
				+ "                 \\   \\    |  |    /  /_\\  \\  |      /\n"
				+ "            .-----)   |   |  |   /  _____  \\ |  |\\  \\-------.\n"
				+ "            |________/    |__|  /__/     \\__\\| _| `.________|\n"
				+ "             ____    __    ____  ___     .______    ________.\n"
				+ "             \\   \\  /  \\  /   / /   \\    |   _  \\  /        |\n"
				+ "              \\   \\/    \\/   / /  ^  \\   |  |_)  ||   (-----`\n"
				+ "               \\            / /  /_\\  \\  |      /  \\   \\\n"
				+ "                \\    /\\    / /  _____  \\ |  |\\  \\---)   |\n"
				+ "                 \\__/  \\__/ /__/     \\__\\|__| `._______/\n" + "");
	}

	public static void ASCIICambioDeTurno() {
		System.out.println("        .                            .                      .         \n"
				+ ".                  .             -)------+====+       .               \n"
				+ "                         -)----====    ,'   ,'   .                 .  \n"
				+ "            .                  `.  `.,;___,'                .         \n"
				+ "                                 `, |____l_\\                          \n"
				+ "                  _,.....------c==]\"\"______ |,,,,,,.....____ _        \n"
				+ "  .      .       \"-:______________  |____l_|]'''''''''''       .     .\n"
				+ "                                ,'\"\",'.   `.                          \n"
				+ "       .                 -)-----====   `.   `.                     \n"
				+ "                   .            -)-------+====+       .            .  \n"
				+ "           .                               .                         ");
	}
	
	public static void Fin() {
		System.out.println("                                                       _._        *\r\n" + 
				"                                       _______..........-`-'-..__  /\r\n" + 
				"                                 ...###/   \\        \\         ____\\/\r\n" + 
				"                           ...########/     \\  ___...\\--     / _   \\\r\n" + 
				"                 __..---#############/_..---'''     ========/ //  __\\___\r\n" + 
				"         __..--''  /     /  / --..__  ```-------________________//      =\r\n" + 
				"   __--''       /      /   /________=        \\                 //_______=\r\n" + 
				"  `-.._____  /       /    /             ___   \\               ______/__\r\n" + 
				"           `````-----------------------////----\\----------'''' ______//  LS\r\n" + 
				"                                               /_____.....-----");
	}
}
