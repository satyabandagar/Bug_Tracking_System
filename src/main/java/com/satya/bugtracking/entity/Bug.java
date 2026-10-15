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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/**
*User :Admin
* Time:1:15:00 PM
* Date:Oct 12, 2026
 */
@Entity
@Table(name="bugs")
public class Bug {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bugs_Id")
	private Integer Id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="status")
	private String status = "OPEN";
	@Column(name="priority")
	private String priority = "MEDIUM";
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name="project_id",nullable=false)
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="assigned_user_id")
	private User assignedUser;
	
	@OneToMany(mappedBy = "bug")
	private List<Comment> comments = new ArrayList<>();
	
	@PrePersist
	public void setCreatedAt() {
		if(createdAt == null) {
			createdAt = LocalDateTime.now();
		}
	}

	public Bug() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bug( String title, String description, String status, String priority, LocalDateTime createdAt,
			Project project, User assignedUser, List<Comment> comments) {
		super();
		
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.createdAt = createdAt;
		this.project = project;
		this.assignedUser = assignedUser;
		this.comments = comments;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Bug [Id=" + Id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", priority=" + priority + ", createdAt=" + createdAt + ", project=" + project + ", assignedUser="
				+ assignedUser + ", comments=" + comments + "]";
	}
	
	
	
}
