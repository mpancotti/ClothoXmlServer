package it.mate.clothoxml;

import it.mate.clothoxml.domain.Vendor;
import it.mate.clothoxml.repository.VendorRepInterface;
import it.mate.clothoxml.repository.VendorRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import flexjson.JSONSerializer;

/**
 * Handles requests for the application home page.
 */
@RequestMapping("/vendors")
@Controller
public class VendorController {

	private static final Logger logger = LoggerFactory
			.getLogger(VendorController.class);
	
	@Autowired
	VendorRepInterface vendorRepository;
	
	// Lettura singolo Vendor
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<String> showJson(@PathVariable("id") String id) {		
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			Vendor vendor = vendorRepository.getVendor(id);		
			if (vendor == null) {
				returnStatus = HttpStatus.NOT_FOUND;
				response.setMessage("Vendor not found.");
				response.setSuccess(false);
				response.setTotal(0L);
			} else {
				returnStatus = HttpStatus.OK;
				response.setMessage("Vendor found.");
				response.setSuccess(true);
				response.setTotal(1L);
				response.setData(vendor);
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}

	// Lettura di tutti i Vendor
	@RequestMapping(headers = "Accept=application/json")
	public ResponseEntity<String> listJson() {
		HttpStatus returnStatus = HttpStatus.OK;
		JsonObjectResponse response = new JsonObjectResponse();

		try {
			List<Vendor> records = vendorRepository.findAllVendors();
			returnStatus = HttpStatus.OK;
			response.setMessage("All Vendors retrieved.");
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

	// Creazione nuovo Vendor
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createFromJson(@RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {/*
			 * Vendor record = Vendor.fromJsonToVendor(json); record.persist();
			 */
			returnStatus = HttpStatus.CREATED;
			response.setMessage("Vendor created.");
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

	// Modifica di Vendor esistente
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<String> updateFromJson(@RequestBody String json) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {
			/*
			 * Vendor record = Vendor.fromJsonToVendor(json); Vendor
			 * mergedRecord = (Vendor)record.merge(); if (mergedRecord == null)
			 * { returnStatus = HttpStatus.NOT_FOUND;
			 * response.setMessage("Vendor update failed.");
			 * response.setSuccess(false); response.setTotal(0L); } else
			 */{
				returnStatus = HttpStatus.OK;
				response.setMessage("Vendor updated.");
				response.setSuccess(true);
				response.setTotal(1L);
				// response.setData(mergedRecord);
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setTotal(0L);
		}
		// return the updated record
		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").serialize(response), returnStatus);
	}

	// Cancellazione di Vendor esistente
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
		HttpStatus returnStatus = HttpStatus.BAD_REQUEST;

		JsonObjectResponse response = new JsonObjectResponse();
		try {/*
			 * Vendor record = Vendor.findVendor(id); record.remove();
			 */
			returnStatus = HttpStatus.OK;
			response.setMessage("Vendor deleted.");
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
				.exclude("*.class").include("data.codice").exclude("data.*")
				.serialize(response), returnStatus);
	}

}
