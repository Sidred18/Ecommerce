package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.CategoryRequest;
import com.ecommerce.dto.CategoryResponse;

public interface CategoryService {
	CategoryResponse saveCategory(CategoryRequest categoryRequest);
	String deleteCategory(int categoryId);
	CategoryResponse getCategoryById(int categoryId);
	List<CategoryResponse> getAllCategories();
	CategoryResponse updateCategory(int categoryId, CategoryRequest categoryRequest);
	
}
