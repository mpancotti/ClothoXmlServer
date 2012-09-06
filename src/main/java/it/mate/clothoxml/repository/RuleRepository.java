package it.mate.clothoxml.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import it.mate.clothoxml.domain.Rule;
import it.mate.clothoxml.domain.Strategy;
import it.mate.clothoxml.domain.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class RuleRepository implements RuleRepInterface{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsertRule;
	
	/**
	 * Get a single rule by primary key
	 */
	public Rule getRule(Integer id) {		
		Rule rule = this.jdbcTemplate.queryForObject(
		        "select * from rule where id = ?",
		        new Object[]{id},
		        new RuleMapper() 
		        );		
		return rule;
	}
	
	@Override
	public List<Rule> findRulesOfVendor(Vendor vendor) {
		return this.jdbcTemplate.query("select * from rule where codice_vendor_fk = ?", 
				new Object[]{vendor.getCodice()},
				new RuleMapper());
	}
	
	/**
	 * Get all the vendors
	 */
	public List<Rule> findAllRules() {
		return this.jdbcTemplate.query("select * from rule", new RuleMapper());
		}
	
	/**
	 * Insert a Vendor
	 */
	public void add(Rule rule){
		Map<String,Object> parameters = new HashMap<String, Object>(14);
		//parameters.put("id", rule.getId());

		parameters.put("regexp", rule.getRegexp());
		parameters.put("valore_note_3", rule.getValore_note_3());
		parameters.put("strategy", rule.getStrategy());
		parameters.put("scadenza", rule.getScadenza());
		parameters.put("created_on", rule.getCreated_on());
		parameters.put("created_by", rule.getCreated_by());
		parameters.put("updated_on", rule.getUpdated_on());
		parameters.put("udated_by", rule.getUpdated_by());
		parameters.put("version", rule.getVersion());
		parameters.put("codice_vendor_fk", rule.getCodice_vendor_fk());
		jdbcInsertRule.execute(parameters);
		
	}
	
	@Override
	public void update(Rule rule, Integer id) {
		this.jdbcTemplate.update("update rule set regexp=?, strategy=?,"+
	"valore_note_3=?, scadenza=?, created_on=?, "+
	"created_by=?, updated_on=?, up  dated_by=?, version=?, codice_vendor_fk=? where id=?",
				rule.getRegexp(),rule.getStrategy(),rule.getValore_note_3(),
				rule.getScadenza(),rule.getCreated_on(),rule.getCreated_by(),rule.getUpdated_on(),
				rule.getUpdated_by(),rule.getVersion(),rule.getCodice_vendor_fk(),id);
	}
	
	@Override
	public void delete(Integer id) {
		this.jdbcTemplate.update("delete from rule where id=?",id);
		
	}

	
	/**
	 * Mapping method of the class
	 * @author marco
	 *
	 */
	private static final class RuleMapper implements RowMapper<Rule> {
		public Rule mapRow(ResultSet rs, int rowNum) throws SQLException{
			Rule rule = new Rule(); 
			rule.setId(rs.getInt("id")); 
			rule.setRegexp(rs.getString("regexp"));
			rule.setStrategy(rs.getString("strategy"));
			rule.setValore_note_3(rs.getString("valore_note_3"));
			rule.setScadenza(rs.getDate("scadenza"));
			rule.setCodice_vendor_fk(rs.getInt("codice_vendor_fk"));
			rule.setCreated_on(rs.getDate("created_on"));
			rule.setCreated_by(rs.getString("created_by"));
			rule.setUpdated_on(rs.getDate("updated_on"));
			rule.setUpdated_by(rs.getString("updated_by"));
			rule.setVersion(rs.getInt("version"));
			return rule; }
		}
	
	/*
	 * Set the datasource for the Repository
	 */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsertRule = new SimpleJdbcInsert(dataSource).withTableName("rule").usingGeneratedKeyColumns("id");
        this.jdbcInsertRule.compile();
    }





}
