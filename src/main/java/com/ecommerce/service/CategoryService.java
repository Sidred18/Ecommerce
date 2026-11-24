package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.CategoryRequest;
import com.ecommerce.dto.CategoryResponse;

public interface CategoryService {
	CategoryResponse saveCategory(CategoryRequest categoryRequest);
	String deleteCategory(Long categoryId);
	CategoryResponse getCategoryById(Long categoryId);
	List<CategoryResponse> getAllCategories();
	CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest);
	
}
