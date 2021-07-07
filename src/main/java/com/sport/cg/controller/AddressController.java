package com.sport.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/addresses")
public class AddressController {
	
static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private IAddressService addressServiceImpl;

	@PostMapping("/addAddress")
	public Address addAddress(@RequestBody Address address){
		LOGGER.info("addAddress URL is opened");
		LOGGER.info("addAddress() is initiated");
		LOGGER.info("addAddress() has executed");
		return addressServiceImpl.addAddress(address);
	}

	@DeleteMapping("/removeAddress/Address/{custId}")
	public Address removeAddress(@PathVariable long custId){
		LOGGER.info("removeAddress URL is opened");
		LOGGER.info("removeAddress() is initiated");
		LOGGER.info("removeAddress() has executed");
		return addressServiceImpl.removeAddress(custId);
	}

	@PutMapping("/updateAddress/{custId}")
	public Address updateAddress(@PathVariable long custId,@RequestBody Address address){
		LOGGER.info("updateAddress URL is opened");
		LOGGER.info("updateAddress() is initiated");
		LOGGER.info("updateAddress() has executed");
		return addressServiceImpl.updateAddress(custId, address);
	}

	@GetMapping("/getAddressDetails/{custId}")
	public Address getAddress(@PathVariable long custId){
		LOGGER.info("getAddressDetails URL is opened");
		LOGGER.info("getAddress() is initiated");
		LOGGER.info("getAddress() has executed");
		return addressServiceImpl.getAddress(custId);
	}

}
