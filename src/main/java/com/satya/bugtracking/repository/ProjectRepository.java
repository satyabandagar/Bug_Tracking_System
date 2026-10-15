/**
 * 
 */
package com.satya.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.bugtracking.entity.Project;

/**
*User :Admin
* Time:2:06:51 PM
* Date:Oct 12, 2026
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
