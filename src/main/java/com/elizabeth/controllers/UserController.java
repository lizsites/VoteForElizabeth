package com.elizabeth.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elizabeth.models.User;
import com.elizabeth.services.UserService;



@RestController
@RequestMapping
@CrossOrigin(value="*", allowedHeaders="*")
public class UserController {
	
	private static Logger userLog = LogManager.getLogger(UserController.class);
	private UserService userService;
	private HttpSession sess;
	
	
	@Autowired
	public UserController(UserService userService, HttpSession sess) {
		this.userService = userService;
		this.sess = sess;
	}
	
	@PostMapping(value="/new-user")
	public ResponseEntity<User> addUser(@RequestBody User u) {
		System.out.println("I'm here");
		userLog.info("New user signed up : " + u);
		Optional<User> user = userService.addUser(u);
		if (user.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(user.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	/*
	 * For the Get methods, do we need to check if the user list is null?
	 * Likely the list will be null, and still functioning properly.
	 * Therefore, at this time, I've decided that it doesn't require any control flow,
	 * and sends whatever the repository sends back.
	 * */
	@GetMapping(value="/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}
	
	@GetMapping(value="/notified-users")
	public ResponseEntity<List<User>> getAllNotifiedUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getEmailUsers());
		
	}
}
