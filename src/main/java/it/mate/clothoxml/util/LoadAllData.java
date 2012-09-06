package it.mate.clothoxml.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mate.clothoxml.domain.Vendor;
import it.mate.clothoxml.domain.VendorData;
import it.mate.clothoxml.repository.VendorRepInterface;
import it.mate.clothoxml.repository.VendorRepository;

public class LoadAllData {
	
	VendorRepInterface vendorRepository=new VendorRepository();
	
	public void loadVendors(){
		VendorData vendorData=new VendorData();
		List<Vendor> vendors = vendorRepository.findAllVendors();
		for(Vendor vendor: vendors){
			vendorData.setCodice(vendor.getCodice());
			System.out.println(vendorData.getCodice());
		}
	}
	
	public static void main(String[] args) throws Exception {
		LoadAllData lad = new LoadAllData();
		lad.loadVendors();
	}

}
