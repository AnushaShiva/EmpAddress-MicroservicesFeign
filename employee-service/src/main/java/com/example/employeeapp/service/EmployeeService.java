package com.example.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.feignClient.AddressFeignClient;
import com.example.employeeapp.repo.EmployeeRepository;
import com.example.employeeapp.response.model.AddressResponse;
import com.example.employeeapp.response.model.EmpResponse;
import com.example.employeeapp.response.model.EmployeeWithAddressResponse;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	/*
	 * @Autowired AddressFeignClient addressFeignClient;
	 */

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Autowired
	RestTemplate restTemplate;

	/*
	 * @Autowired WebClient webClient;
	 */

	public EmployeeWithAddressResponse findById(int eid) {
		EmployeeWithAddressResponse empwithAdd = new EmployeeWithAddressResponse();

		Employee emp = employeeRepository.findById(eid).get();
		EmpResponse empResponse = modelMapper.map(emp, EmpResponse.class);

		// using model mapper we are not mapping the column data manually like below
		// empResponse.setEmail(emp.getEmail());

		// actually RestTemplate blocked the thread untill it get the data from
		// otherservice means like sync
		// using feign we are called
		// AddressResponse addResponse = addressFeignClient.getAddressByID(eid);
		
		//using loadBalancerClient we can balance the load of servers using springcloudloadbalancer

		ServiceInstance ser = loadBalancerClient.choose("ADDRESS-SERVICE");
		String uri = ser.getUri().toString();
		System.out.println(uri);
		AddressResponse addResponse = restTemplate.getForObject(uri+"/address/{eid}", AddressResponse.class,eid);

		
		/*
		 * webClient.get().uri(" "+empResponse.getAid())
		 * .retrieve().bodyToMono(AddressResponse.class).block();
		 */
		// so avoid these we use ReactiveWebFlux like Async nature
		empwithAdd.setEmpResponse(empResponse);
		empwithAdd.setAddressResponse(addResponse);
		return empwithAdd;

		
	}

	public Employee save(Employee emp) {
		return employeeRepository.save(emp);

	}

}
