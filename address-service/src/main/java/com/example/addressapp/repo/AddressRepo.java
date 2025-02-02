package com.example.addressapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.addressapp.entity.Address;

@Repository
public interface AddressRepo  extends JpaRepository<Address, Integer>{

}
