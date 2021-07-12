package com.sport.cg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Address;
import com.sport.cg.exception.AddressNotFoundException;
import com.sport.cg.repository.IAddressRepository;

@Service
public class CAddressService implements IAddressService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CAddressService.class);
	
	@Autowired
	IAddressRepository iaddressRepository;
	
	@Override
	public Address addAddress(Address address){
		LOGGER.info("addAddress() service is initiated");
		Address addressentity = iaddressRepository.save(address);
		LOGGER.info("addAddress() service has executed");
		return addressentity;
	}
	
	@Override
	public Address removeAddress(Long custId){
		LOGGER.info("removeAddress() service is initiated");
		Address existaddress = iaddressRepository.findById(custId).orElse(null);
		if(existaddress == null)
		{
			throw new AddressNotFoundException("Address cannot be deleted. Customer Not Found");
		}
		else {
			iaddressRepository.delete(existaddress);
		}
		LOGGER.info("removeAddress() service has executed");
		return existaddress;
	}
	
	@Override
	public Address updateAddress(Long custId, Address address){
		LOGGER.info("updateAddress() service is initiated");
		Address addressentity = null;
		Address updateaddress = iaddressRepository.findById(custId).orElse(null);
		if(updateaddress == null)
		{
			throw new AddressNotFoundException("Address cannot be updated. Customer not found.");
		}
		else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("updateAddress() service has executed");
		return addressentity;
	}
	
	@Override
	public Address getAddress(Long custId){
		LOGGER.info("getAddress() service is initiated");
		Address getAddress = iaddressRepository.findById(custId).orElse(null);
		if(getAddress == null)
		{
			throw new AddressNotFoundException("Address cannot be found. Customer cannot be found.");
		}
		LOGGER.info("getAddress() service has executed");
		return getAddress;
	}
}
