package Tablero_Peticion;

import java.util.Scanner;

public class Tablero_peticion {
	
	public static char SUP_IZDA = '\u250c';
	public static char SUP_DCHA = '\u2510' ;
	public static char INF_DCHA = '\u2518';
	public static char INF_IZDA = '\u2514';
	public static char VER_IZDA = '\u251c';
	public static char VER_DCHA = '\u2524';
	public static char HOR_ARR = '\u252c';
	public static char HOR_ABA = '\u2534';
	public static char VERT = '\u2502';
	public static char HORI = '\u2500';
	public static char CENTRO = '\u253c';

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce el tamaño del tablero: ");
		
		int tam = entrada.nextInt();
		int lado = tam * 2 + 1;
		
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
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
		entrada.close();
	}

}