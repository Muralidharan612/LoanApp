package com.bank.LoanApp.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bank.LoanApp.Exception.CustomerNotFoundException;
import com.bank.LoanApp.Repository.AdminRepo;
import com.bank.LoanApp.Repository.LoanRepo;
import com.bank.LoanApp.model.Application;
import com.bank.LoanApp.model.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;



@Service
public class LoanServiceImpl implements LoanService {
	
	Loan laon;
	 Application application;

	 @Autowired
	 LoanRepo laonrepository;
	 
	 @Autowired
	 AdminRepo adminRepo;
	 
	 private static final double CAR_LOAN_INTEREST_RATE = 0.08;       // 8%
	    private static final double PERSONAL_LOAN_INTEREST_RATE = 0.1;   // 10%
	    private static final double HOUSE_LOAN_INTEREST_RATE = 0.06;     // 6%
	    private static final double BUSINESS_LOAN_INTEREST_RATE = 0.12;  // 12%
	 
	 
//============================================D (Admin)==================================================================================

	 //Getting all loan 
	//===============
	@Override
	public List<Loan> getAllLoans() {
		
		List <Loan> LoanList =  laonrepository.findAll();
	
        return LoanList;
	}

//=================================================================================================================================
	
	//============================================D (Admin/ Customer )==================================================================================

		 //Getting loan by Id 
		//===============
		
	@Override
	public Loan getLoanById(Long loanId) {
		Loan loan = laonrepository.findById(loanId)
				.orElseThrow(() -> new CustomerNotFoundException("Loan not found with ID: " +loanId ));
		
		return loan;
	}
	
//	//============================================Done (Admin )==================================================================================
//
//	 //Getting loan by Id 
//	//===============
//
	
	 @Override 
	 public void saveLoan(Loan loan) { }
	 

	@Override
	public void deleteLoan(Long loanId) {
        Loan loan = laonrepository.findById(loanId).orElseThrow(() -> new CustomerNotFoundException("Loan not found with ID: " +loanId ));
        double balamount = loan.getDebt_balance();
        if(balamount == 0 ) {
        	laonrepository.deleteById(loanId);
        
        	
        	
        }

		
	}

	//============================================D (Admin)==================================================================================

	 //Sanction Loan  loan 
	//===============
	@Override
	public String NewLoan(Loan loan) {
	    Application application = loan.getApplication();
	    if (application != null && application.getApplication_status().equals("Approved")) {
	        String loanCategory = loan.getLoanType(); 
	        double interestRate = calculateInterestRate(loanCategory);
	        double loanAmount = loan.getRequested_amount();
	        double totalAmount = loanAmount + (loanAmount * interestRate); 
	        loan.setDebt_balance(totalAmount); // Set the balance including the interest
	        laonrepository.save(loan);
	        return "Loan Sanctioned Successfully";
	    }
	    return "Pending Approval of Loan";
	}
	
	//============================================D (Customer )==================================================================================

	 //Pay Emi loan by Id 
	//===============

	  @Override
	    public String payEmi(Long loanId, double emiAmount) {
	        Loan loan = laonrepository.findById(loanId).orElseThrow(() -> new CustomerNotFoundException("Loan not found with ID: " +loanId ));
	        if (loan != null) {
	            double remainingBalance = loan.getDebt_balance() - emiAmount;
	            double setteledamount = loan.getSettled_amount()+emiAmount;
	            if (remainingBalance >= 0) {
	                loan.setDebt_balance(remainingBalance);
	                loan.setSettled_amount(setteledamount);
	                laonrepository.save(loan);
	                return "EMI payment successful. Remaining balance: " + remainingBalance;
	            } else if(remainingBalance == 0){
	            	
	                return "You paid all your loan Collect NOC from the nearest branch for this loan :" + loanId;
	            }
	        } else {
	            return "Loan not found with ID: " + loanId;
	        }
	        return null;
	    }
	
	//============================================D (Admin/ Customer )==================================================================================

		 //Check balance loan by Id 
		//===============

	  @Override
	    public Double checkLoanBalance(Long loanId) {
	        Loan loan = laonrepository.findById(loanId).orElseThrow(() -> new CustomerNotFoundException("Loan not found with ID: " +loanId ));
	        return loan != null ? loan.getDebt_balance() : null;
	    }
	  

	  @Override
	    public double calculateInterestRate(String loanCategory) {
	        switch (loanCategory.toLowerCase()) {
	            case "car":
	                return CAR_LOAN_INTEREST_RATE;
	            case "personal":
	                return PERSONAL_LOAN_INTEREST_RATE;
	            case "house":
	                return HOUSE_LOAN_INTEREST_RATE;
	            case "business":
	                return BUSINESS_LOAN_INTEREST_RATE;
	            default:
	                throw new IllegalArgumentException("Invalid loan category");
	        }
	    }
	

}
