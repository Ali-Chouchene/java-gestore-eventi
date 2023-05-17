package org.java.concert;

import org.java.events.Evento;

public class ConcertoMain {

	public static void main(String[] args) throws Exception {
		Evento concerto1 = new Concerto("Travis Scott", "3023-12-31", 100, 0, "20:00", "150.50");
		System.out.println(concerto1.toString());

	}

}
