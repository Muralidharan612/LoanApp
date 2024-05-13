package com.bank.LoanApp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Application")
public class Application {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long applicationId;

	    @ManyToOne
	    @JoinColumn(name = "CustomerId") // CustomerId is the foreign key column
	    private Customer customer;

	    @OneToMany(mappedBy = "application")
	    private List<Loan> loans;

	    @Column
	    private double amountRequested;

	    @Column
	    private String loanType;

	    @Column
	    private double interestRate;

	    @Column
	    private int loanPeriod;

	    @Column
	    private String application_status;
	
	
	public Application() {
		super();
		
	}


	public Application(long applicationId, Customer customer, List<Loan> loans, double amountRequested, String loanType,
			double interestRate, int loanPeriod, String application_status) {
		super();
		this.applicationId = applicationId;
		this.customer = customer;
		this.loans = loans;
		this.amountRequested = amountRequested;
		this.loanType = loanType;
		this.interestRate = interestRate;
		this.loanPeriod = loanPeriod;
		this.application_status = application_status;
	}


	public long getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Loan> getLoans() {
		return loans;
	}


	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}


	public double getAmountRequested() {
		return amountRequested;
	}


	public void setAmountRequested(double amountRequested) {
		this.amountRequested = amountRequested;
	}


	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public int getLoanPeriod() {
		return loanPeriod;
	}


	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}


	public String getApplication_status() {
		return application_status;
	}


	public void setApplication_status(String application_status) {
		this.application_status = application_status;
	}


	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", customer=" + customer + ", loans=" + loans
				+ ", amountRequested=" + amountRequested + ", loanType=" + loanType + ", interestRate=" + interestRate
				+ ", loanPeriod=" + loanPeriod + ", application_status=" + application_status + "]";
	}
	
}
	
	
	