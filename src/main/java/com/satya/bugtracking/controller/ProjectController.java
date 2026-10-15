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

import com.satya.bugtracking.entity.Project;
import com.satya.bugtracking.service.ProjectService;

/**
*User :Admin
* Time:12:45:47 AM
* Date:Oct 15, 2026
 */
@Controller
@RequestMapping("/projects")
public class ProjectController {

	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping
	public String getAllProject(Model model) {
		model.addAttribute("projects",projectService.getAllProject());
		return "projects";
	}
	
	@GetMapping("/add")
	public String showAddProject(Model model) {
		model.addAttribute("project", new Project());
		return "add-project";
	}
	
	@PostMapping("/save")
	public String saveProject(@ModelAttribute("project") Project project) {
		projectService.saveProject(project);
		return "redirect:/projects";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteProject(@PathVariable Integer id) {
		projectService.deleteProject(id);
		return "redirect:/projects";
	}
}
