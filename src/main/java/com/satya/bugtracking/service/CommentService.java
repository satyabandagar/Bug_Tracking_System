/**
 * 
 */
package com.satya.bugtracking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satya.bugtracking.entity.Comment;
import com.satya.bugtracking.repository.CommentRepository;

/**
*User :Admin
* Time:12:11:34 AM
* Date:Oct 15, 2026
 */
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public List<Comment> getAllComment(){
		return commentRepository.findAll();
	}
	
	public Comment getCommentById(Integer id) {
		return commentRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Comment not found: "+id));
	}
	
	public Comment updateComment(Integer id,Comment updateComment) {
		Comment existingComment = getCommentById(id);
		
		existingComment.setContent(updateComment.getContent());
		return commentRepository.save(existingComment);
	}
	
	public void deleteComment(Integer id) {
		Comment comment = getCommentById(id);
		commentRepository.delete(comment);
	}
}
