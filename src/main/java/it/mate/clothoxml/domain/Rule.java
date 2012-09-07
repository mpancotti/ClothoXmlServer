package it.mate.clothoxml.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class Rule {
	private Integer id;
	private String regexp;
	private String strategy;
	private String valore_note_3;
	private Date scadenza;
	private Integer codice_vendor_fk;
	private Date created_on;
	private String created_by;
	private Date updated_on;
	private String updated_by;
	private Integer version;
	private Integer sequenza;
	

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
	
	 public static Rule fromJsonToRule(String json) {
	        return new JSONDeserializer<Rule>().use(null, Rule.class).deserialize(json);
	    }
	    
	    public static String toJsonArray(Collection<Rule> collection) {
	        return new JSONSerializer().exclude("*.class").serialize(collection);
	    }
	    
	    public static Collection<Rule>fromJsonArrayToPrezzi(String json) {
	        return new JSONDeserializer<List<Rule>>().use(null, ArrayList.class).use("values", Rule.class).deserialize(json);
	    }
	
		public Integer getSequenza() {
			return sequenza;
		}
		public void setSequenza(Integer sequenza) {
			this.sequenza = sequenza;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((codice_vendor_fk == null) ? 0 : codice_vendor_fk
							.hashCode());
			result = prime * result
					+ ((created_by == null) ? 0 : created_by.hashCode());
			result = prime * result
					+ ((created_on == null) ? 0 : created_on.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((regexp == null) ? 0 : regexp.hashCode());
			result = prime * result
					+ ((scadenza == null) ? 0 : scadenza.hashCode());
			result = prime * result
					+ ((sequenza == null) ? 0 : sequenza.hashCode());
			result = prime * result
					+ ((strategy == null) ? 0 : strategy.hashCode());
			result = prime * result
					+ ((updated_by == null) ? 0 : updated_by.hashCode());
			result = prime * result
					+ ((updated_on == null) ? 0 : updated_on.hashCode());
			result = prime * result
					+ ((valore_note_3 == null) ? 0 : valore_note_3.hashCode());
			result = prime * result
					+ ((version == null) ? 0 : version.hashCode());
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
			Rule other = (Rule) obj;
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
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (regexp == null) {
				if (other.regexp != null)
					return false;
			} else if (!regexp.equals(other.regexp))
				return false;
			if (scadenza == null) {
				if (other.scadenza != null)
					return false;
			} else if (!scadenza.equals(other.scadenza))
				return false;
			if (sequenza == null) {
				if (other.sequenza != null)
					return false;
			} else if (!sequenza.equals(other.sequenza))
				return false;
			if (strategy == null) {
				if (other.strategy != null)
					return false;
			} else if (!strategy.equals(other.strategy))
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
			if (valore_note_3 == null) {
				if (other.valore_note_3 != null)
					return false;
			} else if (!valore_note_3.equals(other.valore_note_3))
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
			return "Rule [id=" + id + ", regexp=" + regexp + ", strategy="
					+ strategy + ", valore_note_3=" + valore_note_3
					+ ", scadenza=" + scadenza + ", codice_vendor_fk="
					+ codice_vendor_fk + ", created_on=" + created_on
					+ ", created_by=" + created_by + ", updated_on="
					+ updated_on + ", updated_by=" + updated_by + ", version="
					+ version + ", sequenza=" + sequenza + "]";
		}
	    
	

	
}
