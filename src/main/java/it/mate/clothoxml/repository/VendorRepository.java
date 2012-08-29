package it.mate.clothoxml.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import it.mate.clothoxml.domain.Strategy;
import it.mate.clothoxml.domain.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendorRepository implements VendorRepInterface{
	
	private JdbcTemplate jdbcTemplate;
	
	public Vendor getVendor(Integer codice) {
		
		Vendor vendor = this.jdbcTemplate.queryForObject(
		        "select codice, nome from vendor where codice = ?",
		        new Object[]{codice},
		        new VendorMapper() 
		        );		
		return vendor;
	}
	
	public List<Vendor> findAllVendors() {
		return this.jdbcTemplate.query("select * from vendor", new VendorMapper());
		}
		
	private static final class VendorMapper implements RowMapper<Vendor> {
		public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException{
			Vendor vendor = new Vendor(); 
			vendor.setCodice(rs.getInt("codice")); 
			vendor.setNome(rs.getString("nome"));
			//vendor.setStrategy(Strategy.valueOf(rs.getString("strategy")));
			return vendor; }
		}
	
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
