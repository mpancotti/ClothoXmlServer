package it.mate.clothoxml.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collection;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class Prezzo{
	private Integer id;
	private Integer id_rule_fk;
	private Float prezzo_from;
	private Float prezzo_to;
	private Float netto_lordo;
	private Float prezzoPrezzoNL;
	private Float prezzo_affiliato;
	private Float prezzo_affiliato_light;
	private Float prezzo_somministrato;
	private Date scadenza;
	private Date created_on;
	private String created_by;
	private Date updated_on;
	private String updated_by;
	private Integer version;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_rule_fk() {
		return id_rule_fk;
	}
	public void setId_rule_fk(Integer id_rule_fk) {
		this.id_rule_fk = id_rule_fk;
	}
	public Float getPrezzo_from() {
		return prezzo_from;
	}
	public void setPrezzo_from(Float prezzo_from) {
		this.prezzo_from = prezzo_from;
	}
	public Float getPrezzo_to() {
		return prezzo_to;
	}
	public void setPrezzo_to(Float prezzo_to) {
		this.prezzo_to = prezzo_to;
	}
	public Float getNetto_lordo() {
		return netto_lordo;
	}
	public void setNetto_lordo(Float netto_lordo) {
		this.netto_lordo = netto_lordo;
	}
	public Float getPrezzoPrezzoNL() {
		return prezzoPrezzoNL;
	}
	public void setPrezzoPrezzoNL(Float prezzoPrezzoNL) {
		this.prezzoPrezzoNL = prezzoPrezzoNL;
	}
	public Float getPrezzo_affiliato() {
		return prezzo_affiliato;
	}
	public void setPrezzo_affiliato(Float prezzo_affiliato) {
		this.prezzo_affiliato = prezzo_affiliato;
	}
	public Float getPrezzo_affiliato_light() {
		return prezzo_affiliato_light;
	}
	public void setPrezzo_affiliato_light(Float prezzo_affiliato_light) {
		this.prezzo_affiliato_light = prezzo_affiliato_light;
	}
	public Float getPrezzo_somministrato() {
		return prezzo_somministrato;
	}
	public void setPrezzo_somministrato(Float prezzo_somministrato) {
		this.prezzo_somministrato = prezzo_somministrato;
	}
	public Date getScadenza() {
		return scadenza;
	}
	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	 public static Prezzo fromJsonToPrezzo(String json) {
	        return new JSONDeserializer<Prezzo>().use(null, Prezzo.class).deserialize(json);
	    }
	    
	    public static String toJsonArray(Collection<Prezzo> collection) {
	        return new JSONSerializer().exclude("*.class").serialize(collection);
	    }
	    
	    public static Collection<Prezzo>fromJsonArrayToPrezzi(String json) {
	        return new JSONDeserializer<List<Prezzo>>().use(null, ArrayList.class).use("values", Prezzo.class).deserialize(json);
	    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result
				+ ((created_on == null) ? 0 : created_on.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_rule_fk == null) ? 0 : id_rule_fk.hashCode());
		result = prime * result
				+ ((netto_lordo == null) ? 0 : netto_lordo.hashCode());
		result = prime * result
				+ ((prezzoPrezzoNL == null) ? 0 : prezzoPrezzoNL.hashCode());
		result = prime
				* result
				+ ((prezzo_affiliato == null) ? 0 : prezzo_affiliato.hashCode());
		result = prime
				* result
				+ ((prezzo_affiliato_light == null) ? 0
						: prezzo_affiliato_light.hashCode());
		result = prime * result
				+ ((prezzo_from == null) ? 0 : prezzo_from.hashCode());
		result = prime
				* result
				+ ((prezzo_somministrato == null) ? 0 : prezzo_somministrato
						.hashCode());
		result = prime * result
				+ ((prezzo_to == null) ? 0 : prezzo_to.hashCode());
		result = prime * result
				+ ((scadenza == null) ? 0 : scadenza.hashCode());
		result = prime * result
				+ ((updated_by == null) ? 0 : updated_by.hashCode());
		result = prime * result
				+ ((updated_on == null) ? 0 : updated_on.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Prezzo other = (Prezzo) obj;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		if (created_on == null) {
			if (other.created_on != null)
				return false;
		} else if (!created_on.equals(other.created_on))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_rule_fk == null) {
			if (other.id_rule_fk != null)
				return false;
		} else if (!id_rule_fk.equals(other.id_rule_fk))
			return false;
		if (netto_lordo == null) {
			if (other.netto_lordo != null)
				return false;
		} else if (!netto_lordo.equals(other.netto_lordo))
			return false;
		if (prezzoPrezzoNL == null) {
			if (other.prezzoPrezzoNL != null)
				return false;
		} else if (!prezzoPrezzoNL.equals(other.prezzoPrezzoNL))
			return false;
		if (prezzo_affiliato == null) {
			if (other.prezzo_affiliato != null)
				return false;
		} else if (!prezzo_affiliato.equals(other.prezzo_affiliato))
			return false;
		if (prezzo_affiliato_light == null) {
			if (other.prezzo_affiliato_light != null)
				return false;
		} else if (!prezzo_affiliato_light.equals(other.prezzo_affiliato_light))
			return false;
		if (prezzo_from == null) {
			if (other.prezzo_from != null)
				return false;
		} else if (!prezzo_from.equals(other.prezzo_from))
			return false;
		if (prezzo_somministrato == null) {
			if (other.prezzo_somministrato != null)
				return false;
		} else if (!prezzo_somministrato.equals(other.prezzo_somministrato))
			return false;
		if (prezzo_to == null) {
			if (other.prezzo_to != null)
				return false;
		} else if (!prezzo_to.equals(other.prezzo_to))
			return false;
		if (scadenza == null) {
			if (other.scadenza != null)
				return false;
		} else if (!scadenza.equals(other.scadenza))
			return false;
		if (updated_by == null) {
			if (other.updated_by != null)
				return false;
		} else if (!updated_by.equals(other.updated_by))
			return false;
		if (updated_on == null) {
			if (other.updated_on != null)
				return false;
		} else if (!updated_on.equals(other.updated_on))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Prezzo [id=" + id + ", id_rule_fk=" + id_rule_fk
				+ ", prezzo_from=" + prezzo_from + ", prezzo_to=" + prezzo_to
				+ ", netto_lordo=" + netto_lordo + ", prezzoPrezzoNL="
				+ prezzoPrezzoNL + ", prezzo_affiliato=" + prezzo_affiliato
				+ ", prezzo_affiliato_light=" + prezzo_affiliato_light
				+ ", prezzo_somministrato=" + prezzo_somministrato
				+ ", scadenza=" + scadenza + ", created_on=" + created_on
				+ ", created_by=" + created_by + ", updated_on=" + updated_on
				+ ", updated_by=" + updated_by + ", version=" + version + "]";
	}
	
}