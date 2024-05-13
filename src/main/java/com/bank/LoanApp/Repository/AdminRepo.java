package com.bank.LoanApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.LoanApp.model.Admin;
import com.bank.LoanApp.model.Customer;

public interface AdminRepo  extends JpaRepository <Admin, String > {

//	Optional<Admin> findByUsername(String username);
	
	
}
