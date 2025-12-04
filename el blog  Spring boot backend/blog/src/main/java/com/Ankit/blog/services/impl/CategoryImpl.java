package com.Ankit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.blog.Dto.CategoryDTO;
import com.Ankit.blog.etities.Category;
import com.Ankit.blog.exceptions.ResourceNotFundException;
import com.Ankit.blog.repo.CategoryRepo;
import com.Ankit.blog.services.CategoryService;
@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	private CategoryRepo CategoryRepo;

	@Override
	public CategoryDTO createCategory(CategoryDTO CategoryDTO) {
		Category dtotoEntity = this.DtotoEntity(CategoryDTO);
		Category saveCategory = this.CategoryRepo.save(dtotoEntity);
		// TODO Auto-generated method stub
		return this.EntityToDto(saveCategory);
	}

	@Override
	public CategoryDTO UpadteCategory(CategoryDTO CategoryDTO, Integer CategoryID) {
		
		Category category = this.CategoryRepo.findById(CategoryID).
				orElseThrow(()-> new ResourceNotFundException("category", "CategoryID", CategoryID));
		
		category.setCategoryDescription(CategoryDTO.getCategoryDescription());
		category.setCategoryTitle(CategoryDTO.getCategoryTitle());
		
		Category saveCat = this.CategoryRepo.save(category);
		
		// TODO Auto-generated method stub
		return this.EntityToDto(saveCat);
	}

	@Override
	public void deleteCategory(Integer CategoryID) {
		
		Category category = this.CategoryRepo.findById(CategoryID).orElseThrow(()-> new ResourceNotFundException("category", "CategoryID", CategoryID));
		// TODO Auto-generated method stub
		this.CategoryRepo.deleteById(CategoryID);

	}

	@Override
	public CategoryDTO getByiD(Integer CategoryID) {
		
		Category category = this.CategoryRepo.findById(CategoryID).orElseThrow(()-> new ResourceNotFundException("category", "CategoryID", CategoryID));
		// TODO Auto-generated method stub
		return this.EntityToDto(category);
	}

	@Override
	public List<CategoryDTO> getallUSer() {
		List<Category> Allcategory = this.CategoryRepo.findAll();
		List<CategoryDTO> collect = Allcategory.stream().map(user->this.EntityToDto(user)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return collect;
	}
	
	private  Category DtotoEntity(CategoryDTO categoryDTO) {
		
		Category category=new Category();
		category.setCategoryDescription(categoryDTO.getCategoryDescription());
		category.setCategoryTitle(categoryDTO.getCategoryTitle());
		return category;
		
		
	}
	
	private CategoryDTO EntityToDto(Category category) {
		CategoryDTO categoryDTO=new CategoryDTO();
		categoryDTO.setCategoryDescription(category.getCategoryDescription());
		categoryDTO.setCategoryTitle(category.getCategoryTitle());
		categoryDTO.setCategoryID(category.getCategoryID());
		
		return categoryDTO;
		
	}

}
