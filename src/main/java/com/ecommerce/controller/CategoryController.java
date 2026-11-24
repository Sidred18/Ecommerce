package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.CategoryRequest;
import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public CategoryResponse saveCategory(@RequestBody CategoryRequest categoryRequest) {
		return categoryService.saveCategory(categoryRequest);
	}
	@DeleteMapping("/{categoryId}")
	public String deleteCategory(@PathVariable long categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
	@GetMapping("/{categoryId}")
	public CategoryResponse getCategoryById (@PathVariable long categoryId) {
		return categoryService.getCategoryById(categoryId);
	}
	@GetMapping
	public List<CategoryResponse> getAllCategories(){
		return categoryService.getAllCategories();
	}
	@PutMapping("/{categoryId}")
	public CategoryResponse updateCategory(@PathVariable long categoryId, @RequestBody CategoryRequest categoryRequest) {
		return categoryService.updateCategory(categoryId, categoryRequest);
	}
}
