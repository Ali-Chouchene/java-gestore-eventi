package org.java.concert;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;

import org.java.events.Evento;

public class Concerto extends Evento {
	private String ora;
	private String prezzo;
	DecimalFormat df = new DecimalFormat("###.## €");

	public Concerto(String titolo, String data, int postiTotali, int postiPrenotati, String ora, String prezzo)
			throws Exception {
		super(titolo, data, postiTotali, postiPrenotati);
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return LocalTime.parse(ora);

	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getPrezzo() {
		return df.format(new BigDecimal(prezzo));

	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {

		return "Data: " + getData().toString() + " Ora: " + getOra() + "  -  " + getTitolo() + "  -  "
				+ " Prezzo singolo: " + getPrezzo();
	}

}
