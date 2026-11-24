package com.ecommerce.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoryRequest;
import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.entity.Category;
import com.ecommerce.exception.ResourceNotFoundException;
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
	public String deleteCategory(Long categoryId) {
		Category cgry = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category not found "+ categoryId));
		categoryRepo.delete(cgry);
		return "Category deleted successfully";
	}

	@Override
	public CategoryResponse getCategoryById(Long categoryId) {
		Category cat = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category Not Found"+ categoryId));
		CategoryResponse catResp = new CategoryResponse();
		catResp.setCategoryId(cat.getCategoryId());
		catResp.setCategoryName(cat.getCategoryName());
		return catResp;
	}

	@Override
	public List<CategoryResponse> getAllCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryResponse> catResponses = new ArrayList<>();
		for(Category category: categories) {
			CategoryResponse catRsp = new CategoryResponse();
			catRsp.setCategoryId(category.getCategoryId());
			catRsp.setCategoryName(category.getCategoryName());
			catResponses.add(catRsp);
		}
		return catResponses;
	}

	@Override
	public CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category Not Found of ID: "+ categoryId));
		category.setCategoryName(categoryRequest.getCategoryName());
		Category updated = categoryRepo.save(category);
		CategoryResponse crsp = new CategoryResponse();
		crsp.setCategoryId(categoryId);
		crsp.setCategoryName(category.getCategoryName());
		return crsp;
	}

}
