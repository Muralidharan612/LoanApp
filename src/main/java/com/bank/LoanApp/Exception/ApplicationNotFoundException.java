package com.bank.LoanApp.Exception;

public class ApplicationNotFoundException extends RuntimeException {
	
	public ApplicationNotFoundException(String message) {
        super(message);
    }
}
