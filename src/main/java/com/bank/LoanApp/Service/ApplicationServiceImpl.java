package com.bank.LoanApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.LoanApp.Exception.ApplicationNotFoundException;
import com.bank.LoanApp.Repository.ApplicationRepo;
import com.bank.LoanApp.Repository.LoanRepo;
import com.bank.LoanApp.model.Application;
import com.bank.LoanApp.model.Loan;

import jakarta.transaction.Transactional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    Application application;

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    LoanRepo loanrepository;

	Loan loan;
	
	 @Autowired
	 LoanService loanService;
	 
    //===========================================Get All Application  // (ADMIN)===================================================//
    @Override
    public List<Application> getAllApplications() {
        List<Application> ApptList = applicationRepo.findAll();

        return ApptList;
    }

    //===========================================Get Specific Application // (ADMIN)===================================================//

    @Override
    public Application getApplicationById(String applicationId) {
    	Optional<Application> applicOptional= applicationRepo.findById(applicationId);
    	if(applicOptional.isPresent()) {
    		return applicOptional.get();
    	}else {
    		throw new ApplicationNotFoundException("Application Not Found with the id :" + applicationId);
    	}
       
    }

    //============================================Create New Application(Customer)===================================================//

    @Override
    public String NewApplication(Application application) {
         application.setApplication_status("Submiited");
        applicationRepo.save(application);
        return "New Application Created Successfully" + "Please note Application ID: " + application.getApplicationId();
    }

    //============================================Delete customer // application(Admin)===================================================//

    @Override
    public String deleteApplication(String applicationId) {
    	Application application = applicationRepo.findById(applicationId)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found with ID: " + applicationId));
        if (application.getApplication_status().equals("Submitted")) {
            applicationRepo.delete(application);
            return "Application deleted";
        } else {
            return "Cannot delete application with status other than 'Submitted'";
        }

    }

    //============================================Update Status of customer // application(Admin)===================================================//

    @Override
    public void updateStatus(String applicationId, String status) {
        Optional<Application> optionalApplication = applicationRepo.findById(applicationId);
        if (optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setApplication_status(status);

            
            applicationRepo.save(application);
            

           
        
        } else {
            // Handle the case where the application with the specified ID does not exist
          throw new ApplicationNotFoundException("Application with ID " + applicationId + " not found");
        }
        }
    

	
    //================================
    @Override
    @Transactional
    public String sanctionLoan(String applicationId) {
    	
    	
        Application app = getApplicationById(applicationId);
        String status = app.getApplication_status();
        if (status.equals("Approved")) {
            //  if a loan already exists for the application
            List<Loan> existingLoans = loanrepository.findByApplication_ApplicationId(Long.parseLong(applicationId));
            
            if (!existingLoans.isEmpty()) {
                // A loan already exists for the application
                return "Loan has already been sanctioned for this application";
            }
            // Create a new Loan object 
            Loan loan = new Loan();
            loan.setApplication(app);
            loan.setDebt_balance(0);
            loan.setInterestRate(app.getInterestRate());
            loan.setLoanPeriod(app.getLoanPeriod());
            loan.setLoanType(app.getLoanType());
            loan.setRequested_amount(app.getAmountRequested());
            loan.setSettled_amount(0);
            
      
         
            loanrepository.save(loan);
            loanService.NewLoan(loan);

            // success message , the ID of the saved loan
            return "Loan sanctioned successfully with ID: " + loan.getLoanId();
        } else {
            throw new RuntimeException("Application is Not Approved");
        }
    }
}
    


