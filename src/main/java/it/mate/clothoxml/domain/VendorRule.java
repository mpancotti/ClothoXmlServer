package it.mate.clothoxml.domain;

import java.util.ArrayList;
import java.util.Date;

public class VendorRule {
	private Integer id;
	private String regexp;
	private String strategy;
	private String valore_note_3;
	private Date scadenza;
	
	private ArrayList<Sconto> sconti;
	private ArrayList<Prezzo> prezzi;
	private ArrayList<Prezzofisso> prezzifissi;

	public VendorRule() {
		sconti = new ArrayList<Sconto>();
		prezzi = new ArrayList<Prezzo>();
		prezzifissi = new ArrayList<Prezzofisso>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegexp() {
		return regexp;
	}

	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getValore_note_3() {
		return valore_note_3;
	}

	public void setValore_note_3(String valore_note_3) {
		this.valore_note_3 = valore_note_3;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public ArrayList<Sconto> getSconti() {
		return sconti;
	}

	public void setSconti(ArrayList<Sconto> sconti) {
		this.sconti = sconti;
	}

	public ArrayList<Prezzo> getPrezzi() {
		return prezzi;
	}

	public void setPrezzi(ArrayList<Prezzo> prezzi) {
		this.prezzi = prezzi;
	}

	public ArrayList<Prezzofisso> getPrezzifissi() {
		return prezzifissi;
	}

	public void setPrezzifissi(ArrayList<Prezzofisso> prezzifissi) {
		this.prezzifissi = prezzifissi;
	}
	
	
}
