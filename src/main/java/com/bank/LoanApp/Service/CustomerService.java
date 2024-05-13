package com.bank.LoanApp.Service;

import java.util.List;

import com.bank.LoanApp.model.Customer;

public interface CustomerService {
	//Admin Create new customer
			public String CreateNewCustomer(Customer customer);

	
	//Admin
	public  List<Customer> getAllCustomers();
	
	//Admin
	    public Customer getCustomerById(String customerId);
	 
	    // void saveCustomer(Customer customer);
	    
	    //Delete Customer 
	    Customer DeactiveCustomer(String customerId);
	    
	    
	    
	    //Admin 
	    public String UpadteCustomerCreditScore(String customerId, int CreditScore);
	    
	    //Admin willupdate the customer account status 
	    public boolean isCustomerActive();


		
	    
	    

}
