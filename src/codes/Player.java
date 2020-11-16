package codes;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Player implements Runnable {
	//Clase Jugador que representa el hilo secundario que lanza el dado
	
	//Constante que determina la cantidad de tiradas totales
	private static final int NUM_OF_THROWS = 10000;
	//Objeto Dado asociado al hilo
	private Die die;
	//Objeto Marcador asociado a las tiradas de dado del hilo actual
	private ScoreBoard scores;
	
	//Metodo constructor de la clase Tarea que recibe un objeto Dado y un objeto Marcador por parametro
	public Player(Die die, ScoreBoard scores) {
		this.die = die;
		this.scores = scores;
	}
	
	//Metodo implementado de la Interfaz Runnable y sobreescrito por la clase Tarea para que el hilo
	//realice el bloque de codigo que se escriba dentro cuando sea iniciado por el hilo principal
	@Override
	public void run() {
		int number = 0;
		for (int i = 0; i < NUM_OF_THROWS; i++) {
			try {
				number = die.throwDie();
				//Se actualiza la tirada del valor que retorna el dado
				scores.updateScores(number);
				System.out.println(String.format(Messages.THROWING_DIE, LocalDateTime.now().format(Messages.TIME_FORMATTER), Thread.currentThread().getName(), number));
				//El hilo queda en espera despues de tirar el dado
				TimeUnit.MICROSECONDS.sleep(100);	
			} catch (InterruptedException e) {
				System.out.printf(Messages.THREAD_EXCEPTION, LocalDateTime.now().format(Messages.TIME_FORMATTER), Thread.currentThread().getName(), e.getMessage());
				return;
			}
		}
	}

}
