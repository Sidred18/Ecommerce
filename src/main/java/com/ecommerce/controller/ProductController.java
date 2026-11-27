package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponse> getProductById(Long productId){
		ProductResponse response = productService.getProductById(productId);
		return ResponseEntity.ok(response);
	}
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getProducts(){
		List<ProductResponse> responses = productService.getAllProducts();
		return ResponseEntity.ok(responses);
	}
	@PostMapping
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){
		ProductResponse response = productService.addProduct(productRequest);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/productId/{productId}")
	public ResponseEntity<String> deleteProduct(Long productId){
		String res = productService.deleteProduct(productId);
		return ResponseEntity.ok(res);
	}
	@GetMapping("/categoryId/{categoryId}")
	public ResponseEntity<List<ProductResponse>> getProductsByCategory(Long categoryId){
		List<ProductResponse> responses = productService.getProductsByCategory(categoryId);
		return ResponseEntity.ok(responses);
	}
	@PutMapping("/{productId}")
	public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductRequest productRequest, Long productId){
		ProductResponse response = productService.updateProduct(productId, productRequest);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/productName")
	public ResponseEntity<List<ProductResponse>> searchProductsByName(@RequestParam String productName){
		List<ProductResponse> responses = productService.searchProductByName(productName);
		return ResponseEntity.ok(responses);
	}
}
