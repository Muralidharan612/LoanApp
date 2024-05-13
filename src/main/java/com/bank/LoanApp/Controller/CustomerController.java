package com.bank.LoanApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.LoanApp.Service.ApplicationService;
import com.bank.LoanApp.Service.CustomerService;
import com.bank.LoanApp.Service.LoanService;
import com.bank.LoanApp.model.Application;
import com.bank.LoanApp.model.Customer;
import com.bank.LoanApp.model.Loan;

import java.util.List;

@RestController
public class CustomerController {
	
	@Autowired
	 CustomerService customerService;

	@Autowired
   ApplicationService applicationService;
	
	@Autowired
	LoanService loanService;

	
   //=======================================Done==========================================================//
	
	//Creating New Loan Application  by Customer 
    @PostMapping("/Customer/newLoan")
    public ResponseEntity<String> createNewApplication(@RequestBody Application application) {
        String result = applicationService.NewApplication(application);
        return ResponseEntity.ok(result);
    
    }
 //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    //View Customer details 
    //=======================================Done==========================================================//
    @GetMapping("/Customer/ViewMy{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }
 //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    

//getting loan details by Application id 
    //=======================================Done==========================================================//
    @GetMapping("/Customer/AppNo{applicationId}")
    public ResponseEntity<Application> getApplicationById(@PathVariable String applicationId) {
        Application application = applicationService.getApplicationById(applicationId);
        return ResponseEntity.ok(application);
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
  //For Displaying Specific loan using loan Id
	
	  @GetMapping("/Customer/{loanId}") 
	  public ResponseEntity<Loan> getLoanById(@PathVariable Long loanId) {
	        Loan loan = loanService.getLoanById(loanId);
	        return ResponseEntity.ok(loan);
	  }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	    

    
    @PutMapping("/Customer/PayEmi/{loanid}/{amount}")
    public ResponseEntity<String> payEmi(@PathVariable("loanid") long loanId, @PathVariable("amount") Double amount) {
        // Check if amount is null 	
        if (amount == null) {
          
            throw new IllegalArgumentException("Amount cannot be null");
        }
        
        String result = loanService.payEmi(loanId, amount);
        return ResponseEntity.ok(result);
    }

    }
    
