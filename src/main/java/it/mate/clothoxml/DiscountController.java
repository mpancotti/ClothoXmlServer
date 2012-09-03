package it.mate.clothoxml;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import it.mate.clothoxml.domain.Discount;
import it.mate.clothoxml.repository.DiscountRepInterface;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@RequestMapping("/discounts")
@Controller
public class DiscountController {

	private static final Logger logger = LoggerFactory
			.getLogger(DiscountController.class);
	
	@Autowired
	DiscountRepInterface discountRepository;
	
	// Lettura singolo Discount
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<String> showJson(@PathVariable("id") Integer id) {		
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			Discount discount = discountRepository.getDiscount(id);		
			if (discount == null) {
				returnStatus = HttpStatus.NOT_FOUND;
				response.setMessage("Discount not found.");
				response.setSuccess(false);
				response.setTotal(0L);
			} else {
				returnStatus = HttpStatus.OK;
				response.setMessage("Discount found.");
				response.setSuccess(true);
				response.setTotal(1L);
				response.setData(discount);
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}

	// Lettura di tutti i Discount
	@RequestMapping(headers = "Accept=application/json")
	public ResponseEntity<String> listJson() {
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			List<Discount> records = discountRepository.findAllDiscounts();
			returnStatus = HttpStatus.OK;
			response.setMessage("All Discounts retrieved.");
			response.setSuccess(true);
			response.setTotal(records.size());
			response.setData(records);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}

		// Return list of retrieved performance areas
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);

	}

	// Creazione nuovo Discount
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createFromJson(@RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {
			 //String test="{codice:198989, nome:'nome198989', strategy:'DESC'}";
			 Discount discount = Discount.fromJsonToDiscount(json);
			 discountRepository.add(discount);
			 
			returnStatus = HttpStatus.OK;
			response.setMessage("Discount created.");
			response.setSuccess(true);
			response.setTotal(1L);
			// response.setData(record);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		// return the created record with the new system generated id
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}

	// Modifica di Discount esistente
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<String> updateFromJson(@PathVariable("id") Integer id, @RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;
		JsonObjectResponse response = new JsonObjectResponse();
		try {			
			   Discount discount = Discount.fromJsonToDiscount(json);
			   discountRepository.update(discount,id);
				returnStatus = HttpStatus.OK;
				response.setMessage("Discount updated.");
				response.setSuccess(true);
				response.setTotal(1L);
			    response.setData(discount);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		// return the updated record
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}

	// Cancellazione di Discount esistente
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromJson(@PathVariable("id") Integer id) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {
			
			discountRepository.delete(id);
			returnStatus = HttpStatus.OK;
			response.setMessage("Discount deleted.");
			response.setSuccess(true);
			response.setTotal(1L);
			// response.setData(record);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}

		// Return just the deleted id
		return new ResponseEntity<String>(new JSONSerializer()
				.exclude("*.class").serialize(response), returnStatus);
	}

}
