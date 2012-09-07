package it.mate.clothoxml.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import it.mate.clothoxml.domain.Prezzo;
import it.mate.clothoxml.domain.Strategy;
import it.mate.clothoxml.domain.Vendor;
import it.mate.clothoxml.domain.Discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PrezzoRepository implements PrezzoRepInterface{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsertPrezzo;
	
	/**
	 * Get a single prezzo by primary key
	 */
	public Prezzo getPrezzo(Integer id) {
		
		Prezzo prezzo = this.jdbcTemplate.queryForObject(
		        "select * from prezzo where id = ?",
		        new Object[]{id},
		        new PrezzoMapper() 
		        );		
		return prezzo;
	}
	
	/**
	 * Get all the vendors
	 */
	public List<Prezzo> findAllPrezzi() {
		return this.jdbcTemplate.query("select * from prezzo", new PrezzoMapper());
		}
	
	/**
	 * Insert a Vendor
	 */
	public void add(Prezzo prezzo){
		Map<String,Object> parameters = new HashMap<String, Object>(14);
		//parameters.put("id", prezzo.getId());
		parameters.put("prezzo_from", prezzo.getPrezzo_from());
		parameters.put("prezzo_to", prezzo.getPrezzo_to());
		parameters.put("netto_lordo", prezzo.getNetto_lordo());
		parameters.put("prezzo_affiliato", prezzo.getPrezzo_affiliato());
		parameters.put("prezzo_affiliato_light", prezzo.getPrezzo_affiliato_light());
		parameters.put("prezzo_somministrato", prezzo.getPrezzo_somministrato());
		parameters.put("scadenza", prezzo.getScadenza());
		parameters.put("created_on", prezzo.getCreated_on());
		parameters.put("created_by", prezzo.getCreated_by());
		parameters.put("updated_on", prezzo.getUpdated_on());
		parameters.put("udated_by", prezzo.getUpdated_by());
		parameters.put("version", prezzo.getVersion());
		parameters.put("id_rule_fk", prezzo.getId_rule_fk());
		jdbcInsertPrezzo.execute(parameters);
		
	}
	
	@Override
	public void update(Prezzo prezzo, Integer id) {
		this.jdbcTemplate.update("update prezzo set prezzo_from=?, prezzo_to=?,"+
	"netto_lordo=?, prezzoPrezzoNL=?, prezzo_affiliato=?, prezzo_affiliato_light=?, prezzo_somministrato=?, scadenza=?, created_on=?, "+
	"created_by=?, updated_on=?, up  dated_by=?, version=?, id_rule_fk=? where id=?",
				prezzo.getPrezzo_from(),prezzo.getPrezzo_to(),prezzo.getNetto_lordo(),
				prezzo.getPrezzo_affiliato(),prezzo.getPrezzo_affiliato_light(),prezzo.getPrezzo_somministrato(),
				prezzo.getScadenza(),prezzo.getCreated_on(),prezzo.getCreated_by(),prezzo.getUpdated_on(),
				prezzo.getUpdated_by(),prezzo.getVersion(),prezzo.getId_rule_fk(),id);
	}
	
	@Override
	public void delete(Integer id) {
		this.jdbcTemplate.update("delete from prezzo where id=?",id);
		
	}

	
	/**
	 * Mapping method of the class
	 * @author marco
	 *
	 */
	private static final class PrezzoMapper implements RowMapper<Prezzo> {
		public Prezzo mapRow(ResultSet rs, int rowNum) throws SQLException{
			Prezzo prezzo = new Prezzo(); 
			prezzo.setId(rs.getInt("id")); 
			prezzo.setPrezzo_from(rs.getFloat("prezzo_from"));
			prezzo.setPrezzo_to(rs.getFloat("prezzo_to"));
			prezzo.setNetto_lordo(rs.getString("netto_lordo"));
			prezzo.setPrezzo_affiliato(rs.getFloat("prezzo_affiliato"));
			prezzo.setPrezzo_affiliato_light(rs.getFloat("prezzo_affiliato_light"));
			prezzo.setPrezzo_somministrato(rs.getFloat("prezzo_somministrato"));
			prezzo.setScadenza(rs.getDate("scadenza"));
			prezzo.setId_rule_fk(rs.getInt("id_rule_fk"));
			prezzo.setCreated_on(rs.getDate("created_on"));
			prezzo.setCreated_by(rs.getString("created_by"));
			prezzo.setUpdated_on(rs.getDate("updated_on"));
			prezzo.setUpdated_by(rs.getString("updated_by"));
			prezzo.setVersion(rs.getInt("version"));
			return prezzo; }
		}
	
	/*
	 * Set the datasource for the Repository
	 */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsertPrezzo = new SimpleJdbcInsert(dataSource).withTableName("prezzo").usingGeneratedKeyColumns("id");
        this.jdbcInsertPrezzo.compile();
    }



}
