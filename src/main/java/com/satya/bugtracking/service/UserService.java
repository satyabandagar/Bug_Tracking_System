/**
 * 
 */
package com.satya.bugtracking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satya.bugtracking.entity.User;
import com.satya.bugtracking.repository.UserRepository;

/**
*User :Admin
* Time:2:24:37 PM
* Date:Oct 12, 2026
 */
@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	// save all data
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public User getuserById(Integer id) {
		return userRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("user not found: "+id));
	}
	
	public User updateUser(Integer id, User updateUser) {
		User existingUser = getuserById(id);
		existingUser.setName(updateUser.getName());
		existingUser.setGmail(updateUser.getGmail());
		existingUser.setRole(updateUser.getRole());
		
		return userRepository.save(existingUser);
	}
	
	public void deleteUser(Integer id) {
		User user = getuserById(id);
		userRepository.delete(user);
	}
}
