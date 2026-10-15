/**
 * 
 */
package com.satya.bugtracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satya.bugtracking.entity.User;
import com.satya.bugtracking.service.UserService;


/**
*User :Admin
* Time:12:30:03 AM
* Date:Oct 15, 2026
 */
@Controller
@RequestMapping("/users")
public class UserController {

	public final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String getAllUser(Model model) {
		model.addAttribute("users", userService.getAllUser());
		return "users";
	}
	
	@GetMapping("/add")
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new User());
		
		return "add-user";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
	
}
