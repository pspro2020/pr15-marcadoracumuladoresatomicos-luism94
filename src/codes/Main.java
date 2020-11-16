package codes;

import java.time.LocalDateTime;

public class Main {

	private static int NUM_OF_THREADS = 3;
	
	public static void main(String[] args) {
		// Array de hilos secundarios que contienen un unico dado y "tablero" de tiradas
		Thread[] playerArray = new Thread[NUM_OF_THREADS];
		ScoreBoard board = new ScoreBoard();
		Die die = new Die();

		for (int i = 0; i < NUM_OF_THREADS; i++) {
			playerArray[i] = new Thread(new Player(die, board), "Player " + i);
		}

		// Inicio los hilos
		for (int i = 0; i < NUM_OF_THREADS; i++) {
			playerArray[i].start();
		}

		try {
			// El hilo principal espera la finalizacion de cada hilo secundario
			for (int i = 0; i < NUM_OF_THREADS; i++) {
				playerArray[i].join();
			}

			board.showNumberThrows();
		} catch (InterruptedException e) {
			// Innecesario porque el hilo principal no puede ser interrumpido
			System.out.println(String.format(Messages.THREAD_EXCEPTION, LocalDateTime.now().format(Messages.TIME_FORMATTER), Thread.currentThread().getName(),
					e.getMessage()));
		}
	}

}
