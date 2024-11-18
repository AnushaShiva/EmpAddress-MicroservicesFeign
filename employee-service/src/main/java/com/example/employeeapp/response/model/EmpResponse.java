package com.example.employeeapp.response.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpResponse {

	private int eid;
	private String name;
	private String email;
	private String bloodGrp;
	//private int aid;
	
}
