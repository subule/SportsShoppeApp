package com.sport.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.cg.entity.Address;
import com.sport.cg.service.IAddressService;

@RestController
@RequestMapping("/addressesweb/api")
public class AddressController {
	
static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	IAddressService addressServiceImpl;

	@PostMapping("/addresses")
	public ResponseEntity<Address> addAddress(@RequestBody Address address){
		LOGGER.info("addAddress URL is opened");
		LOGGER.info("addAddress() is initiated");
		LOGGER.info("addAddress() has executed");
		return new ResponseEntity<Address>(addressServiceImpl.addAddress(address), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/addresses/{custId}")
	public ResponseEntity<Address> removeAddress(@PathVariable Long custId){
		LOGGER.info("removeAddress URL is opened");
		LOGGER.info("removeAddress() is initiated");
		LOGGER.info("removeAddress() has executed");
		return new ResponseEntity<Address>(addressServiceImpl.removeAddress(custId), HttpStatus.OK);
	}

	@PutMapping("/addresses/{custId}")
	public ResponseEntity<Address> updateAddress(@PathVariable Long custId,@RequestBody Address address){
		LOGGER.info("updateAddress URL is opened");
		LOGGER.info("updateAddress() is initiated");
		LOGGER.info("updateAddress() has executed");
		return new ResponseEntity<Address>(addressServiceImpl.updateAddress(custId, address), HttpStatus.OK);
	}

	@GetMapping("/addresses/{custId}")
	public ResponseEntity<Address> getAddress(@PathVariable Long custId){
		LOGGER.info("getAddressDetails URL is opened");
		LOGGER.info("getAddress() is initiated");
		LOGGER.info("getAddress() has executed");
		return new ResponseEntity<Address>(addressServiceImpl.getAddress(custId), HttpStatus.OK);
	}

}
