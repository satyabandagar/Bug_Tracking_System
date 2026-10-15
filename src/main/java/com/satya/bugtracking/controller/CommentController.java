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
import com.satya.bugtracking.entity.Comment;
import com.satya.bugtracking.entity.User;
import com.satya.bugtracking.service.BugService;
import com.satya.bugtracking.service.CommentService;
import com.satya.bugtracking.service.UserService;

/**
*User :Admin
* Time:1:04:19 AM
* Date:Oct 15, 2026
 */
@Controller
@RequestMapping("/comments")
public class CommentController {

	private final CommentService commentService;
	private final BugService bugService;
	private final UserService userService;
	
	public CommentController(CommentService commentService,BugService bugService,UserService userService) {
		this.commentService = commentService;
		this.bugService=bugService;
		this.userService = userService;
	}
	
	@GetMapping
	public String getAllComments(Model model) {
		model.addAttribute("comments", commentService.getAllComment());
		return "comments";
	}
	
	@GetMapping("/add")
	public String showAddCommentform(Model model) {
		model.addAttribute("comment", new Comment());
		model.addAttribute("bugs",bugService.getAllBugs());
		model.addAttribute("users",userService.getAllUser());
		return "add-comment";
	}
	
	@PostMapping("/save")
	public String saveComment(@ModelAttribute("comment") Comment commet,@RequestParam Integer bugId, @RequestParam Integer authorId) {
		
		Bug bug = bugService.getBugById(bugId);
		User author = userService.getuserById(authorId);
		
		commet.setBug(bug);
		commet.setAuthor(author);
		commentService.saveComment(commet);
		return "redirect:/comments";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteComment(@PathVariable Integer id) {
		commentService.deleteComment(id);
		return "redirect:/commets";
	}
}
