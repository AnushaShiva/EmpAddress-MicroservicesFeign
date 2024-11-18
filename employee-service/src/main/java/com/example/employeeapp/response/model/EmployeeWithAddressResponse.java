package com.example.employeeapp.response.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeWithAddressResponse {

	
	private EmpResponse empResponse;
	private AddressResponse addressResponse;

}
