package codes;

import java.util.Random;

public class Die {
	//Clase Dado que solo contiene un metodo para devolver el valor de una de sus caras de forma aleatoria
	
	public int throwDie() {
		//Metodo de la clase dado que devuelve un valor aleatorio entre 1 y 6
		return new Random().nextInt(6) + 1;
	}
}
