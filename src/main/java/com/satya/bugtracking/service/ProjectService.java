/**
 * 
 */
package com.satya.bugtracking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satya.bugtracking.entity.Project;
import com.satya.bugtracking.repository.ProjectRepository;

/**
*User :Admin
* Time:6:18:34 PM
* Date:Oct 14, 2026
 */
@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository=projectRepository;
	}
	
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	public List<Project> getAllProject(){
		return projectRepository.findAll();
	}
	
	public Project getProjectById(Integer id) {
		return projectRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Project not found"));
	}
	
	public Project updateProject(Integer id,Project updateProject) {
		Project existingProject = getProjectById(id);
		
		existingProject.setName(updateProject.getName());
		existingProject.setDescription(updateProject.getDescription());
		
		return projectRepository.save(existingProject);
		
	}
	
	public void deleteProject(Integer id) {
		Project project = getProjectById(id);
		projectRepository.delete(project);
	}
}
