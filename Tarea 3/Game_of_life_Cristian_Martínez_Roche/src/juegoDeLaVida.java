
public class juegoDeLaVida {

	public static void main(String[] args) {
		
		final int FILAS = 7;
		final int COLUMNAS = 7;
		
		System.out.println("---- GAME OF LIFE ----");

		int [][] tablero = new int[FILAS][COLUMNAS];
	
		 while(true) {
		Metodos_juegoVida.dibujarTablero(tablero);
		tablero [2][3] = 1;
		tablero [2][4] = 1;
		tablero [3][4] = 1;
		tablero [3][6] = 1;
		tablero [5][0] = 1;
		tablero [5][1] = 1;
		tablero [5][2] = 1;
		tablero [4][1] = 1;
		tablero = Metodos_juegoVida.siguienteTablero(tablero);
		 }
		
	}
}

