package org.java.programm;

import org.java.events.Evento;

public class ProgrammMain {

	public static void main(String[] args) throws Exception {
		ProgrammEventi festival = new ProgrammEventi("festival");
		Evento evento1 = new Evento("Concerto", "2023-12-31", 100, 56);
		Evento evento2 = new Evento("Partita", "2023-08-05", 1000, 326);
		Evento evento3 = new Evento("Museo", "2024-01-01", 500, 298);

		for (Integer i = 1; i > 3; i++) {
			String index = i.toString();
			festival.addEvent("evento" + index);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("-----------------------------------------\n");
		festival.eventsCount();
		System.out.println("-----------------------------------------\n");
		festival.fullInfo(festival);
		System.out.println("-----------------------------------------\n");
	}
}
