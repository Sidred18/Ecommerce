package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Override
	public ProductResponse addProduct(ProductRequest productRequest) {
		Product prod = new Product();
		Category cat = categoryRepo.findById(productRequest.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("There is no category with id: "+productRequest.getCategoryId()));
		
		prod.setCategory(cat);
		prod.setDescription(productRequest.getDescription());
		prod.setImageUrl(productRequest.getImageUrl());
		prod.setPrice(productRequest.getPrice());
		prod.setProductName(productRequest.getProductName());
		prod.setStockQuantity(productRequest.getStockQuantity());
		
		productRepo.save(prod);
		
		return toResponse(prod);
	}
	private ProductResponse toResponse(Product prod) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setCategoryId(prod.getCategory().getCategoryId());
		productResponse.setCategoryName(prod.getCategory().getCategoryName());
		productResponse.setDescription(prod.getDescription());
		productResponse.setImageUrl(prod.getImageUrl());
		productResponse.setPrice(prod.getPrice());
		productResponse.setProductId(prod.getProductId());
		productResponse.setProductName(prod.getProductName());
		productResponse.setStockQuantity(prod.getStockQuantity());
		
		return productResponse;
	}
	@Override
	public String deleteProduct(Long productId) {
		Product prod = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found with id: "+ productId));
		productRepo.deleteById(productId);
		return "Product Deleted Successfully";
	}

	@Override
	public ProductResponse updateProduct(Long productId, ProductRequest productRequest) {
		Product prod = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not Found with id: "+ productId));
		prod.setCategory(categoryRepo.findById(productRequest.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("category not found")));
		prod.setDescription(productRequest.getDescription());
		prod.setImageUrl(productRequest.getImageUrl());
		prod.setPrice(productRequest.getPrice());
		prod.setProductName(productRequest.getProductName());
		prod.setStockQuantity(productRequest.getStockQuantity());
		
		productRepo.save(prod);
		return toResponse(prod);
	}

	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepo.findAll();
		List<ProductResponse> prodResponses = new ArrayList<>();
		for(Product prod: products) {
			prodResponses.add(toResponse(prod));
		}
		return prodResponses;
	}

	@Override
	public ProductResponse getProductById(Long productId) {
		Product prod = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found with id: "+ productId));
		return toResponse(prod);
	}

	@Override
	public List<ProductResponse> getProductsByCategory(Long categoryId) {
		List<Product> prods = productRepo.findByCategoryCategoryId(categoryId);
		List<ProductResponse> prodResponses = new ArrayList<>();
		for(Product prod : prods) {
			prodResponses.add(toResponse(prod));
		}
		return prodResponses ;
	}

	@Override
	public List<ProductResponse> searchProductByName(String productName) {
		List<Product> prods = productRepo.findByProductNameContainingIgnoreCase(productName);
		List<ProductResponse> prodResponses = new ArrayList<>();
		for(Product prod: prods) {
			prodResponses.add(toResponse(prod));
		}
		return prodResponses;
	}

}
