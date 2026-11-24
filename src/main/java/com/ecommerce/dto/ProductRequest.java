package com.ecommerce.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {
	@NotNull(message = "Product name should not be null")
	private String productName;
	@NotNull(message = "product description shouldnt be null")
	private String description;
	@NotNull(message = "price shouldnt be null")
	@DecimalMin("0.1")
	@Column(nullable = false)
	private Long price;
	@NotBlank
	private String imageUrl;
	@NotNull
	private Long stockQuantity;
	@NotNull
	private Long categoryId;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
}
