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
import org.springframework.web.bind.annotation.RequestParam;

import com.satya.bugtracking.entity.Bug;
import com.satya.bugtracking.entity.Project;
import com.satya.bugtracking.entity.User;
import com.satya.bugtracking.service.BugService;
import com.satya.bugtracking.service.ProjectService;
import com.satya.bugtracking.service.UserService;

/**
*User :Admin
* Time:12:55:28 AM
* Date:Oct 15, 2026
 */
@Controller
@RequestMapping("/bugs")
public class BugController {

	private final BugService bugService;
	private final ProjectService projectService;
	private final UserService userService;
	
	public BugController(BugService bugService,UserService userService, ProjectService projectService) {
		this.bugService = bugService;
		this.projectService = projectService;
        this.userService=userService;
	}
	
	@GetMapping
	public String getAllBugs(Model mode) {
		mode.addAttribute("bugs", bugService.getAllBugs());
		return "bugs";
	}
	
	@GetMapping("/add")
	public String showAddBugForm(Model model) {
		model.addAttribute("bug",new Bug());
		model.addAttribute("projects",projectService.getAllProject());
		model.addAttribute("users",userService.getAllUser());
		return "add-bug";
	}
	
	@PostMapping("/save")
	public String saveBug(@ModelAttribute("bug") Bug bug, @RequestParam Integer projectId, @RequestParam(required = false) Integer assignedUserId) {
		Project project = projectService.getProjectById(projectId);
		bug.setProject(project);
		
		if(assignedUserId != null) {
			User user = userService.getuserById(assignedUserId);
			bug.setAssignedUser(user);
		}else {
			bug.setAssignedUser(null);
		}
		bugService.save(bug);
		return "redirect:/bugs";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBug(@PathVariable Integer id) {
		bugService.deletBug(id);
		return "redirect:/bugs";
	}
}
