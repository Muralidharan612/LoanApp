
package com.bank.LoanApp.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.bank.LoanApp.Repository.CustomerRepo;
import com.bank.LoanApp.model.Customer;

@Configuration

@EnableWebSecurity
public class SecurityConfigONE {

	@Bean
	public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().requestMatchers("/admin/**").hasAnyRole("ADMIN")
				.requestMatchers("/customer/**").hasAnyRole("CUSTOMER").anyRequest().authenticated().and().httpBasic()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.headers().frameOptions().disable();
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails user1 = creUserDetails("Admin", "M123");
		UserDetails user2 = creUserDetails("Customer", "C123");
		return new InMemoryUserDetailsManager(user1, user2);

	}

	private UserDetails creUserDetails(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		return User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("ADMIN", "CUSTOMER").build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// ==========================================

}
