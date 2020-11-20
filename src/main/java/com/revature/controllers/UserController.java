package com.revature.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elizabeth.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(value="*", allowedHeaders="*")
@ResponseBody
public class UserController {
	
	private static Logger userLog = LogManager.getLogger(UserController.class);
	private UserService userService;
	private HttpSession sess;
	
	
	@Autowired
	public UserController(UserService userService, HttpSession sess) {
		this.userService = userService;
		this.sess = sess;
	}
	
	@PostMapping
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
}
