package com.Ankit.blog.services;

import java.util.List;

import com.Ankit.blog.Dto.CategoryDTO;

public interface CategoryService {

	CategoryDTO createCategory(CategoryDTO CategoryDTO);
	
	CategoryDTO UpadteCategory(CategoryDTO CategoryDTO,Integer CategoryID);
	
	void deleteCategory(Integer CategoryID);
	
	CategoryDTO getByiD(Integer CategoryID);
	
	List<CategoryDTO>getallUSer();
}
