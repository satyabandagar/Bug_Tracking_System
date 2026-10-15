/**
 * 
 */
package com.satya.bugtracking.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
*User :Admin
* Time:1:22:43 PM
* Date:Oct 12, 2026
 */
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="gmail")
	private String gmail;
	@Column(name="password")
	private String password;
	@Column(name="role",nullable = false,length = 30)
	private String role;
	
	@OneToMany(mappedBy = "assignedUser")
	private List<Bug> bugs = new ArrayList<>();
	
	@OneToMany(mappedBy = "author")
	private List<Comment> comments = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String gmail, String password, String role, List<Bug> bugs, List<Comment> comments) {
		super();
		this.name = name;
		this.gmail = gmail;
		this.password = password;
		this.role = role;
		this.bugs = bugs;
		this.comments = comments;
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

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gmail=" + gmail + ", password=" + password + ", role=" + role
				+ ", bugs=" + bugs + ", comments=" + comments + "]";
	}
	
	
}
