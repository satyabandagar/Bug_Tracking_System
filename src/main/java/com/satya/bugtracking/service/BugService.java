/**
 * 
 */
package com.satya.bugtracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.bugtracking.entity.Bug;
import com.satya.bugtracking.repository.BugRepository;

/**
*User :Admin
* Time:2:10:55 PM
* Date:Oct 12, 2026
 */
@Service
public class BugService {
	
	private final BugRepository bugRepository;
	
	public BugService(BugRepository bugRepository) {
		this.bugRepository=bugRepository;
	}
	
	// create or update a bug
	public Bug save(Bug bug) {
		return bugRepository.save(bug);
	}
	
	// Get all bugs
	public List<Bug> getAllBugs(){
		return bugRepository.findAll();
	}
	
	// Get bug by ID
	public Bug getBugById(Integer id) {
		return bugRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Bug not found with ID: "+id));
	}
	
	// update bug
	public Bug updateBug(Integer id,Bug updateBug) {
		Bug existingBug = getBugById(id);
		
		existingBug.setTitle(updateBug.getTitle());
		existingBug.setDescription(updateBug.getDescription());
		existingBug.setStatus(updateBug.getStatus());
		existingBug.setPriority(updateBug.getPriority());
		
		return bugRepository.save(existingBug);
	}
	
	// Delete bug
	public void deletBug(Integer id) {
		Bug bug = getBugById(id);
		bugRepository.delete(bug);
	}
}
