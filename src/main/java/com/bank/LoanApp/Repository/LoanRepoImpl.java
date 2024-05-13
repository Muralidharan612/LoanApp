/*
 * package com.bank.LoanApp.Repository;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import com.bank.LoanApp.model.Loan;
 * 
 * @Repository public class LoanRepoImpl implements LoanRepo{
 * 
 * private List<Loan> loanList = new ArrayList<>();
 * 
 * 
 * @Override public List<Loan> getAllLoan() {
 * 
 * loanList.add(new Loan(1L, "Personal", 20000, 20000, 0, 0, 5.5, 12));
 * loanList.add(new Loan(2L, "Business", 30000, 30000, 0, 0, 6.0, 24));
 * loanList.add(new Loan(3L, "Education", 25000, 0, 0, 0, 4.5, 18));
 * loanList.add(new Loan(4L, "Personal", 40000, 0, 0, 0, 5.0, 36));
 * loanList.add(new Loan(5L, "Business", 35000, 35000, 0, 0, 6.5, 24));
 * 
 * return loanList; }
 * 
 * @Override public void save(Loan loan) { loanList.add(loan);
 * 
 * }
 * 
 * }
 */