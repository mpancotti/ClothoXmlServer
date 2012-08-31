package it.mate.clothoxml.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import it.mate.clothoxml.domain.Strategy;
import it.mate.clothoxml.domain.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VendorRepository implements VendorRepInterface{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsertVendor;
	
	/**
	 * Get a single vendor by primary key
	 */
	public Vendor getVendor(Integer codice) {
		
		Vendor vendor = this.jdbcTemplate.queryForObject(
		        "select codice, nome, strategy from vendor where codice = ?",
		        new Object[]{codice},
		        new VendorMapper() 
		        );		
		return vendor;
	}
	
	/**
	 * Get all the vendors
	 */
	public List<Vendor> findAllVendors() {
		return this.jdbcTemplate.query("select * from vendor", new VendorMapper());
		}
	
	/**
	 * Insert a Vendor
	 */
	public void add(Vendor vendor){
		Map<String,Object> parameters = new HashMap<String, Object>(3);
		parameters.put("codice", vendor.getCodice());
		parameters.put("nome", vendor.getNome());
		parameters.put("strategy", vendor.getStrategy());
		jdbcInsertVendor.execute(parameters);
		
	}
	
	@Override
	public void update(Vendor vendor, Integer codice) {
		this.jdbcTemplate.update("update vendor set nome=?, strategy=? where codice=?",
				vendor.getNome(),vendor.getStrategy().toString(),codice);
		
	}
	
	@Override
	public void delete(Integer codice) {
		this.jdbcTemplate.update("delete from vendor where codice=?",codice);
		
	}

	
	/**
	 * Mapping method of the class
	 * @author marco
	 *
	 */
	private static final class VendorMapper implements RowMapper<Vendor> {
		public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException{
			Vendor vendor = new Vendor(); 
			vendor.setCodice(rs.getInt("codice")); 
			vendor.setNome(rs.getString("nome"));
			vendor.setStrategy(Strategy.valueOf(rs.getString("strategy")));
			return vendor; }
		}
	
	/*
	 * Set the datasource for the Repository
	 */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsertVendor = new SimpleJdbcInsert(dataSource).withTableName("vendor");
    }



}
