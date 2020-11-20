package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizabeth.models.User;
import com.elizabeth.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public Optional<User> addUser(User u) {
		userRepo.save(u);
		return userRepo.findById(u.getId());
		
	}
	
}
