/**
 * 
 */
package com.satya.bugtracking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/**
*User :Admin
* Time:1:30:19 PM
* Date:Oct 12, 2026
 */
@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
	private Integer id;
	@Column(name="content")
	private String content;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name="bug_id")
	private Bug bug;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private User author;
	
	@PrePersist
	public void createdAt() {
		if(createdAt == null) {
			createdAt = LocalDateTime.now();
		}
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String content, LocalDateTime createdAt, Bug bug, User author) {
		super();
		this.content = content;
		this.createdAt = createdAt;
		this.bug = bug;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", createdAt=" + createdAt + ", bug=" + bug + ", author="
				+ author + "]";
	}
	
	
}
