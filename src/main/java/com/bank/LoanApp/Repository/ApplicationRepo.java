package com.bank.LoanApp.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.LoanApp.model.Application;


public interface ApplicationRepo  extends JpaRepository<Application, String>{

	//List<Application> findByCustomer_CustomerId(String customerId);
	//public List<Application> getAllApplication();

//	public void save(Application application);

}
