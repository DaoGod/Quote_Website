package com.ynov.quotes.ressources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.quotes.models.Quote;

@RestController
@RequestMapping("/quotes")
public class QuotesControler {
	
	@RequestMapping("/{quoteID}")
	public Quote getQuoteInfo(@PathVariable("quoteID") String quoteID) {
		return new Quote(quoteID, "Test quote", "Test author");
	}
}