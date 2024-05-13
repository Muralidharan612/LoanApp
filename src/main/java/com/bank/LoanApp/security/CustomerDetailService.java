/*
 * package com.bank.LoanApp.security;
 * 
 * import java.util.Collections; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.bank.LoanApp.Repository.CustomerRepo; import
 * com.bank.LoanApp.model.Admin; import com.bank.LoanApp.model.Customer;
 * 
 * @Service public class CustomerDetailService implements UserDetailsService {
 * 
 * @Autowired private CustomerRepo customerRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Optional<Customer> user =
 * customerRepository.findById(username); if (user.isEmpty()) { throw new
 * UsernameNotFoundException("Admin not found with username: " + username); }
 * Customer customer = user.get(); return
 * org.springframework.security.core.userdetails.User.builder().username(user.
 * get().getCustomerId())
 * .password(user.get().getPassword()).roles(user.get().getRole()).build();
 * 
 * } }
 */