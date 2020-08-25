package ulead.ac.cr.clients;

public class Clients {
	protected double HoldTime;
	protected double SellTime;
	protected int done;
	protected int cont;
	protected int Time;

	public Clients() {
		done = 0;
		HoldTime = 0;
		SellTime = 0;
		cont = 0;
	}

	protected int TimeByPerson() {
		double persona = Math.random();

		if (persona >= 0 && persona <= 0.30) {
			Time += 1;
			return 1;
		} else if (persona >= 0.20 && persona <= 0.4) {
			Time += 2;
			return 2;
		} else if (persona >= 0.4 && persona <= 0.6) {
			Time += 3;
			return 3;
		} else if (persona >= 0.6 && persona <= 0.8) {
			Time += 5;
			return 5;
		} else if (persona >= 0.8 && persona <= 0.9) {
			Time += 8;
			return 8;
		} else if (persona >= 0.9 && persona <= 0.95) {
			Time += 13;
			return 13;
		}
		int paso = (int) (13 + (13 * Math.random()));
		Time += paso;
		return paso;
	}

}
