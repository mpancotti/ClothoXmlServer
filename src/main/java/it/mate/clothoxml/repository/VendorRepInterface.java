package it.mate.clothoxml.repository;

import java.util.List;

import it.mate.clothoxml.domain.Vendor;

public interface VendorRepInterface {
	public Vendor getVendor(Integer codice);
	public List<Vendor> findAllVendors();
}
