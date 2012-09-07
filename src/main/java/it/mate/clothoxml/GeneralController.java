package it.mate.clothoxml;

import java.util.ArrayList;
import java.util.List;

import flexjson.JSONSerializer;
import it.mate.clothoxml.domain.Discount;
import it.mate.clothoxml.domain.Rule;
import it.mate.clothoxml.domain.Vendor;
import it.mate.clothoxml.domain.VendorData;
import it.mate.clothoxml.domain.VendorRule;
import it.mate.clothoxml.repository.DiscountRepInterface;
import it.mate.clothoxml.repository.RuleRepInterface;
import it.mate.clothoxml.repository.VendorRepInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/general")
@Controller
public class GeneralController {
	
	@Autowired
	VendorRepInterface vendorRepository;
	
	@Autowired
	DiscountRepInterface discountRepository;
	
	@Autowired
	RuleRepInterface ruleRepository;
	
	@RequestMapping(value = "/excel", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<String> generateExcel() {
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();
		
		try {
			List<VendorData> vendorDataList = new ArrayList<VendorData>();
			List<Vendor> records = vendorRepository.findAllVendors();
			for(Vendor vendor: records){
				VendorData vendorData=new VendorData();
				vendorData.setCodice(vendor.getCodice());
				vendorData.setNome(vendor.getNome());
				vendorData.setStrategy(vendor.getStrategy());
				vendorData.setDiscounts(discountRepository.findDiscountOfVendor(vendor));				
				List<VendorRule> vendorRules = new ArrayList<VendorRule>();
				for(Rule rule: ruleRepository.findRulesOfVendor(vendor)){
					VendorRule vr = new VendorRule();
					vr.setRegexp(rule.getRegexp());
					vr.setValore_note_3(rule.getValore_note_3());
					vr.setStrategy(rule.getStrategy());
					vr.setScadenza(rule.getScadenza());
					vendorRules.add(vr);
				}
				vendorData.setRules(vendorRules);
				vendorDataList.add(vendorData);
			}
			returnStatus = HttpStatus.OK;
			response.setMessage("File Excel elaborato per ogni Vendor.");
			response.setSuccess(true);
			response.setTotal(vendorDataList.size());
			response.setData(vendorDataList);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
 		
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").include("data.discounts","data.rules").serialize(response), returnStatus);
		
	}

}
