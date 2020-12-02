package com.ynov.quotes.ressources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

	private String username;
	
	public AuthorController(String username) {
		this.username = username;
	}

	public AuthorController() {
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}