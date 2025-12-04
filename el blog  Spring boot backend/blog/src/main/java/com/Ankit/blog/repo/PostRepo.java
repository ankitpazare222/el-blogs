package com.Ankit.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ankit.blog.etities.Category;
import com.Ankit.blog.etities.Post;
import com.Ankit.blog.etities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUserID(User user);
	
	List<Post> findByCategoryID(Category cat);
	
	
	List<Post> findByTitleContaining(String title);
	

}
