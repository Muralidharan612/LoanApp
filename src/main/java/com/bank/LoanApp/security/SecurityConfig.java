/*
 * package com.bank.LoanApp.security;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * import org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * import com.bank.LoanApp.Exception.CustomerNotFoundException; import
 * com.bank.LoanApp.Repository.AdminRepo; import
 * com.bank.LoanApp.Repository.CustomerRepo; import
 * com.bank.LoanApp.model.Admin; import com.bank.LoanApp.model.Customer;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private AdminRepo adminRepo;
 * 
 * @Autowired private CustomerRepo customerRepo;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole(
 * "ADMIN").antMatchers("/customer/**")
 * .hasRole("CUSTOMER").anyRequest().authenticated().and().httpBasic().and().
 * sessionManagement()
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().headers().
 * frameOptions().disable(); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Bean public UserDetailsService adminDetailsService() { return new
 * UserDetailsService() {
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Optional<Admin> adminOptional =
 * adminRepo.findById(username); if (adminOptional.isPresent()) { Admin admin =
 * adminOptional.get(); return
 * User.builder().username(admin.getAdminId()).password(admin.getAdminPassword()
 * ).roles("ADMIN") .build(); } else { throw new
 * UsernameNotFoundException("Admin not found with username: " + username); } }
 * }; }
 * 
 * @Bean public UserDetailsService customerDetailsService() { return new
 * UserDetailsService() {
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * CustomerNotFoundException { Optional<Customer> customerOptional =
 * customerRepo.findById(username); if (customerOptional.isPresent()) { Customer
 * customer = customerOptional.get(); return
 * User.builder().username(customer.getCustomerId()).password(customer.
 * getPassword()) .roles("CUSTOMER").build(); } else { throw new
 * UsernameNotFoundException("Customer not found with username: " + username); }
 * } }; } }
 */