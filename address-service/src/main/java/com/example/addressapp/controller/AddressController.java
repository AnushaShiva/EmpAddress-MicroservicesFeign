package com.example.addressapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressapp.entity.Address;
import com.example.addressapp.modelResponse.AddressResponse;
import com.example.addressapp.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/save")
	public Address save(@RequestBody Address add) {
		return addressService.save(add);
	}

	
	@GetMapping("/{aid}")
	public ResponseEntity<AddressResponse> getAddressByID(@PathVariable int aid) {
		AddressResponse rs = addressService.findAddressByID(aid);
		return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
	
	/*
	 * @GetMapping("/{aid}") public Address getByID(@PathVariable int aid) { return
	 * addressService.findAddressByID(aid); }
	 */
}
