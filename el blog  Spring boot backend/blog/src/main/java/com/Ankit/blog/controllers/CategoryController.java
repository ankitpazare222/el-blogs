package com.Ankit.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.blog.Dto.CategoryDTO;
import com.Ankit.blog.services.CategoryService;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO CategoryDTO) {
		CategoryDTO category = this.categoryService.createCategory(CategoryDTO);

		return new ResponseEntity<CategoryDTO>(category, HttpStatus.CREATED);

	}

	@PutMapping("/{CategoryID}")
	public ResponseEntity<CategoryDTO>	UpadteCategory(@RequestBody CategoryDTO CategoryDTO,@PathVariable("CategoryID") Integer CategoryID){
	CategoryDTO upadteCategory = this.categoryService.UpadteCategory(CategoryDTO, CategoryID);
	return ResponseEntity.ok(upadteCategory);
}

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getallUSer() {
		List<CategoryDTO> getallUSer = this.categoryService.getallUSer();
		return ResponseEntity.ok(getallUSer);
	}
	@GetMapping("/{CategoryID}")
	public ResponseEntity<CategoryDTO> getByiD(@PathVariable("CategoryID") Integer CategoryID){
		CategoryDTO byiD = this.categoryService.getByiD(CategoryID);
		return ResponseEntity.ok(byiD);
	}
	
	
	
	@DeleteMapping("/{CategoryID}")
	public ResponseEntity<?> deleteByiD(@PathVariable("CategoryID") Integer CategoryID){
		this.categoryService.deleteCategory(CategoryID);
		return new ResponseEntity(Map.of("meaasage","user deleted sucessfully"),HttpStatus.OK);
	}

}
