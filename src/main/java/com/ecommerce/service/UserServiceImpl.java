package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.RegisterRequest;
import com.ecommerce.dto.UserResponse;
import com.ecommerce.entity.User;
import com.ecommerce.exception.DuplicateResourceException;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.utils.Role;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	@Transactional
	public UserResponse register(RegisterRequest request) {
		if(userRepo.existsByEmail(request.getEmail().trim().toLowerCase())) {
			throw new DuplicateResourceException("Email already exists");
		}
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.CUSTOMER);
		user.setPhoneNumber(request.getPhoneNumber());
		
		User saved = userRepo.save(user);
		
		return toResponse(saved);
	}
	private UserResponse toResponse(User user) {
		UserResponse resp = new UserResponse();
		resp.setEmail(user.getEmail());
		resp.setName(user.getName());
		resp.setPhoneNumber(user.getPhoneNumber());
		resp.setRole(user.getRole());
		resp.setUserId(user.getUserId());
		
		return resp;
	}
	@Override
	public UserResponse getUserById(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with userId: "+ userId));
		return toResponse(user);
	}

	@Override
	public UserResponse getUserByEmail(String email) {
		User user = userRepo.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found with email : "+ email));
		return toResponse(user);
	}

}
