package com.example.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeAppConfig {

	
	
	/*
	 * @Value("${Address-baseurl}") private String addressBaseUrl;
	 */
	  
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	  
	  
	/*
	 * @Bean public WebClient webClient() { return
	 * WebClient.builder().baseUrl(addressBaseUrl).build(); }
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	 
}
