package controlador;

import java.util.Scanner;

public class Metodos {

	public static void menuTecnicos(GestionDatos adminDatos, Scanner entrada) {
		boolean volver = false;

		while (!volver) {
			System.out.println("=============== MENÚ TÉCNICOS ===============\n" + "\n" + "1. Lista de técnicos.\n"
					+ "\n" + "2. Alta nuevo técnico.\n" + "\n" + "3. Ascenso de técnico.\n" + "\n"
					+ "4. Despedir técnico.\n" + "\n" + "5. Volver al  menú principal.\n" + "\n"
					+ "Seleccione una opción:");

			int opcion = -1;
			try {
				opcion = Integer.parseInt(entrada.nextLine());
			} catch (Exception e) {
				System.out.println("Error: Por favor introduzca un número válido.");
			}
			switch (opcion) {
			case 1:
				System.out.println("------- LISTADO DE TÉCNICOS -------");
				adminDatos.verEmpleados();
				break;
			case 2:
				System.out.println("------- ALTA NUEVO TÉCNICO -------");

				System.out.print("Nombre del técnico: ");
				String nombre = entrada.nextLine();

				System.out.print("Nº de Empleado (Numérico único): ");
				int numEmpleado = Integer.parseInt(entrada.nextLine());

				System.out.print("Domicilio ==> Calle: ");
				String calle = entrada.nextLine();

				System.out.print("Número de casa: ");
				int numCasa = Integer.parseInt(entrada.nextLine());

				System.out.print("Localidad: ");
				String localidad = entrada.nextLine();

				System.out.print("Rango (Junior, Técnico, Supervisor, Jefe de planta): ");
				String rango = entrada.nextLine();

				System.out.print("Salario: ");
				double salario = Double.parseDouble(entrada.nextLine());

				adminDatos.insertarEmpleado(nombre, numEmpleado, calle, numCasa, localidad, rango, salario);

				break;
			case 3:
				System.out.println("------- ASCENSO DE TÉCNICO -------");
				System.out.print("Introduzca el Nº ID del técnico que desea ascender: ");
				String nombreAscenso = adminDatos.consultaNombre(entrada.nextInt());
				entrada.nextLine();
				System.out.print("¿Confirma que desea ascender a " + nombreAscenso + " ?");
				String ascender = entrada.nextLine().toLowerCase();
				if (ascender.equals("s")) {
					String rangoActual = adminDatos.consultaRango(nombreAscenso);
					if (rangoActual == null) {
						System.out.println("Error en la búsqueda del técnico.");
					} else {
						String nuevoRango = "";
						switch (rangoActual.toLowerCase()) {
						case "junior":
							nuevoRango = "Técnico";
							System.out.println("El empleado " + nombreAscenso + " ha sido ascendido al puesto de "
									+ nuevoRango + " con 15% de incremento salarial.");
							break;
						case "tecnico":
							nuevoRango = "Supervisor";
							System.out.println("El empleado " + nombreAscenso + " ha sido ascendido al puesto de "
									+ nuevoRango + " con 15% de incremento salarial.");
							break;
						case "supervisor":
							nuevoRango = "Jefe de planta";
							System.out.println("El empleado " + nombreAscenso + " ha sido ascendido al puesto de "
									+ nuevoRango + " con 15% de incremento salarial.");
							break;

						case "jefe de planta":
							System.out.println(
									"-> El empleado ya tiene el rango máximo (Jefe de planta). No puede ascender más.");
							break;
						default:
							System.out.println("Rango no detectado, contacte con RRHH.");
							break;
						}

					}

				} else {
					System.out.println("==> Ascenso cancelado.");

				}

				break;
			case 4:
				System.out.println("------- DESPEDIR TÉCNICO -------");
				System.out.print("Introduzca el Nº ID del técnico a despedir: ");
				String nombreDespedido = adminDatos.consultaNombre(entrada.nextInt());
				entrada.nextLine();
				System.out.print("¿Confirma que desea despedir a " + nombreDespedido + " ?");
				String confirmar = entrada.nextLine().toLowerCase();
				if (confirmar.equals("s")) {
					adminDatos.eliminarEmpleado(nombreDespedido);
					System.out.println("==> Despido de " + nombreDespedido + " confirmado.");
				} else {
					System.out.println("==> Despido cancelado.");
				}
				break;
			case 5:
				volver = true;

				break;

			default:
				break;
			}
		}
	}

	public static void menuInformes(GestionDatos adminDatos, Scanner entrada) {
		boolean volver = false;

		while (!volver) {
			System.out.println("==== INFORMES MÁQUINAS E INTERVENCIONES ====\n" + "\n" + "1. Lista de máquinas.\n"
					+ "\n" + "2. Añadir máquina.\n" + "\n" + "3. Listas de intervenciones.\n" + "\n"
					+ "4. Costes globales por máquina.\n" + "\n" + "5. Volver al  menú principal.\n" + "\n"
					+ "Seleccione una opción:");

			int opcion = -1;
			try {
				opcion = Integer.parseInt(entrada.nextLine());
			} catch (Exception e) {
				System.out.println("Error: Por favor introduzca un número válido.");
			}
			switch (opcion) {
			case 1:
				System.out.println("------- LISTADO DE MÁQUINAS -------");
				adminDatos.verMaquinas();
				break;
			case 2:
				System.out.println("------- ALTA NUEVA MÁQUINA -------");

				System.out.print("Nombre de la máquina: ");
				String nombre = entrada.nextLine();

				System.out.print("Tipo de máquina: ");
				String tipo = entrada.nextLine();

				System.out.print("Modelo de máquina: ");
				String modelo = entrada.nextLine();

				System.out.print("Número de serie: ");
				String numSerie = entrada.nextLine();

				System.out.print("Producción diaria estimada: ");
				int productoDia = Integer.parseInt(entrada.nextLine());

				System.out.print("Potencia: ");
				String potencia = entrada.nextLine();

				System.out.print("Planificación de tiempo de máquina en marcha: ");
				long tiempo_marcha = Long.parseLong(entrada.nextLine());

				adminDatos.insertarMaquina(nombre, tipo, modelo, numSerie, productoDia, potencia, tiempo_marcha);

				break;
			case 3:
				boolean atras = false;

				while (!atras) {
					System.out.println(
							"------- LISTA DE INTERVENCIONES -------" + "\n" + "1. Lista de intervenciones generales.\n"
									+ "\n" + "2. Lista de intervención por máquina.\n" + "\n"
									+ "3. Volver al  menú anterior.\n" + "\n" + "Seleccione una opción:");
					int eleccion = -1;
					try {
						eleccion = Integer.parseInt(entrada.nextLine());
					} catch (Exception e) {
						System.out.println("Error: Por favor introduzca un número válido.");
					}
					switch (eleccion) {

					case 1:
						adminDatos.intervencionesGeneral();
						break;

					case 2:
						System.out.print("Seleccione la máquina para analizar: ");

						try {
							int idMaquina = Integer.parseInt(entrada.nextLine());
							System.out.println("------- INTERVENCIONES MÁQUINA ID " + idMaquina + " -------");
							adminDatos.intervencionesMaquina(idMaquina);

						} catch (Exception e) {

							System.out.println("Error: Debes introducir un número de ID válido.");
						}

						break;

					case 3:
						atras = true;

						break;

					default:
						System.out.print("Elección no válida, introduzca opción válida.");
						break;
					}

				}
				break;

			case 4:
				boolean retorno = false;

				while (!retorno) {
					System.out.println("------- COSTES GLOBALES -------" + "\n" + "1. Costes generales.\n" + "\n"
							+ "2. Costes por máquina.\n" + "\n" + "3. Volver al anterior.\n" + "\n"
							+ "Seleccione una opción:");
					int eleccion = -1;
					try {
						eleccion = Integer.parseInt(entrada.nextLine());
					} catch (Exception e) {
						System.out.println("Error: Por favor introduzca un número válido.");
					}
					switch (eleccion) {
					case 1:
						adminDatos.costesGlobales();
						break;
					case 2:
						System.out.print("Seleccione la máquina para analizar: ");
						try {
							int idMaquina = Integer.parseInt(entrada.nextLine());
							System.out.println("--- COSTES DE REPUESTOS EN MÁQUINA ID " + idMaquina + " ---");
							adminDatos.costesMaquina(idMaquina);

						} catch (Exception e) {

							System.out.println("Error: Debes introducir un número de ID válido.");
						}

						break;

					case 3:
						retorno = true;

						break;

					default:
						System.out.print("Elección no válida, introduzca opción válida.");
						break;
					}

				}
				break;
			case 5:
				volver = true;

				break;

			default:
				System.out.println("Elección no válida, introduzca opción válida.");
				break;
			}
		}
	}

	public static void menuRecambios(GestionDatos adminDatos, Scanner entrada) {
		boolean volver = false;

		while (!volver) {
			System.out.println("==== GESTIÓN DE REPUESTOS Y MATERIALES ====" + "\n"
					+ "1. Consultas y listas de repuestos.\n"+ "\n" + "2. Añadir repuesto.\n"+ "\n"+ "3. Eliminar repuesto.\n" + "\n"
					+ "4. Informe de Stock.\n"+ "\n" + "5. Volver al menú principal.\n"+ "\n"
					+ "Seleccione una opción:");

			int opcion = -1;
			try {
				opcion = Integer.parseInt(entrada.nextLine());
			} catch (Exception e) {
				System.out.println("Error: Por favor introduzca un número válido.");
			}

			switch (opcion) {
			case 1:
				boolean atras = false;

				while (!atras) {
					System.out.println("------- LISTAS DE REPUESTOS -------" + "\n" + "1. Inventario total de repuestos.\n"+ "\n" 
							+ "2. Repuestos asociados a una máquina.\n"+ "\n" 
							+ "3. Repuestos más utilizados en intervenciones.\n" + "\n" + "4. Volver al menú anterior.\n" + "\n"
							+ "Seleccione una opción:");

					int eleccion = -1;
					try {
						eleccion = Integer.parseInt(entrada.nextLine());
					} catch (Exception e) {
						System.out.println("Error: Por favor introduzca un número válido.");
					}

					switch (eleccion) {
					case 1:
						System.out.println("--- INVENTARIO TOTAL DE REPUESTOS ---");
						adminDatos.verRepuestosTotal();
						break;

					case 2:
						System.out.print("Seleccione el ID de la máquina para ver sus recambios compatibles: ");
						try {
							int idMaquina = Integer.parseInt(entrada.nextLine());
							System.out.println("--- REPUESTOS DE LA MÁQUINA ID " + idMaquina + " ---");
							adminDatos.verRepuestosMaquina(idMaquina);

						} catch (Exception e) {
							System.out.println("Error: Debes introducir un número de ID válido.");
						}
						break;

					case 3:
						System.out.println("--- TOP REPUESTOS MÁS UTILIZADOS ---");
						adminDatos.verRepuestosMasUsados();
						break;

					case 4:
						atras = true;
						break;

					default:
						System.out.println("Elección no válida, introduzca opción válida.");
						break;
					}
				}
				break;

			case 2:
				System.out.println("\n------- ALTA DE NUEVO REPUESTO -------");
				try {
					System.out.print("Número de referencia (Ej. REF-001): ");
					String ref = entrada.nextLine();

					System.out.print("Nombre del repuesto: ");
					String nombre = entrada.nextLine();

					System.out.print("Modelo: ");
					String modelo = entrada.nextLine();

					System.out.print("Stock inicial (Cantidad): ");
					int stock = Integer.parseInt(entrada.nextLine());

					System.out.print("Precio unitario (€): ");
					double precio = Double.parseDouble(entrada.nextLine());

					System.out.print("Estantería (Ej. A1): ");
					String estanteria = entrada.nextLine();

					System.out.print("Pasillo (Ej. P1): ");
					String pasillo = entrada.nextLine();

					System.out.print("Gaveta (Ej. G-01): ");
					String gaveta = entrada.nextLine();

				
					adminDatos.insertarRepuesto(ref, nombre, modelo, stock, precio, estanteria, pasillo, gaveta);
					System.out.println("==> Repuesto registrado con éxito en el sistema.");

				} catch (NumberFormatException e) {
					System.out.println(
							"==> Error: Formato incorrecto. Recuerda que el stock y el precio deben ser valores numéricos.");
				}
				break;
			case 3:
				System.out.println("------- ELIMINAR REPUESTO -------");
				System.out.println("ATENCIÓN: Solo se pueden eliminar repuestos que NUNCA se hayan utilizado.");
				System.out.print("Introduzca el Nº de Referencia del repuesto a eliminar : ");
				String refEliminar = entrada.nextLine();
				
				adminDatos.eliminarRepuesto(refEliminar);
				break;

			case 4:
				System.out.println("\n------- INFORME DE STOCK CRÍTICO -------");
				System.out.println("Generando listado de repuestos que necesitan ser repuestos...");
				adminDatos.informeStock();
				break;

			case 5:
				volver = true;
				break;

			default:
				System.out.println("Elección no válida, introduzca opción válida.");
				break;
			}
		}
	}
}
