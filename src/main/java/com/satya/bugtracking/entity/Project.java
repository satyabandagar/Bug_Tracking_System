/**
 * 
 */
package com.satya.bugtracking.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/**
*User :Admin
* Time:1:26:39 PM
* Date:Oct 12, 2026
 */
@Entity
@Table(name="projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "project")
	private List<Bug> bug = new ArrayList<>();
	
	@PrePersist
	public void setCreatedAt() {
		if(createdAt == null) {
			createdAt = LocalDateTime.now();
		}
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String name, String description, LocalDateTime createdAt, List<Bug> bug) {
		super();
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.bug = bug;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Bug> getBug() {
		return bug;
	}

	public void setBug(List<Bug> bug) {
		this.bug = bug;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt
				+ ", bug=" + bug + "]";
	}
	
	
}
