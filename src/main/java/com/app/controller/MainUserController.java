package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainUserController {
	
	@GetMapping("/")
	public String root() {
		return "users/index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "users/login";
	}
	
	@GetMapping("/user")
	public String userIndex() {
		return "users/index";
	}

}
