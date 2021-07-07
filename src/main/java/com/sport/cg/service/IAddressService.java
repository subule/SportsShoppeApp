package com.sport.cg.service;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Address;

@Service
public interface IAddressService {
	
	public Address addAddress(Address address);
	public Address removeAddress(long custId);
	public Address updateAddress(long custId,Address address);
	public Address getAddress(long custId);

}
