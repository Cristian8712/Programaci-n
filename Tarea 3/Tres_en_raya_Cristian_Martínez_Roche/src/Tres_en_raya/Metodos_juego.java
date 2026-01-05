package Tres_en_raya;

import java.util.Scanner;

public class Metodos_juego {
//Uso de referencia el programa del tablero de la tarea anterior y lo modifico para el uso del juego//	
	public static char SUP_IZDA = '\u250C';
	public static char SUP_DCHA = '\u2510' ;
	public static char INF_DCHA = '\u2518';
	public static char INF_IZDA = '\u2514';
	public static char VER_IZDA = '\u251C';
	public static char VER_DCHA = '\u2524';
	public static char HOR_ARR = '\u252C';
	public static char HOR_ABA = '\u2534';
	public static char VERT = '\u2502';
	public static char HORI = '\u2500';
	public static char CENTRO = '\u253C';

	public static void dibujarTablero(int[][] tablero) {
		
		int lado = 7;
		
		for (int i = 0; i < lado; i++) {
			if (i == 0) {
				for (int j = 0; j < lado ; j++) {
					if (j == 0) {
						System.out.print(SUP_IZDA);
					} else if (j == lado - 1) {
						System.out.print(SUP_DCHA);
					} else if ( j % 2 == 0) {
						System.out.print(HOR_ARR);
					}else {
						System.out.print(HORI);
					}
				}
			} else if (i == lado - 1) {
				for (int j = 0; j < lado ; j++) {
					if (j == 0) {
						System.out.print(INF_IZDA);
					} else if (j == lado - 1) {
						System.out.print(INF_DCHA);
					} else if ( j % 2 == 0){
						System.out.print(HOR_ABA);
					}else {
						System.out.print(HORI);
					}
				}
			} else if (i % 2 == 0) {
				for (int j = 0; j < lado ; j++) {
					if (j == 0) {
						System.out.print(VER_IZDA);
					} else if (j == lado - 1) {
						System.out.print(VER_DCHA);
					} else if ( (j % 2) == 0){
						System.out.print(CENTRO);
					}else {
						System.out.print(HORI);
					}
				}
			}else {
				for (int j = 0; j < lado; j++) {
					if (j % 2 == 0) {
						System.out.print(VERT);
					} else {
						int valor = tablero[i/2][j/2] ;
						
						if (valor == 1 ) {
							System.out.print("X");
						}else if (valor == 2) {
							System.out.print("0");
						}else {
							System.out.print(" ");		
					}
				}
			}
			
		}System.out.println();
	}
}

//Creo un método con el Scanner,el tablero y el número del jugador//

public static void pedirPosicion (Scanner entrada, int[][] tablero, int jugador) {
	boolean posicionValida =false;
	while (!posicionValida) {
	System.out.print("Introduce la posición deseada: ");
	int posicion =entrada.nextInt();
	int fila = -1;
	int columna = -1;
	switch (posicion) {
	case 1:
		fila = 0;
		columna = 0;
		break;
	case 2:
		fila = 0;
		columna = 1;
		break;
	case 3:
		fila = 0;
		columna = 2;
		break;
	case 4:
		fila = 1;
		columna = 0;
		break;
	case 5:
		fila = 1;
		columna = 1;
		break;
	case 6:
		fila = 1;
		columna = 2;
		break;
	case 7:
		fila = 2;
		columna = 0;
		break;
	case 8:
		fila = 2;
		columna = 1;
		break;
	case 9:
		fila = 2;
		columna = 2;
		break;

	default: System.out.print("Elección incorrecta");
		return;
		}
	if  (fila != -1) {
		if (tablero[fila][columna] == 0) {
		tablero[fila][columna] = jugador;
		posicionValida = true;
	}else {
		System.out.println("Esta casilla esta ocupada, introduzca otro");
		}
	}else {
		System.out.println("Número incorrecto, introduzca otro");
		}
	}
}

 public static int comprobarGanador(int[][]tablero) {
	 
	 for( int i =0; i < 3; i++) {
		 if(tablero[i][0] != 0 && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
			 return tablero[i][0];
		 }
	 }
	 for( int j =0; j < 3; j++) {
			 if(tablero[0][j] != 0 && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
				 return tablero[0][j];
			 }
	 	}
		 	if(tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
		 		return tablero[0][0];
			 
		 }	if(tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
			 	return tablero[0][2];
		}
		 return 0;
	}
		 
}




		
	




