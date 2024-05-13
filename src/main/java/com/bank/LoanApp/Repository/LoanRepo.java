package com.bank.LoanApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bank.LoanApp.model.Loan;


public interface LoanRepo   extends JpaRepository<Loan,Long>{

	List<Loan> findByApplication_ApplicationId(long parseLong);

	//List<Loan> findByApplication_ApplicationIdAndSettledAmountIsGreaterThan(long applicationId, double d);
	//public List<Loan> getAllLoan();

	//void save(Loan loan);
 
}
