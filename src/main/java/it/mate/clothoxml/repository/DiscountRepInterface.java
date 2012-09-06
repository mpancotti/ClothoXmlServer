package it.mate.clothoxml.repository;

import java.util.List;

import it.mate.clothoxml.domain.Discount;
import it.mate.clothoxml.domain.Vendor;

public interface DiscountRepInterface {
	public Discount getDiscount(Integer codice);
	public List<Discount> findAllDiscounts();
	public void add(Discount discount);
	public void update(Discount discount, Integer codice);
	public void delete(Integer codice);
	public List<Discount> findDiscountOfVendor(Vendor vendor);
}
