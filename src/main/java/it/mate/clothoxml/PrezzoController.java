package it.mate.clothoxml;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import it.mate.clothoxml.domain.Prezzo;
import it.mate.clothoxml.domain.Sconto;
import it.mate.clothoxml.repository.PrezzoRepInterface;

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
@RequestMapping("/prezzi")
@Controller
public class PrezzoController {

	private static final Logger logger = LoggerFactory
			.getLogger(PrezzoController.class);
	
	@Autowired
	PrezzoRepInterface prezzoRepository;
	
	// Lettura singolo Prezzo
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<String> showJson(@PathVariable("id") Integer id) {		
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			Prezzo prezzo = prezzoRepository.getPrezzo(id);		
			if (prezzo == null) {
				returnStatus = HttpStatus.NOT_FOUND;
				response.setMessage("Prezzo not found.");
				response.setSuccess(false);
				response.setTotal(0L);
			} else {
				returnStatus = HttpStatus.OK;
				response.setMessage("Prezzo found.");
				response.setSuccess(true);
				response.setTotal(1L);
				response.setData(prezzo);
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}
	
	// Lettura di tutti i prezzi di un certo Rule
	@RequestMapping( method = RequestMethod.GET, headers = "Accept=application/json", params="rule")
	public ResponseEntity<String> listJsonOfRule(@RequestParam("rule") Integer rule) {
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			List<Prezzo> records = prezzoRepository.findPrezziOfRule(rule);
			returnStatus = HttpStatus.OK;
			response.setMessage("All Prezzi retrieved.");
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
	

	// Lettura di tutti i Prezzo
	@RequestMapping(headers = "Accept=application/json")
	public ResponseEntity<String> listJson() {
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			List<Prezzo> records = prezzoRepository.findAllPrezzi();
			returnStatus = HttpStatus.OK;
			response.setMessage("All Prezzi retrieved.");
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

	// Creazione nuovo Prezzo
	@RequestMapping(value = "/{id}",method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createFromJson(@RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {
			 //String test="{codice:198989, nome:'nome198989', strategy:'DESC'}";
			Prezzo prezzo = Prezzo.fromJsonToPrezzo(json);
			prezzoRepository.add(prezzo);
			returnStatus = HttpStatus.OK;
			response.setMessage("Prezzo created.");
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

	// Modifica di Prezzo esistente
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<String> updateFromJson(@PathVariable("id") Integer id, @RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;
		JsonObjectResponse response = new JsonObjectResponse();
		try {			
			   Prezzo prezzo = Prezzo.fromJsonToPrezzo(json);
			   prezzoRepository.update(prezzo,id);
				returnStatus = HttpStatus.OK;
				response.setMessage("Prezzo updated.");
				response.setSuccess(true);
				response.setTotal(1L);
			    response.setData(prezzo);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		// return the updated record
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}

	// Cancellazione di Prezzo esistente
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromJson(@PathVariable("id") Integer id) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {
			
			prezzoRepository.delete(id);
			returnStatus = HttpStatus.OK;
			response.setMessage("Prezzo deleted.");
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
