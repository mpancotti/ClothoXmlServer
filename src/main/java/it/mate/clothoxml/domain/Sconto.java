package it.mate.clothoxml.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collection;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class Sconto{
	private Integer id;
	private Integer id_rule_fk;
	private Float sconto_fornitore;
	private Float tolleranza;
	private Float prezzo_lordo;
	private Float affiliato;
	private Float affiliato_light;
	private Float somministrato;
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
	public Float getSconto_fornitore() {
		return sconto_fornitore;
	}
	public void setSconto_fornitore(Float sconto_fornitore) {
		this.sconto_fornitore = sconto_fornitore;
	}
	public Float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(Float tolleranza) {
		this.tolleranza = tolleranza;
	}
	public Float getPrezzo_lordo() {
		return prezzo_lordo;
	}
	public void setPrezzo_lordo(Float prezzo_lordo) {
		this.prezzo_lordo = prezzo_lordo;
	}
	public Float getAffiliato() {
		return affiliato;
	}
	public void setAffiliato(Float affiliato) {
		this.affiliato = affiliato;
	}
	public Float getAffiliato_light() {
		return affiliato_light;
	}
	public void setAffiliato_light(Float affiliato_light) {
		this.affiliato_light = affiliato_light;
	}
	public Float getSomministrato() {
		return somministrato;
	}
	public void setSomministrato(Float somministrato) {
		this.somministrato = somministrato;
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
	
	 public static Sconto fromJsonToSconto(String json) {
	        return new JSONDeserializer<Sconto>().use(null, Sconto.class).deserialize(json);
	    }
	    
	    public static String toJsonArray(Collection<Sconto> collection) {
	        return new JSONSerializer().exclude("*.class").serialize(collection);
	    }
	    
	    public static Collection<Sconto>fromJsonArrayToPrezzi(String json) {
	        return new JSONDeserializer<List<Sconto>>().use(null, ArrayList.class).use("values", Sconto.class).deserialize(json);
	    }
	    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((affiliato == null) ? 0 : affiliato.hashCode());
		result = prime * result
				+ ((affiliato_light == null) ? 0 : affiliato_light.hashCode());
		result = prime * result
				+ ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result
				+ ((created_on == null) ? 0 : created_on.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_rule_fk == null) ? 0 : id_rule_fk.hashCode());
		result = prime
				* result
				+ ((prezzo_affiliato == null) ? 0 : prezzo_affiliato.hashCode());
		result = prime
				* result
				+ ((prezzo_affiliato_light == null) ? 0
						: prezzo_affiliato_light.hashCode());
		result = prime * result
				+ ((prezzo_lordo == null) ? 0 : prezzo_lordo.hashCode());
		result = prime
				* result
				+ ((prezzo_somministrato == null) ? 0 : prezzo_somministrato
						.hashCode());
		result = prime * result
				+ ((scadenza == null) ? 0 : scadenza.hashCode());
		result = prime
				* result
				+ ((sconto_fornitore == null) ? 0 : sconto_fornitore.hashCode());
		result = prime * result
				+ ((somministrato == null) ? 0 : somministrato.hashCode());
		result = prime * result
				+ ((tolleranza == null) ? 0 : tolleranza.hashCode());
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
		Sconto other = (Sconto) obj;
		if (affiliato == null) {
			if (other.affiliato != null)
				return false;
		} else if (!affiliato.equals(other.affiliato))
			return false;
		if (affiliato_light == null) {
			if (other.affiliato_light != null)
				return false;
		} else if (!affiliato_light.equals(other.affiliato_light))
			return false;
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
		if (prezzo_lordo == null) {
			if (other.prezzo_lordo != null)
				return false;
		} else if (!prezzo_lordo.equals(other.prezzo_lordo))
			return false;
		if (prezzo_somministrato == null) {
			if (other.prezzo_somministrato != null)
				return false;
		} else if (!prezzo_somministrato.equals(other.prezzo_somministrato))
			return false;
		if (scadenza == null) {
			if (other.scadenza != null)
				return false;
		} else if (!scadenza.equals(other.scadenza))
			return false;
		if (sconto_fornitore == null) {
			if (other.sconto_fornitore != null)
				return false;
		} else if (!sconto_fornitore.equals(other.sconto_fornitore))
			return false;
		if (somministrato == null) {
			if (other.somministrato != null)
				return false;
		} else if (!somministrato.equals(other.somministrato))
			return false;
		if (tolleranza == null) {
			if (other.tolleranza != null)
				return false;
		} else if (!tolleranza.equals(other.tolleranza))
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
		return "Sconto [id=" + id + ", id_rule_fk=" + id_rule_fk
				+ ", sconto_fornitore=" + sconto_fornitore + ", tolleranza="
				+ tolleranza + ", prezzo_lordo=" + prezzo_lordo
				+ ", affiliato=" + affiliato + ", affiliato_light="
				+ affiliato_light + ", somministrato=" + somministrato
				+ ", prezzo_affiliato=" + prezzo_affiliato
				+ ", prezzo_affiliato_light=" + prezzo_affiliato_light
				+ ", prezzo_somministrato=" + prezzo_somministrato
				+ ", scadenza=" + scadenza + ", created_on=" + created_on
				+ ", created_by=" + created_by + ", updated_on=" + updated_on
				+ ", updated_by=" + updated_by + ", version=" + version + "]";
	}
  	
}
