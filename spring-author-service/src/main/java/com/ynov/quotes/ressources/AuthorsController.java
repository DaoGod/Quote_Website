package com.ynov.quotes.ressources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.quotes.models.QuotesList;

@RestController
@RequestMapping("/author")
public class AuthorsController {
	
	@RequestMapping("/{userID}")
	public List<QuotesList> getCatalog(@PathVariable("userID") String userID) {
		return Collections.singletonList(
				new QuotesList("Tout vient à point à qui sait attendre.", "Clément Marot")	
		 );	
	}
	
	private String username;
	
	public AuthorsController(String username) {
		this.username = username;
	}

	public AuthorsController() {
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}