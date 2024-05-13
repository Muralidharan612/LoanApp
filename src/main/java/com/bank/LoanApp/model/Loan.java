package com.bank.LoanApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long loanId;
	    
	  @OneToOne
	    @JoinColumn(name = "application_id")
	  @JsonIgnore
	    private Application application;
	    
	    @Column
	    private String loanType;
	    
	    @Column
	    private double requested_amount;
	    
	  
	    
	    @Column
	    private double debt_balance;
	    
	    @Column
	    private double settled_amount;
	    
	    @Column
	    private double interestRate;
	    
	    @Column
	    private int loanPeriod;

	    public long getLoanId() {
	        return loanId;
	    }

	    public void setLoanId(long loanId) {
	        this.loanId = loanId;
	    }

	    public Application getApplication() {
	        return application;
	    }

	    public void setApplication(Application application) {
	        this.application = application;
	    }

	    public String getLoanType() {
	        return loanType;
	    }

	    public void setLoanType(String loanType) {
	        this.loanType = loanType;
	    }

	    public double getRequested_amount() {
	        return requested_amount;
	    }

	    public void setRequested_amount(double requested_amount) {
	        this.requested_amount = requested_amount;
	    }

	   

	    public double getDebt_balance() {
	        return debt_balance;
	    }

	    public void setDebt_balance(double debt_balance) {
	        this.debt_balance = debt_balance;
	    }

	    public double getSettled_amount() {
	        return settled_amount;
	    }

	    public void setSettled_amount(double settled_amount) {
	        this.settled_amount = settled_amount;
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

	    @Override
	    public String toString() {
	        return "Loan{" +
	                "loanId=" + loanId +
	                ", application=" + application +
	                ", loanType='" + loanType + '\'' +
	                ", requested_amount=" + requested_amount +
	              
	                ", debt_balance=" + debt_balance +
	                ", settled_amount=" + settled_amount +
	                ", interestRate=" + interestRate +
	                ", loanPeriod=" + loanPeriod +
	                '}';
	    }
	}

