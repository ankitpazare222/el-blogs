package com.Ankit.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ankit.blog.etities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
