package com.bank.LoanApp.Service;

import java.util.List;

import com.bank.LoanApp.model.Loan;

public interface LoanService {
	
	
	 public String NewLoan (Loan loan);
	List<Loan> getAllLoans();
    Loan getLoanById(Long loanId);
   public  void saveLoan(Loan loan);
   
   
   public String payEmi(Long loanId, double emiAmount);
   
  
   
   
    void deleteLoan(Long loanId);
	Double checkLoanBalance(Long loanId);
	double calculateInterestRate(String loanCategory);
    
}
