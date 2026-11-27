package com.ecommerce.service;

import com.ecommerce.dto.RegisterRequest;
import com.ecommerce.dto.UserResponse;

public interface UserService {
	UserResponse register(RegisterRequest request);
	UserResponse getUserById(Long userId);
	UserResponse getUserByEmail(String email);
}
