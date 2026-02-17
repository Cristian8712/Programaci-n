package pipati;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	int min = 0;
	int max = 2;
	int jug1 = 0;
	int jug2 = 0;
	int resultadoFinal = 0;
	jug1 = Metodos.jugadaValida(entrada);
	System.out.println("Escoges " + Metodos.muestraJugada(jug1));
	jug2 = Metodos.numAleatorio(max, min);
	System.out.println("El ordenador elige " + Metodos.muestraJugada(jug2));
	resultadoFinal = Metodos.quienGana(jug1, jug2);
	if (resultadoFinal == 0) {
		System.out.println("EMPATE");
	}
	else if (resultadoFinal == 1) {
		System.out.println("GANASTE");
	}
	else {
		System.out.println("PIERDES");
	}
	}

}
