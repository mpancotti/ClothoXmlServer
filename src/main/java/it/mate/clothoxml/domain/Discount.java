package it.mate.clothoxml.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class Discount {
	private Integer id;
	private Float from_discount;
	private Float to_discount;
	private String value_note_3;
	private Float affiliato;
	private Float affiliato_light;
	private Float somministrato;
	private Date scadenza;
	private Integer codice_vendor_fk;
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

	public Float getFrom_discount() {
		return from_discount;
	}

	public void setFrom_discount(Float from_discount) {
		this.from_discount = from_discount;
	}

	public Float getTo_discount() {
		return to_discount;
	}

	public void setTo_discount(Float to_discount) {
		this.to_discount = to_discount;
	}

	public String getValue_note_3() {
		return value_note_3;
	}

	public void setValue_note_3(String value_note_3) {
		this.value_note_3 = value_note_3;
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

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public Integer getCodice_vendor_fk() {
		return codice_vendor_fk;
	}

	public void setCodice_vendor_fk(Integer codice_vendor_fk) {
		this.codice_vendor_fk = codice_vendor_fk;
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
	
	  public static Discount fromJsonToDiscount(String json) {
	        return new JSONDeserializer<Discount>().use(null, Discount.class).deserialize(json);
	    }
	    
	    public static String toJsonArray(Collection<Discount> collection) {
	        return new JSONSerializer().exclude("*.class").serialize(collection);
	    }
	    
	    public static Collection<Discount> fromJsonArrayToDiscounts(String json) {
	        return new JSONDeserializer<List<Discount>>().use(null, ArrayList.class).use("values", Discount.class).deserialize(json);
	    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((affiliato == null) ? 0 : affiliato.hashCode());
		result = prime * result
				+ ((affiliato_light == null) ? 0 : affiliato_light.hashCode());
		result = prime
				* result
				+ ((codice_vendor_fk == null) ? 0 : codice_vendor_fk.hashCode());
		result = prime * result
				+ ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result
				+ ((created_on == null) ? 0 : created_on.hashCode());
		result = prime * result
				+ ((from_discount == null) ? 0 : from_discount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((scadenza == null) ? 0 : scadenza.hashCode());
		result = prime * result
				+ ((somministrato == null) ? 0 : somministrato.hashCode());
		result = prime * result
				+ ((to_discount == null) ? 0 : to_discount.hashCode());
		result = prime * result
				+ ((updated_by == null) ? 0 : updated_by.hashCode());
		result = prime * result
				+ ((updated_on == null) ? 0 : updated_on.hashCode());
		result = prime * result
				+ ((value_note_3 == null) ? 0 : value_note_3.hashCode());
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
		Discount other = (Discount) obj;
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
		if (codice_vendor_fk == null) {
			if (other.codice_vendor_fk != null)
				return false;
		} else if (!codice_vendor_fk.equals(other.codice_vendor_fk))
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
		if (from_discount == null) {
			if (other.from_discount != null)
				return false;
		} else if (!from_discount.equals(other.from_discount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scadenza == null) {
			if (other.scadenza != null)
				return false;
		} else if (!scadenza.equals(other.scadenza))
			return false;
		if (somministrato == null) {
			if (other.somministrato != null)
				return false;
		} else if (!somministrato.equals(other.somministrato))
			return false;
		if (to_discount == null) {
			if (other.to_discount != null)
				return false;
		} else if (!to_discount.equals(other.to_discount))
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
		if (value_note_3 == null) {
			if (other.value_note_3 != null)
				return false;
		} else if (!value_note_3.equals(other.value_note_3))
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
		return "Discount [id=" + id + ", from_discount=" + from_discount
				+ ", to_discount=" + to_discount + ", value_note_3="
				+ value_note_3 + ", affiliato=" + affiliato
				+ ", affiliato_light=" + affiliato_light + ", somministrato="
				+ somministrato + ", scadenza=" + scadenza
				+ ", codice_vendor_fk=" + codice_vendor_fk + ", created_on="
				+ created_on + ", created_by=" + created_by + ", updated_on="
				+ updated_on + ", updated_by=" + updated_by + ", version="
				+ version + "]";
	}
	
	
	
	
	
	
}
