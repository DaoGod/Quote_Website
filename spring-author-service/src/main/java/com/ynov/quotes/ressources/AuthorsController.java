package com.ynov.quotes.ressources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ynov.quotes.models.QuotesList;
import com.ynov.quotes.models.Quote;

@RestController
@RequestMapping("/author")
public class AuthorsController {
	
	@RequestMapping("/{userID}")
	public List<QuotesList> getCatalog(@PathVariable("userID") String userID) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		List<Quote> quotesList = Arrays.asList(
				new Quote("1", "Dans la vie on ne fait pas ce que l'on veut mais on est responsable de ce que l'on est.", "Jean-Paul Sartre"),
				new Quote("2", "La vie est un mystère qu'il faut vivre, et non un problème à résoudre.", "Gandhi"),
				new Quote("3", "Tout vient à point à qui sait attendre.", "Clément Marot")
		);
		
		return quotesList.stream().map(quotes -> {
			Quote quote = restTemplate.getForObject("http://localhost:8081/quotes/" + quotes.getQuoteID(), Quote.class);
			return new QuotesList(quote.getQuote(), quote.getAuthor());
		})
		.collect(Collectors.toList());
		
		
		
	}
	
	/*
	 * private String username;
	
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
	*/
	
}