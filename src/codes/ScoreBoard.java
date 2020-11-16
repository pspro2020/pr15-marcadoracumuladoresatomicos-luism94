package codes;

import java.util.concurrent.atomic.LongAdder;

public class ScoreBoard {
	//Clase Marcador que contiene los resultados de las tiradas de dado de los hilos secundarios
	
	//Variables contador de cada cara del dado
	//Las variabler LongAdder tienen de valor inicial 0
	private LongAdder oneThrows = new LongAdder();
	private LongAdder twoThrows = new LongAdder();
	private LongAdder threeThrows = new LongAdder();
	private LongAdder fourThrows = new LongAdder();
	private LongAdder fiveThrows = new LongAdder();
	private LongAdder sixThrows = new LongAdder();

	//Metodos get de cada contador
	private int numberOneScore() {
		return oneThrows.intValue();
	}
	private int numberTwoScore() {
		return twoThrows.intValue();
	}
	private int numberThreeScore() {
		return threeThrows.intValue();
	}
	private int numberFourScore() {
		return fourThrows.intValue();
	}
	private int numberFiveScore() {
		return fiveThrows.intValue();
	}
	private int numberSixScore() {
		return sixThrows.intValue();
	}
	
	/* Metodo que se encarga de añadir una tirada mas al contador del valor recibido del dado
	** Las variables AtomicLong se encargan de leer el valor previo e incrementarlo de forma atomica
	** independientemente de cuantos hilos quieran acceder a la misma variable
	*/
	void updateScores(int throwScore) {
		switch (throwScore) {
		case 1:
			oneThrows.increment();
			break;
		case 2:
			twoThrows.increment();
			break;
		case 3:
			threeThrows.increment();
			break;
		case 4:
			fourThrows.increment();
			break;
		case 5:
			fiveThrows.increment();
			break;
		case 6:
			sixThrows.increment();
			break;
		}
	}
	
	//Metodo que muestra el resultado de la ejecucion de todos los hilos mostrando el valor de cada contador
	public void showNumberThrows() {
		System.out.println(Messages.ANNOUNCE_SCORES);
		System.out.println(String.format(Messages.NUMBER_1_SCORE, numberOneScore()));
		System.out.println(String.format(Messages.NUMBER_2_SCORE, numberTwoScore()));
		System.out.println(String.format(Messages.NUMBER_3_SCORE, numberThreeScore()));
		System.out.println(String.format(Messages.NUMBER_4_SCORE, numberFourScore()));
		System.out.println(String.format(Messages.NUMBER_5_SCORE, numberFiveScore()));
		System.out.println(String.format(Messages.NUMBER_6_SCORE, numberSixScore()));
		
		System.out.println(String.format(Messages.TOTAL_THROWS, numberOneScore(), numberTwoScore(),
				numberThreeScore(), numberFourScore(), numberFiveScore(), numberSixScore(),
				numberOneScore() + numberTwoScore() + numberThreeScore() 
				+ numberFourScore() + numberFiveScore() + numberSixScore()));
	}
}
