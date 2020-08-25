package ulead.ac.cr.main;

import ulead.ac.cr.logic.Logic;

public class Main {

	public static void main(String[] args) {
		System.out.println("****************Bienvenido************");
		for (int i = 3; i < 9; i++) {
			Logic S = new Logic();
			S.setMostrador(i);
			System.out.println("Simulacion con: " + (i)+" cajeros disponibles ");
			S.Data();
		}

	}

}
