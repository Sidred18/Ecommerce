package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoryRequest;
import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.entity.Category;
import com.ecommerce.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepo;
	@Override
	public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
		Category category = new Category();
		category.setCategoryName(categoryRequest.getCategoryName());
		
		Category saved = categoryRepo.save(category);
		
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setCategoryId(saved.getCategoryId());
		categoryResponse.setCategoryName(saved.getCategoryName());
		
		return categoryResponse;
	}

	@Override
	public String deleteCategory(int categoryId) {
		return null;
	}

	@Override
	public CategoryResponse getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryResponse> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponse updateCategory(int categoryId, CategoryRequest categoryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
