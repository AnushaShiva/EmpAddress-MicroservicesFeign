package com.example.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.addressapp.entity.Address;
import com.example.addressapp.modelResponse.AddressResponse;
import com.example.addressapp.repo.AddressRepo;

@Service
public class AddressService {

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	ModelMapper modelMapper;

	public Address save(@RequestBody Address add) {
		return addressRepo.save(add);
	}

	/*
	 * public Address findAddressByID(int aid) { Address as =
	 * addressRepo.findById(aid).get(); return as; }
	 */

	public AddressResponse findAddressByID(int aid) {

		// AddressResponse addressResponse = new AddressResponse();
		Address add = addressRepo.findById(aid).get();
		return modelMapper.map(add, AddressResponse.class);

	}

}
