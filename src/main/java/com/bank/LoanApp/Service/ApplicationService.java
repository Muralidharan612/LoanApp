package com.bank.LoanApp.Service;

import java.util.List;

import com.bank.LoanApp.model.Application;

public interface ApplicationService {
	//Admin 
   public List<Application> getAllApplications();
   
   //Customer And Admin
   public Application getApplicationById(String applicationId);
   
   //Customer
   public String NewApplication( Application application);
   

   
   //Admin
   public String deleteApplication(String applicationId);
   
   
   //Admin 
   public void updateStatus(String applicationId, String Status);

   //Admin Sanction Loan 
   public String sanctionLoan(String applicationId );
}
