package TresEnRaya;

import java.util.Scanner;

public class JuegoTresEnRaya {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		boolean jugarDeNuevo =true;
		System.out.println("---- JUEGO DEL TRES EN RAYA ----");
		
		while (jugarDeNuevo) {
			int [][] tablero = new int[3][3];
			int turno = 1;
			int ganador= 0;
			int fichasPuestas = 0;
			boolean partidaTerminada = false;
			
		while (!partidaTerminada) {
			MetodosJuego.dibujarTablero(tablero);
			MetodosJuego.pedirPosicion(entrada, tablero, turno);
			fichasPuestas++;
			ganador=MetodosJuego.comprobarGanador(tablero);
			
			if (ganador!=0) {
				MetodosJuego.dibujarTablero(tablero);
				System.out.println("Enhorabuena, el ganador ha sido el jugador número " + ganador);
				partidaTerminada = true;
			}
			else if (fichasPuestas == 9) {
				MetodosJuego.dibujarTablero(tablero);
				System.out.println("La partida ha terminado en empate");
				partidaTerminada = true;				
			}
			else {
			
				turno = (turno == 1) ? 2 : 1;	
			}
			
		}
		
		System.out.println("¿Quieres jugar de nuevo? (Si/No): ");
		String respuesta = entrada.next();
		if (!respuesta.equalsIgnoreCase("Si")) {
			jugarDeNuevo = false;
		}
	}
		System.out.println("Gracias por jugar, adios");
		entrada.close();
	}
	

}
