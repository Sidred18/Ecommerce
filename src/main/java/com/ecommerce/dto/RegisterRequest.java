package com.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
	@NotBlank(message = "name is required")
	private String name;
	@NotBlank(message = "email is required")
	@Email(message = "Enter valid email")
	private String email;
	@NotBlank(message = "password is required")
	@Size(min = 8, message = "Password length should be 8 or more")
	private String password;
	@NotBlank(message = "phone number is required")
	@Pattern(regexp = "\\d{10}", message = "phone number must me 10 digits")
	private String phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
