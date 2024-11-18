package com.example.addressapp.modelResponse;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private String state;
	private String city;
	private String pincode;
	
	
}
