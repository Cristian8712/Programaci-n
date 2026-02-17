package GameOfLife;

public class MetodosJuegoVida {
	
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
		
		int lado = 15;
		
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
						int estado = tablero[i/2][j/2] ;
						if (estado == 1 ) {
							System.out.print("1");
						}else {
						System.out.print("0");
						}	
				}
			}	
		}System.out.println();
	}
}

	public static int [][] siguienteTablero (int[][] tableroActual) {
		int filas = tableroActual.length;
		int columnas = tableroActual.length;
		
		int [][] nuevoTablero = new int[filas][columnas];
	
		for (int i = 0; i < filas; i++ ) {
			for (int j = 0; j < columnas; j++) {
				
				int vecinosVivos = contarVecinos(tableroActual, i, j);
				int estadoActual = tableroActual[i][j];
				
				if (estadoActual == 1) {
					if (vecinosVivos < 2 || vecinosVivos > 3) {
						nuevoTablero[i][j] = 0;
					}else {
						nuevoTablero[i][j] = 1;
						}
				}else {
					if (vecinosVivos == 3) {
						nuevoTablero[i][j] = 1;
					}else {
						nuevoTablero[i][j] = 0;
					}
				}						
			}
		}
		return nuevoTablero;
	}	
	public static int contarVecinos (int[][] tablero, int fila, int columna) {
			int cuenta = 0;
			int maxFilas = tablero.length;
			int maxColumnas = tablero.length;
			
			 for (int i = fila - 1; i <= fila + 1; i++) {
				 for ( int j = columna - 1; j <= columna + 1; j++) {
					 if (i >= 0 && i < maxFilas && j >= 0 && j < maxColumnas) {
						 if (!(i==fila && j == columna)) {
							 cuenta += tablero[i][j];
						 }
					 }
				 }
			 }
			return cuenta;	
	}	
}
