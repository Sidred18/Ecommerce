package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.RegisterRequest;
import com.ecommerce.dto.UserResponse;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request){
		UserResponse response = userService.register(request);
		return ResponseEntity.ok(response);
	}
}
