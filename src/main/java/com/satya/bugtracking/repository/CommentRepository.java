/**
 * 
 */
package com.satya.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.bugtracking.entity.Comment;

/**
*User :Admin
* Time:2:08:53 PM
* Date:Oct 12, 2026
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
