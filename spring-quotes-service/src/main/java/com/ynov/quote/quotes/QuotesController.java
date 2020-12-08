package com.ynov.quote.quotes;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class QuotesController {

	@Inject
	private QuotesRepository quotes;
	
	@PostConstruct
	private void postConstruct() {
		System.out.println(quotes);
	}
	
	private final static Logger logger = LoggerFactory.getLogger(QuotesController.class);
	
	@GetMapping("/quotes")
	public Iterable<Quotes> getQuotes() {
		return quotes.findAll();
	}

	@GetMapping("/quotes/{id}")
	public Optional<Quotes> getQuoteById(@PathVariable("id") Integer id) {
		logger.info("getting quote for id {}", id);
		return quotes.findById(id);
	}

	@PostMapping("/quotes") 
	public Quotes addQuote(@RequestBody Quotes quote) {
		return this.quotes.save(quote);
	}
	
	@PostMapping("/quotes/new")
	public Quotes addQuote(@RequestParam("quoteDesc") String quoteDesc, @RequestParam("authorId") Integer authorId) {
		Quotes quote = new Quotes();
		quote.setQuotesDesc(quoteDesc);
		quote.setAuthorId(authorId);
		return quotes.save(quote);
	}

	@DeleteMapping("/quotes/{id}")
	public void deleteQuote(@PathVariable("id") Integer id) {
		quotes.deleteById(id);
	}

	@PostMapping("/quotes/{quoteId}/addComment")
	public void addCommentToQuote(@PathVariable("quoteId") Integer quoteId, @RequestParam("commentId") Integer commentId) {
		Optional<Quotes> quoteOpt = quotes.findById(quoteId);
		if (quoteOpt.isPresent()) {
			Quotes quote = quoteOpt.get();
			quote.setComment(commentId);
			quotes.save(quote);
		}
	}
}
