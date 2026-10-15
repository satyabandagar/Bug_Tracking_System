/**
 * 
 */
package com.satya.bugtracking.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.satya.bugtracking.repository.UserRepository;
import com.satya.bugtracking.entity.User;

/**
*User :Admin
* Time:12:40:52 PM
* Date:Oct 15, 2026
 */
@Service
public class CustomUserDetailsService implements  UserDetailsService{
	
	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository ) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByGmail(gmail).orElseThrow(()-> new UsernameNotFoundException("User not found with Gmail: "+gmail));
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getGmail())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
	}

	
}
