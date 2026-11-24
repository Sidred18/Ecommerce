package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.dto.ProductResponse;

public interface ProductService {
	ProductResponse addProduct(ProductRequest productRequest);
	String deleteProduct(Long productId);
	ProductResponse updateProduct(Long productId, ProductRequest productRequest);
	List<ProductResponse> getAllProducts();
	ProductResponse getProductById(Long productId);
	List<ProductResponse> getProductsByCategory(Long categoryId);
	List<ProductResponse> searchProductByName(String productName);
}
