package it.mate.clothoxml.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class Vendor{
    private Integer codice;
    private String nome;
    private Strategy strategy;
	
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
	public void setStrategy(Strategy string) {
		this.strategy = string;
	}
	
    public static Vendor fromJsonToVendor(String json) {
        return new JSONDeserializer<Vendor>().use(null, Vendor.class).deserialize(json);
    }
    
    public static String toJsonArray(Collection<Vendor> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static Collection<Vendor> fromJsonArrayToVendors(String json) {
        return new JSONDeserializer<List<Vendor>>().use(null, ArrayList.class).use("values", Vendor.class).deserialize(json);
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((strategy == null) ? 0 : strategy.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (strategy != other.strategy)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Vendor [codice=" + codice + ", nome=" + nome + ", strategy="
				+ strategy + "]";
	}
	
	
    
    
}
