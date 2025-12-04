package com.Ankit.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ankit.blog.etities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
