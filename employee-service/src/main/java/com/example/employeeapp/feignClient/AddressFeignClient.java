package com.example.employeeapp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employeeapp.response.model.AddressResponse;

//http://localhost:8081/address/1
@FeignClient(name="ADDRESS-SERVICE",url="http://localhost:8081/address")
public interface AddressFeignClient {

	@GetMapping("/{aid}")
	AddressResponse  getAddressByID(@PathVariable("aid")int eid);
}
