/*
 * package com.bank.LoanApp.security;
 * 
 * import java.util.Collections; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.bank.LoanApp.Repository.AdminRepo; import
 * com.bank.LoanApp.model.Admin;
 * 
 * @Service public class AdminDetailsService implements UserDetailsService {
 * 
 * @Autowired private AdminRepo adminrepository;
 * 
 * @Override public UserDetails loadUserByUsername(String Adminid) throws
 * UsernameNotFoundException { Optional<Admin> adminOptional =
 * adminrepository.findById(Adminid); System.out.println(Adminid); if
 * (adminOptional.isEmpty()) { throw new
 * UsernameNotFoundException("Admin not found with username: " + Adminid); }
 * Admin admin = adminOptional.get(); return new
 * org.springframework.security.core.userdetails.User(admin.getAdminId(),
 * admin.getAdminPassword(), Collections.emptyList());
 * 
 * }
 * 
 * }
 */