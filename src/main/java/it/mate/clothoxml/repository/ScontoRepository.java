package it.mate.clothoxml.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import it.mate.clothoxml.domain.Sconto;
import it.mate.clothoxml.domain.Strategy;
import it.mate.clothoxml.domain.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * Repository for Sconto Entity
 * @author marco
 */
@Repository
public class ScontoRepository implements ScontoRepInterface{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsertSconto;
	
	/**
	 * Get a single sconto by primary key
	 */
	public Sconto getSconto(Integer id) {
		
		Sconto sconto = this.jdbcTemplate.queryForObject(
		        "select * from sconto where id = ?",
		        new Object[]{id},
		        new ScontoMapper() 
		        );		
		return sconto;
	}
	
	/**
	 * Get all the sconto
	 */
	public List<Sconto> findAllScontos() {
		return this.jdbcTemplate.query("select * from sconto", new ScontoMapper());
		}
	
	/**
	 * Insert a Sconto
	 */
	public void add(Sconto sconto){
		Map<String,Object> parameters = new HashMap<String, Object>(14);
		//parameters.put("id", sconto.getId());
		parameters.put("sconto_fornitore", sconto.getSconto_fornitore());
		parameters.put("tolleranza", sconto.getTolleranza());
		parameters.put("prezzo_lordo", sconto.getPrezzo_lordo());
		parameters.put("affiliato", sconto.getAffiliato());
		parameters.put("affiliato_light", sconto.getAffiliato_light());
		parameters.put("somministrato", sconto.getSomministrato());
		parameters.put("prezzo_affiliato", sconto.getPrezzo_affiliato());
		parameters.put("prezzo_affiliato_light", sconto.getPrezzo_affiliato_light());
		parameters.put("prezzo_somministrato", sconto.getPrezzo_somministrato());
		parameters.put("scadenza", sconto.getScadenza());
		parameters.put("created_on", sconto.getCreated_on());
		parameters.put("created_by", sconto.getCreated_by());
		parameters.put("updated_on", sconto.getUpdated_on());
		parameters.put("udated_by", sconto.getUpdated_by());
		parameters.put("version", sconto.getVersion());
		parameters.put("id_rule_fk", sconto.getId_rule_fk());
		jdbcInsertSconto.execute(parameters);
		
	}
	
	/**
	 * Update a sconto
	 */
	@Override
	public void update(Sconto sconto, Integer id) {
		this.jdbcTemplate.update("update sconto set sconto_fornitore=?, tolleranza=?,"+
	"prezzo_lordo=?, affiliato=?, affiliato_light=?, somministrato=?,prezzo_affiliato=?,"+ 
				"prezzo_affiliato_light=?, prezzo_somministrato=?, scadenza=?, created_on=?, "+
				"created_by=?, updated_on=?, up  dated_by=?, version=?, id_rule_fk=? where id=?",
				sconto.getSconto_fornitore(),sconto.getTolleranza(),sconto.getPrezzo_lordo(),
				sconto.getAffiliato(),sconto.getAffiliato_light(),sconto.getSomministrato(),
				sconto.getPrezzo_affiliato(),sconto.getPrezzo_affiliato_light(),sconto.getPrezzo_somministrato(),
				sconto.getScadenza(),sconto.getCreated_on(),sconto.getCreated_by(),sconto.getUpdated_on(),
				sconto.getUpdated_by(),sconto.getVersion(),sconto.getId_rule_fk(),id);
	}
	
	/**
	 * Delete a sconto
	 */
	@Override
	public void delete(Integer id) {
		this.jdbcTemplate.update("delete from sconto where id=?",id);
		
	}

	
	/**
	 * Mapping method of the class Sconto
	 * @author marco
	 *
	 */
	private static final class ScontoMapper implements RowMapper<Sconto> {
		public Sconto mapRow(ResultSet rs, int rowNum) throws SQLException{
			Sconto sconto = new Sconto(); 
			sconto.setId(rs.getInt("id")); 
			sconto.setSconto_fornitore(rs.getFloat("sconto_fornitore"));
			sconto.setTolleranza(rs.getFloat("tolleranza"));
			sconto.setPrezzo_lordo(rs.getFloat("prezzo_lordo"));
			sconto.setAffiliato(rs.getFloat("affiliato"));
			sconto.setAffiliato_light(rs.getFloat("affiliato_light"));
			sconto.setSomministrato(rs.getFloat("somministrato"));
			sconto.setPrezzo_affiliato(rs.getFloat("prezzo_affiliato"));
			sconto.setPrezzo_affiliato_light(rs.getFloat("prezzo_affiliato_light"));
			sconto.setPrezzo_somministrato(rs.getFloat("prezzo_somministrato"));
			sconto.setScadenza(rs.getDate("scadenza"));
			sconto.setId_rule_fk(rs.getInt("id_rule_fk"));
			sconto.setCreated_on(rs.getDate("created_on"));
			sconto.setCreated_by(rs.getString("created_by"));
			sconto.setUpdated_on(rs.getDate("updated_on"));
			sconto.setUpdated_by(rs.getString("updated_by"));
			sconto.setVersion(rs.getInt("version"));
			return sconto; }
		}
	
	/**
	 * Set the datasource for the Repository
	 */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsertSconto = new SimpleJdbcInsert(dataSource).withTableName("sconto").usingGeneratedKeyColumns("id");
        this.jdbcInsertSconto.compile();
    }

	public List<Sconto> findScontiOfRule(Integer rule) {
		return this.jdbcTemplate.query("select * from sconto where id_rule_fk = ?", 
				new Object[]{rule},
				new ScontoMapper());
	}



}
