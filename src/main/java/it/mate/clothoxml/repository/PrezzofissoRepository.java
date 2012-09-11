package it.mate.clothoxml.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import it.mate.clothoxml.domain.Prezzofisso;
import it.mate.clothoxml.domain.Strategy;
import it.mate.clothoxml.domain.Vendor;
import it.mate.clothoxml.domain.Discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PrezzofissoRepository implements PrezzofissoRepInterface{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsertPrezzofisso;
	
	/**
	 * Get a single prezzofisso by primary key
	 */
	public Prezzofisso getPrezzofisso(Integer id) { 
		
		Prezzofisso prezzofisso = this.jdbcTemplate.queryForObject(
		        "select * from prezzofisso where id = ?",
		        new Object[]{id},
		        new PrezzofissoMapper() 
		        );		
		return prezzofisso;
	}
	
	/**
	 * Get all the vendors
	 */
	public List<Prezzofisso> findAllPrezzofisso() {
		return this.jdbcTemplate.query("select * from prezzofisso", new PrezzofissoMapper());
		}
	
	public List<Prezzofisso> findPrezzifissiOfRule(Integer rule) {
		return this.jdbcTemplate.query("select * from prezzofisso where id_rule_fk = ?",
				new Object[]{rule},
				new PrezzofissoMapper());
		}
	
	/**
	 * Insert a Vendor
	 */
	public void add(Prezzofisso prezzofisso){
		Map<String,Object> parameters = new HashMap<String, Object>(14);
		//parameters.put("id", prezzofisso.getId());
		parameters.put("prezzo_fornitore", prezzofisso.getPrezzo_fornitore());
		parameters.put("netto_lordo", prezzofisso.getNetto_lordo());
		parameters.put("affiliato", prezzofisso.getAffiliato());
		parameters.put("affiliato_light", prezzofisso.getAffiliato_light());
		parameters.put("somministrato", prezzofisso.getSomministrato());
		parameters.put("scadenza", prezzofisso.getScadenza());
		parameters.put("created_on", prezzofisso.getCreated_on());
		parameters.put("created_by", prezzofisso.getCreated_by());
		parameters.put("updated_on", prezzofisso.getUpdated_on());
		parameters.put("udated_by", prezzofisso.getUpdated_by());
		parameters.put("version", prezzofisso.getVersion());
		parameters.put("id_rule_fk", prezzofisso.getId_rule_fk());
		jdbcInsertPrezzofisso.execute(parameters);
		
	}
	
	@Override
	public void update(Prezzofisso prezzofisso, Integer id) {
		this.jdbcTemplate.update("update prezzofisso set prezzo_fornitore=?,"+
	"netto_lordo=?, affiliato=?, affiliato_light=?, somministrato=?, scadenza=?, created_on=?, "+
	"created_by=?, updated_on=?, up  dated_by=?, version=?, id_rule_fk=? where id=?",
				prezzofisso.getPrezzo_fornitore(),prezzofisso.getNetto_lordo(),
				prezzofisso.getAffiliato(),prezzofisso.getAffiliato_light(),prezzofisso.getSomministrato(),
				prezzofisso.getScadenza(),prezzofisso.getCreated_on(),prezzofisso.getCreated_by(),prezzofisso.getUpdated_on(),
				prezzofisso.getUpdated_by(),prezzofisso.getVersion(),prezzofisso.getId_rule_fk(),id);
	}
	
	@Override
	public void delete(Integer id) {
		this.jdbcTemplate.update("delete from prezzofisso where id=?",id);
		
	}

	
	/**
	 * Mapping method of the class
	 * @author marco
	 *
	 */
	private static final class PrezzofissoMapper implements RowMapper<Prezzofisso> {
		public Prezzofisso mapRow(ResultSet rs, int rowNum) throws SQLException{
			Prezzofisso prezzofisso = new Prezzofisso(); 
			prezzofisso.setId(rs.getInt("id")); 
			prezzofisso.setPrezzo_fornitore(rs.getFloat("prezzo_fornitore"));
			prezzofisso.setNetto_lordo(rs.getString("netto_lordo"));
			prezzofisso.setAffiliato(rs.getFloat("affiliato"));
			prezzofisso.setAffiliato_light(rs.getFloat("affiliato_light"));
			prezzofisso.setSomministrato(rs.getFloat("somministrato"));
			prezzofisso.setScadenza(rs.getDate("scadenza"));
			prezzofisso.setId_rule_fk(rs.getInt("id_rule_fk"));
			prezzofisso.setCreated_on(rs.getDate("created_on"));
			prezzofisso.setCreated_by(rs.getString("created_by"));
			prezzofisso.setUpdated_on(rs.getDate("updated_on"));
			prezzofisso.setUpdated_by(rs.getString("updated_by"));
			prezzofisso.setVersion(rs.getInt("version"));
			return prezzofisso; }
		}
	
	/*
	 * Set the datasource for the Repository
	 */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsertPrezzofisso = new SimpleJdbcInsert(dataSource).withTableName("prezzofisso").usingGeneratedKeyColumns("id");
        this.jdbcInsertPrezzofisso.compile();
    }



}
