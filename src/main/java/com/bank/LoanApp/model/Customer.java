package com.bank.LoanApp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Customer {
    
	   @Id
	    @Column(nullable = false, unique = true)
	    private String customerId;

	    @OneToMany(mappedBy = "customer")
	    private List<Application> applications;

	    @Column(nullable = false)
	    @JsonIgnore
	    private String password;

	    @Column(nullable = false)
	    private String role; // Adding role attribute

	    @Column
	    private String name;

	    @Column
	    private String phoneNumber;

	    @Column
	    private String employmentStatus;

	    @Column
	    private double monthlyIncome;

	    @Column
	    private int creditScore;

	    private boolean isActive;


    public Customer() {
        super();
    }

    public Customer(String customerId, String name, String phoneNumber, String employmentStatus, double monthlyIncome, int creditScore, boolean isActive, String password, String role) {
    	  this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.employmentStatus = employmentStatus;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
        this.isActive = isActive;
        this.password = password;
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", password=" + password + ", role=" + role + ", name=" + name
                + ", phoneNumber=" + phoneNumber + ", employmentStatus=" + employmentStatus + ", monthlyIncome="
                + monthlyIncome + ", creditScore=" + creditScore + ", isActive=" + isActive + "]";
    }

}
