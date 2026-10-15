/**
 * 
 */
package com.satya.bugtracking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.bugtracking.entity.User;

/**
*User :Admin
* Time:2:04:17 PM
* Date:Oct 12, 2026
 */
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByGmail(String gmail);
	boolean existsByGmail(String gmail);
}
