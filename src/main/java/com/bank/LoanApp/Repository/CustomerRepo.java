package com.bank.LoanApp.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bank.LoanApp.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,String> {

	Customer findByPhoneNumberAndName(String phoneNumber, String name);

	//Optional<Customer> findByUsername(String username);
	

	



}
