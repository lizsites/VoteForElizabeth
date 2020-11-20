package com.elizabeth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GenericController {
	
	@PostMapping
	public String getString() {
		System.out.println("you found me");
		return "You found me";
	}
}
