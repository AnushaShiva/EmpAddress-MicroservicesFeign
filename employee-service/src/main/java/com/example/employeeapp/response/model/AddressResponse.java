package com.example.employeeapp.response.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressResponse {

	private int aid;
	private String state;
	private String city;
	private String pincode;
	
}
