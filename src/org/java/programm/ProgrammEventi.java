package org.java.programm;

import java.util.List;

import org.java.events.Evento;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	private List<Evento> eventiFiltrati;

	public ProgrammEventi(String titolo) {
		setTitolo(titolo);
		setEventi(eventi);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void addEvent(Object object) {
		eventi.add((Evento) object);
	}

	public void dateFilter(String anno) {
		for (Evento val : eventi) {
			if (val.getData().toString().contains(anno)) {
				eventiFiltrati.add(val);
			}
		}
		System.out.println(eventiFiltrati);
	}

	public void eventsCount() {
		int size = eventi.size();
		System.out.println("Sono presenti: " + size + "eventi");
	}

	public void eventsClean() {
		for (Evento val : eventi) {
			eventi.remove(val);
		}
		System.out.println("hai cancellato con successo tutti gli eventi" + " eventi:  " + eventi.size());
	}

	public void fullInfo(ProgrammEventi prog) {
		System.out.println("Programma: " + prog.getTitolo());
		for (Evento val : eventi) {
			System.out.println(val.getData() + " - " + val.getTitolo());
		}
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}

}
