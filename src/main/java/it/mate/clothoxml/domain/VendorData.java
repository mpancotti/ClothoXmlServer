package it.mate.clothoxml.domain;

import java.util.ArrayList;
import java.util.List;

public class VendorData {
	
	private Integer codice;
    private String nome;
    private Strategy strategy;
    private List<Discount> discounts;
    private List<VendorRule> rules;
    
    public VendorData() {
		discounts = new ArrayList<Discount>();
		rules = new ArrayList<VendorRule>();
	}
    
    public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}


	public List<Discount> getDiscounts() {
		return discounts;
	}


	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}


	public List<VendorRule> getRules() {
		return rules;
	}


	public void setRules(List<VendorRule> rules) {
		this.rules = rules;
	}

}
