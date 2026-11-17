package com.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productId;
	@Column(nullable = false)
	private String productName;
	@Column
	private String description;
	@Column(nullable = false)
	private Long price;
	@Column(nullable = false)
	private Long stockQuantity;
	@Column(length = 500)
	private String imageUrl;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
}
