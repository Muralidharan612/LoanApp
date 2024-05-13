package com.bank.LoanApp.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.LoanApp.Exception.CustomerNotFoundException;
import com.bank.LoanApp.Repository.ApplicationRepo;
import com.bank.LoanApp.Repository.CustomerRepo;
import com.bank.LoanApp.model.Application;
import com.bank.LoanApp.model.Customer;



@Service
public class CustomerServiceImpl implements CustomerService {

	private static final String FIXED_PART = "GENLOAN612";
	private static final SecureRandom random = new SecureRandom();
	
CustomerRepo CustomerRepository;

@Autowired
public CustomerServiceImpl(CustomerRepo customerRepository) {
    this.CustomerRepository=customerRepository ;}
	

@Autowired
ApplicationRepo applicationRepository;

//=================================Creating New Customer ==================================================//

//Creating New Customer
@Override
public String CreateNewCustomer(Customer customer) {
	

	Customer existingCustomer = CustomerRepository.findByPhoneNumberAndName(customer.getPhoneNumber(), customer.getName());

    if (existingCustomer != null) {
        // Customer with the same phone number and name already exists
        return "Customer with the same phone number and name already exists: " + existingCustomer.getCustomerId();
    } else {
	
    String generatedPassword = generatepassword();
    String generatedcustomerId=  generateUniqueId();
    
    customer.setCustomerId(generatedcustomerId);
    customer.setPassword(generatedPassword);
    
    


	CustomerRepository.save(customer);
	
	return "New Customer Created Suucesssfully" +  "Please note Customer ID: " + customer.getCustomerId();
}
}
//==================================================



private String generateUniqueId() {
    
    SecureRandom random = new SecureRandom();
    String prefix = "CUS"; // Prefix for customer ID
    String numericId = String.valueOf(random.nextInt(10000)); 
    String uniqueId = prefix + numericId;

    
    while (CustomerRepository.existsById(uniqueId)) {
        numericId = String.valueOf(random.nextInt(10000)); // Generate a new random 4-digit number
        uniqueId = prefix + numericId;
    }

    return uniqueId;
}
private  String generatepassword() 


{
	
    StringBuilder password = new StringBuilder(FIXED_PART);

    // Append four random numbers
    for (int i = 0; i < 4; i++) {
        password.append(random.nextInt(10)); // Generate a random digit (0-9)
    }

    return password.toString();
}



//=================================Get All customer Details ==================================================//


@Override
	public List<Customer> getAllCustomers() {
		List <Customer> CustList =CustomerRepository.findAll();	
		
		return CustList;
	}



//=====================================Get Customer by Customer Id==============================================//

@Override
	public Customer getCustomerById(String customerId) {
	 Optional<Customer> customerOptional = CustomerRepository.findById(customerId);
     if (customerOptional.isPresent()) {
         return customerOptional.get();
     } else {
         throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
     }
 }

//===============================Deactive Customer by Customer ID====================================================//
	@Override
	public Customer DeactiveCustomer(String  customerId) {
		Customer customer = CustomerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
		
        customer.setActive(false);
        return CustomerRepository.save(customer);
    }
	
	
	
//====================================Update Customer Credit Score===============================================//
	
	public String UpadteCustomerCreditScore(String customerId, int CreditScore) {
		Customer customer = CustomerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
        customer.setCreditScore(CreditScore);
        CustomerRepository.save(customer);
        return "Credit Score updated successfully for customer with ID: " + customerId;
		}


	@Override
	public boolean isCustomerActive() {
	
		
		return true;
	}

	
}
