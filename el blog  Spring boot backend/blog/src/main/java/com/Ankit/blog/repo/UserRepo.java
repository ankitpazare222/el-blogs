package com.Ankit.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ankit.blog.etities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	

}
