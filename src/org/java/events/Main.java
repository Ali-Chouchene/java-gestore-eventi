package org.java.events;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		boolean done = true;
		Evento evento1 = null;
		while (done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Ciao vuoi inserire un nuovo evento?");
			System.out.println("1 - Si");
			System.out.println("2 - No");
			int option1 = input.nextInt();
			if (option1 < 1 || option1 > 2) {

				System.err.println("Scelta non trovata");

				continue;
			}

			switch (option1) {
			case 1: {
				System.out.println("Titolo ?");
				String titolo = input.next();
				System.out.println("Data (aaaa-mm-gg) ?");
				String data = input.next();
				System.out.println("numero di posti in totale ?");
				int postiTotali = input.nextInt();
				System.out.println("numero di posti gia prenotati ?");
				int postiPrenotati = input.nextInt();
				try {
					evento1 = new Evento(titolo, data, postiTotali, postiPrenotati);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Ora che hai creato l'evento vuoi effettuare delle prenotazioni?");
				System.out.println("1 - Si");
				System.out.println("2 - No");
				int option2 = input.nextInt();
				if (option2 < 1 || option2 > 2) {

					System.err.println("Scelta non trovata");

					continue;
				}
				switch (option2) {
				case 1: {
					System.out.println("Quanti posti vuoi prenotare ?");
					int postiP = input.nextInt();
					if (postiP > 0) {
						try {
							evento1.prenota(postiP);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					System.out.println("Prenotazione effettuata con successo, hai prenotato:  " + postiP);
					System.out.println("Per l'evento " + evento1.toString() + ", ci sono altri "
							+ (evento1.getPostiTotali() - evento1.getPostiPrenotati()) + " posti disponibili, e "
							+ evento1.getPostiPrenotati() + " posti prenotati.");
					System.out.println("Vuoi disdire qualche prenotazione?");
					System.out.println("1 - Si");
					System.out.println("2 - No");
					int option3 = input.nextInt();
					if (option3 < 1 || option3 > 2) {

						System.err.println("Scelta non trovata");

						continue;
					}
					switch (option3) {
					case 1: {
						System.out.println("Quanti prenotazioni vuoi disdire ?");
						int postiD = input.nextInt();
						if (postiD > 0 && postiD <= postiP) {
							try {
								evento1.disdisci(postiD);

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						System.out.println("Hai disdetto con successo " + postiD + " prenotazioni");
						System.out.println("Per l'evento " + evento1.toString() + ", ci sono altri "
								+ (evento1.getPostiTotali() - evento1.getPostiPrenotati()) + " posti disponibili, e "
								+ evento1.getPostiPrenotati() + " posti prenotati.");
					}
						break;
					case 2: {
						done = false;
						System.out.println("Ok nessun problema, alla prossima!");
						input.close();

					}
					}

				}

				}
			}
			case 2: {
				done = false;
				System.out.println("Ok nessun problema, alla prossima!");
				input.close();
			}
			}
			input.close();
		}
	}

}
