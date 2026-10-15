/**
 * 
 */
package com.satya.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.bugtracking.entity.Bug;

/**
*User :Admin
* Time:2:07:58 PM
* Date:Oct 12, 2026
 */
public interface BugRepository extends JpaRepository<Bug, Integer> {

}
