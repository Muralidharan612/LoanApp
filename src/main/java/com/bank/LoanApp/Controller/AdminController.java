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
public class AdminController {

@Autowired
 CustomerService customerService;

@Autowired
LoanService loanService;

@Autowired
ApplicationService applicationService;


//=======================================Done==========================================================//
@PostMapping("/Admin/createNewCustomer")
public ResponseEntity<String>   CreteNewCustomer(@RequestBody Customer customer) {
	String result= customerService.CreateNewCustomer(customer);
	return ResponseEntity.ok(result);
}
//=======================================Done==========================================================//
    @GetMapping ("/Admin/displayAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    
    
 //=======================================Done==========================================================//
    @GetMapping("/Admin/View{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }
    
    
    
  //=======================================Done==========================================================//    
    @PutMapping("/Admin/UpdateCredit{customerId}/creditscore{CreditScore}")
    public  void UpdateCreditScore ( @PathVariable String customerId, @PathVariable int CreditScore) {
    	customerService.UpadteCustomerCreditScore(customerId,CreditScore );
    }
    
    //=======================================Done==========================================================//
    @PutMapping("/Admin/Remove{customerId}")
    public ResponseEntity<String> deactivateCustomer(@PathVariable String customerId) {
        customerService.DeactiveCustomer(customerId);
        return ResponseEntity.ok("Deactivated");
    }
    
//============================================================================================================================================//
    
    
    
//=======================================Done==========================================================================//
    @GetMapping("/Admin/displayApplications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }
    
    
    //======================================Done============================================================//
    @PutMapping("/Admin/upadtestatus{applicationId}/Status{status}")
    public ResponseEntity<String> updateApplicationStatus(@PathVariable String applicationId, @PathVariable String status) {
       applicationService.updateStatus(applicationId, status);
        return ResponseEntity.ok("Application Status Updated Successfully" );
}
    
    @PutMapping("/Admin/sanctionLoan ApplicationId{applicationId}")
    public String sanctionLoan(@PathVariable String applicationId) {
       
     return  applicationService.sanctionLoan(applicationId);
     
    }


    //=======================================Done==========================================================//
    //Disapaly all loans
    @GetMapping("/Admin/ViewAllLoans")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }
    
    //=======================================Done==========================================================//
    //For Displaying Specific loan 
    @GetMapping("/Admin/ViewLoan{loanId}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long loanId) {
        Loan loan = loanService.getLoanById(loanId);
        return ResponseEntity.ok(loan);
    }
    
    
  //=======================================Done==========================================================//
    
    //For deleting closed loan or for update loan status (i.e) closed...(May change delete to put method)
    @DeleteMapping("/Admin/DeleteLoan{loanId}")
    public ResponseEntity<String > deleteLoan(@PathVariable Long loanId) {
        loanService.deleteLoan(loanId);
        return ResponseEntity.ok("Loan deleted Successfully");
    }
        
  
    
    
  //=======================================Done==========================================================//
  
    
    @DeleteMapping("/Admin/Delete{applicationId}")
    public ResponseEntity<String> deleteApplication(@PathVariable String applicationId) {
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.ok("Application deleted Successfully");
    }
    
    
  //=========================================================================================
  
    
    @GetMapping("/Admin/GetDebtBalance/{loanid}")
    public ResponseEntity<Double> getDebtBalance(@PathVariable long loanId) {
        double debtBalance = loanService.checkLoanBalance(loanId);
        return ResponseEntity.ok(debtBalance);    	
    }

    
    
    
	/*
	 * @PutMapping("/UpdateStatus{applicationId}/Status{Status}") public void
	 * UpdateCreditScore( @PathVariable String applicationId ,
	 * 
	 * @PathVariable String Status) { applicationService.updateStatus(applicationId,
	 * Status); }
	 */
}


