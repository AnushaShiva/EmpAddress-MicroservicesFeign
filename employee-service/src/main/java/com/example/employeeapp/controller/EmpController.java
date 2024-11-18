package com.example.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.response.model.EmployeeWithAddressResponse;
import com.example.employeeapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmpController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	
	@GetMapping("/{eid}")
	public ResponseEntity<EmployeeWithAddressResponse> getEmployeeByID(@PathVariable int eid) {
		EmployeeWithAddressResponse em = employeeService.findById(eid);
		return ResponseEntity.status(HttpStatus.OK).body(em);
	}

}
