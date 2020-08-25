package ulead.ac.cr.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
import ulead.ac.cr.queue.QueueNP;

public class Logic extends QueueNP {

	public void setMostrador(int NCajas) {
		super.Casher = new int[NCajas];
	}

	public void Data() {
		double personas = 0;

		try {
			Scanner lector = new Scanner(new File("src/simulacion.txt"));
			while (lector.hasNextLine()) {
				String[] datos = lector.nextLine().split(",");
				personas += Integer.parseInt(datos[0]) + Integer.parseInt(datos[1]);
				super.PriorityQueue(Integer.parseInt(datos[1]), 0, Integer.parseInt(datos[1]) == 0 ? true : false);
				super.SingleQueue(Integer.parseInt(datos[0]), 1, Integer.parseInt(datos[0]) == 0 ? true : false);
			}
			lector.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println("Personas que si pasaron a hacer el tramites : " + peopledone);
		System.out.println(("El promedio de tiempo de esperar en la cola es : " + LocalTime.MIN.plus(Duration.ofMinutes(
				(long) (Math.round(((super.HoldTime) / (double) peopledone) * Math.pow(10, 2)) / Math.pow(10, 2))))
				.toString() + " Horas"));
		System.out.println("Promedio de tramites : " + (int) (Time / peopledone) + " Minutos");
		super.QuequeN.stream().forEach(S -> TimeAcum += S);
		super.QuequeP.stream().forEach(S -> TimeAcum += S);
		System.out.println(("Personas que no pasaron : " + (int) (personas - peopledone)
				+ " y su tiempo de espera fue: "
				+ LocalTime.MIN.plus(
						Duration.ofMinutes((long) (Math.round(((TimeAcum) / (int) (personas - peopledone)) * Math.pow(10, 2))
								/ Math.pow(10, 2))))
						.toString()
				+ " Horas"));

		System.out.println();
		System.out.println();
	}
}
