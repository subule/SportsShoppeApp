package com.sport.cg.service;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Address;

@Service
public interface IAddressService {
	
	public Address addAddress(Address address);
	public Address removeAddress(Long custId);
	public Address updateAddress(Long custId,Address address);
	public Address getAddress(Long custId);

}
