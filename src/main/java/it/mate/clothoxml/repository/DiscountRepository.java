package it.mate.clothoxml.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import it.mate.clothoxml.domain.Discount;
import it.mate.clothoxml.domain.Strategy;
import it.mate.clothoxml.domain.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountRepository implements DiscountRepInterface{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsertDiscount;
	
	/**
	 * Get a single discount by primary key
	 */
	public Discount getDiscount(Integer id) {
		
		Discount discount = this.jdbcTemplate.queryForObject(
		        "select * from discount where id = ?",
		        new Object[]{id},
		        new DiscountMapper() 
		        );		
		return discount;
	}
	
	/**
	 * Get all the vendors
	 */
	public List<Discount> findAllDiscounts() {
		return this.jdbcTemplate.query("select * from discount", new DiscountMapper());
		}
	
	/**
	 * Insert a Vendor
	 */
	public void add(Discount discount){
		Map<String,Object> parameters = new HashMap<String, Object>(14);
		parameters.put("id", discount.getId());
		parameters.put("from_discount", discount.getFrom_discount());
		parameters.put("to_discount", discount.getTo_discount());
		parameters.put("value_note_3", discount.getValue_note_3());
		parameters.put("affiliato", discount.getAffiliato());
		parameters.put("affiliato_light", discount.getAffiliato_light());
		parameters.put("somministrato", discount.getSomministrato());
		parameters.put("scadenza", discount.getScadenza());
		parameters.put("created_on", discount.getCreated_on());
		parameters.put("created_by", discount.getCreated_by());
		parameters.put("updated_on", discount.getUpdated_on());
		parameters.put("udated_by", discount.getUpdated_by());
		parameters.put("version", discount.getVersion());
		parameters.put("codice_vendor_fk", discount.getCodice_vendor_fk());
		jdbcInsertDiscount.execute(parameters);
		
	}
	
	@Override
	public void update(Discount discount, Integer id) {
		this.jdbcTemplate.update("update discount set from_discount=?, to_discount=?,"+
	"value_note_3=?, affiliato=?, affiliato_light=?, somministrato=?, scadenza=?, created_on=?, "+
	"created_by=?, updated_on=?, updated_by=?, version=?, codice_vendor_fk=? where id=?",
				discount.getFrom_discount(),discount.getTo_discount(),discount.getValue_note_3(),
				discount.getAffiliato(),discount.getAffiliato_light(),discount.getSomministrato(),
				discount.getScadenza(),discount.getCreated_on(),discount.getCreated_by(),discount.getUpdated_on(),
				discount.getUpdated_by(),discount.getVersion(),discount.getCodice_vendor_fk(),id);
	}
	
	@Override
	public void delete(Integer id) {
		this.jdbcTemplate.update("delete from discount where id=?",id);
		
	}

	
	/**
	 * Mapping method of the class
	 * @author marco
	 *
	 */
	private static final class DiscountMapper implements RowMapper<Discount> {
		public Discount mapRow(ResultSet rs, int rowNum) throws SQLException{
			Discount discount = new Discount(); 
			discount.setId(rs.getInt("id")); 
			discount.setFrom_discount(rs.getFloat("from_discount"));
			discount.setTo_discount(rs.getFloat("to_discount"));
			discount.setValue_note_3(rs.getString("value_note_3"));
			discount.setAffiliato(rs.getFloat("affiliato"));
			discount.setAffiliato_light(rs.getFloat("affiliato_light"));
			discount.setSomministrato(rs.getFloat("somministrato"));
			discount.setScadenza(rs.getDate("scadenza"));
			discount.setCodice_vendor_fk(rs.getInt("codice_vendor_fk"));
			discount.setCreated_on(rs.getDate("created_on"));
			discount.setCreated_by(rs.getString("created_by"));
			discount.setUpdated_on(rs.getDate("updated_on"));
			discount.setUpdated_by(rs.getString("updated_by"));
			discount.setVersion(rs.getInt("version"));
			return discount; }
		}
	
	/*
	 * Set the datasource for the Repository
	 */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsertDiscount = new SimpleJdbcInsert(dataSource).withTableName("discount");
    }



}
