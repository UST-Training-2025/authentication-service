package com.demo.authentication_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.authentication_service.Entity.UserCredentialsEntity;
import com.demo.authentication_service.Repository.UserCredentialDao;

	@Service
	public class UserCredentialsService {
	@Autowired 
	JwtService jwtService;
	@Autowired
	UserCredentialDao authDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public UserCredentialsEntity register(UserCredentialsEntity user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	return authDao.saveAndFlush(user);
	}
	public String generateToken(String name) {
	return jwtService.generateToken(name);
	}
	public boolean verifyToken(String token) {
	jwtService.validateToken(token);
	return true;
	}
	}


