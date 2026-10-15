/**
 * 
 */
package com.satya.bugtracking.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.satya.bugtracking.entity.User;
import com.satya.bugtracking.service.UserService;

/**
*User :Admin
* Time:11:22:06 AM
* Date:Oct 15, 2026
 */
@Controller
public class AuthController {
	
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	public AuthController(UserService userService,PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("DEVELOPER");
		
		userService.saveUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
}
