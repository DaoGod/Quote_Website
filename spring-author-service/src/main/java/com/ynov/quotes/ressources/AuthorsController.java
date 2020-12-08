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

@RestController
@RequestMapping("/author")
public class AuthorsController {
	
	@RequestMapping("/{userID}")
	public List<QuotesList> getCatalog(@PathVariable("userID") String userID) {
		
		return Collections.singletonList(
				new QuotesList("Dans la vie on ne fait pas ce que l'on veut mais on est responsable de ce que l'on est.", "Jean-Paul Sartre")
			);	
	}
}