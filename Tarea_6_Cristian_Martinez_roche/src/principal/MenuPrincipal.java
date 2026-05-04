package principal;

import java.sql.Connection;
import java.util.Scanner;
import controlador.ConexionBD;
import controlador.GestionDatos;
import controlador.Metodos;

public class MenuPrincipal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("===== BIENVENIDO AL SISTEMA DE GESTIÓN =====");
		ConexionBD adminConexion = new ConexionBD();
		Connection conectar = adminConexion.conectar();

		System.out.println("---------------------------------------------");
		System.out.println("==== SISTEMA DE GESTION DE MANTENIMIENTO ====");
		System.out.println("---------------------------------------------");

		GestionDatos adminDatos = new GestionDatos(conectar);
		boolean salir = false;
		while (!salir) {

			System.out.println("============== MENÚ PRINCIPAL ==============\n" + "\n" + "1. Gestión de plantilla.\n"
					+ "\n" + "2. Informes de máquinas e intervenciones.\n" + "\n" + "3. Gestión de recambios.\n" + "\n"
					+ "4. Apagar sistema.\n" + "\n" + "Seleccione una opción:");

			int opcion = -1;
			try {
				opcion = Integer.parseInt(entrada.nextLine());
			} catch (Exception e){
				System.out.println("Error: Por favor introduzca un número válido.");
			}

			switch (opcion) {
			case 1:
				Metodos.menuTecnicos(adminDatos, entrada);
				break;
			case 2:
				Metodos.menuInformes(adminDatos, entrada);
				break;
			case 3:
				Metodos.menuRecambios(adminDatos, entrada);
				break;
			case 4:
				salir = true;
				break;

			default:
				System.out.println("Elección no válida, introduzca opción válida.");
				break;
			}

		}
		System.out.println("---------------------------------------------");
		System.out.println("============= CERRANDO SISTEMA =============");
		System.out.println("---------------------------------------------");
		entrada.close();
		adminConexion.desconectar();
		System.out.println("============ SISTEMA FINALIZADO ============");
	}
}
