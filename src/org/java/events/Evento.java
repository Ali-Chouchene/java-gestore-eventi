package org.java.events;

import java.time.LocalDate;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	LocalDate today = LocalDate.now();

	public Evento(String titolo, String data, int postiTotali, int postiPrenotati) throws Exception {

		this.postiPrenotati = postiPrenotati;
		if (postiTotali < 0) {
			throw new Exception("I posti devono essere maggiori di 0");

		} else {
			this.postiTotali = postiTotali;
		}

		setTitolo(titolo);
		setData(data);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		if (titolo.length() < 0) {
			throw new Exception("Non hai inserito il titolo");

		} else {
			this.titolo = titolo;
		}
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(String data) throws Exception {
		LocalDate localDate = LocalDate.parse(data);
		if (localDate.isBefore(today)) {
			throw new Exception("Hai inserito una data inferiore ad oggi: " + today.toString());
		} else {
			this.data = localDate;
		}
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public void prenota(int prenotazioni) throws Exception {
		if (this.data.isBefore(today)) {
			throw new Exception("La data dell'evento era: " + getData().toString());
		} else if (getPostiPrenotati() >= getPostiTotali()) {
			throw new Exception("Non ci sono piu posti disponibili per questo evento.");
		}
		if ((getPostiPrenotati() + prenotazioni) > getPostiTotali()) {
			throw new Exception("I posti disponibili sono: " + (getPostiTotali() - getPostiPrenotati()));
		} else {
			this.postiPrenotati += prenotazioni;
		}
	}

	public void disdisci(int annulaP) throws Exception {
		if (this.data.isBefore(today)) {
			throw new Exception("La data dell'evento era: " + getData().toString());
		} else if (getPostiPrenotati() == 0) {
			throw new Exception("Non ci sono posti prenotati per questo evento.");
		}
		if ((getPostiPrenotati() - annulaP) < 0) {
			throw new Exception("Non puoi disdire piu di: " + getPostiPrenotati() + "prenotazioni.");
		} else {
			this.postiPrenotati -= annulaP;
		}
	}

	@Override
	public String toString() {

		return getData().toString() + "  -  " + getTitolo();
	}
}
