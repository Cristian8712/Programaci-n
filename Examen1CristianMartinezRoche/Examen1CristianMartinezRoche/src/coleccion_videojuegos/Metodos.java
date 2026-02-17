package coleccion_videojuegos;

import java.util.Scanner;

public class Metodos {

	public static String[] leerArrayConsolas(int numConsolas, Scanner entrada) {
		String listaConsolas[] = new String[numConsolas];
		for (int i = 0; i < listaConsolas.length; i++) {
			System.out.print("Introduce el nombre de la consola " + (i+1) + " : ");
			listaConsolas[i] = entrada.nextLine();
		}
		return listaConsolas;	
	}
	
	public static String[] leerArrayJuegos(int numJuegos, Scanner entrada) {
		String listaJuegos[] = new String[numJuegos];
		for (int i = 0; i < listaJuegos.length; i++) {
			System.out.print("Juego " + (i+1) + " : ");
			listaJuegos[i] = entrada.nextLine();
		}
		return listaJuegos;	
	}
	
	public static boolean [][] leerDisponibles (String[] listaConsolas,String[] listaJuegos,Scanner entrada){
		boolean listaDisponibles[][] = new boolean[listaConsolas.length][listaJuegos.length];
		for (int i = 0 ; i < listaConsolas.length; i++) { 
			for (int j = 0; j < listaJuegos.length; j++) {
			System.out.println("Disponible "+ listaJuegos[j] + " en " + listaConsolas[i] + " : ");
			String disponible = entrada.nextLine();
			
			char c = disponible.charAt(0);
			if (c == 's') {
				listaDisponibles[i][j] = true;
			}
			else {
				listaDisponibles[i][j] = false;
			}
			}
		
	}
		return listaDisponibles;
			
	}

	public static void mostrarConsolas(String[] listaConsolas) {
		System.out.println("Consolas: ");
		for (int i = 0 ; i < listaConsolas.length; i++) {
			String consola = listaConsolas[i];
			System.out.println("- " + consola);
		}
	}
	
	public static void mostrarJuegos(String[] listaJuegos) {
		System.out.println("Consolas: ");
		for (int i = 0 ; i < listaJuegos.length; i++) {
			String juego = listaJuegos[i];
			System.out.println("- " + juego);
		}
	}

	public static void mostrarDisponibilidad(boolean[][]listaDisponibles, String[] listaConsolas, String[] listaJuegos) {
		for (int i = 0; i < listaConsolas.length; i ++) {
			System.out.println("Juegos para " + listaConsolas[i]);
			for (int j = 0 ; j < listaJuegos.length; j++) {
				if (listaDisponibles[i][j] = true) {
					System.out.println("- " + listaJuegos[j]);
				}
			}
			
		}
		
	}
	
	
	

}
