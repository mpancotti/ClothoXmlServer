package it.mate.clothoxml;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import it.mate.clothoxml.domain.Rule;
import it.mate.clothoxml.repository.RuleRepInterface;

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
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@RequestMapping("/rules")
@Controller
public class RuleController {

	private static final Logger logger = LoggerFactory
			.getLogger(RuleController.class);
	
	@Autowired
	RuleRepInterface ruleRepository;
	
	// Lettura singolo Rule
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<String> showJson(@PathVariable("id") Integer id) {		
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			Rule rule = ruleRepository.getRule(id);		
			if (rule == null) {
				returnStatus = HttpStatus.NOT_FOUND;
				response.setMessage("Rule not found.");
				response.setSuccess(false);
				response.setTotal(0L);
			} else {
				returnStatus = HttpStatus.OK;
				response.setMessage("Rule found.");
				response.setSuccess(true);
				response.setTotal(1L);
				response.setData(rule);
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}
	
	// Lettura di tutti i Rule di un certo Vendor
	@RequestMapping( method = RequestMethod.GET, headers = "Accept=application/json", params="vendor")
	public ResponseEntity<String> listJsonOfVendor(@RequestParam("vendor") Integer vendor) {
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			List<Rule> records = ruleRepository.findRulesOfVendor(vendor);
			returnStatus = HttpStatus.OK;
			response.setMessage("All Rules retrieved.");
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

	// Lettura di tutti i Rule
	@RequestMapping(headers = "Accept=application/json")
	public ResponseEntity<String> listJson() {
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			List<Rule> records = ruleRepository.findAllRules();
			returnStatus = HttpStatus.OK;
			response.setMessage("All Rules retrieved.");
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

	// Creazione nuovo Rule
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createFromJson(@RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {
			 //String test="{codice:198989, nome:'nome198989', strategy:'DESC'}";
			Rule rule = Rule.fromJsonToRule(json);
			ruleRepository.add(rule);
			returnStatus = HttpStatus.OK;
			response.setMessage("Rule created.");
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

	// Modifica di Rule esistente
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<String> updateFromJson(@PathVariable("id") Integer id, @RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;
		JsonObjectResponse response = new JsonObjectResponse();
		try {			
			   Rule rule = Rule.fromJsonToRule(json);
			   ruleRepository.update(rule,id);
				returnStatus = HttpStatus.OK;
				response.setMessage("Rule updated.");
				response.setSuccess(true);
				response.setTotal(1L);
			    response.setData(rule);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		// return the updated record
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}

	// Cancellazione di Rule esistente
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromJson(@PathVariable("id") Integer id) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {
			
			ruleRepository.delete(id);
			returnStatus = HttpStatus.OK;
			response.setMessage("Rule deleted.");
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
