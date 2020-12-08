package com.ynov.quotes.quote;

import java.time.LocalDate;
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
class QuoteController {

	@Inject
	private QuoteRepository quotes;
	
	@PostConstruct
	private void postConstruct() {
		System.out.println(quotes);
	}
	
	private final static Logger logger = LoggerFactory.getLogger(QuoteController.class);
	
	@GetMapping("/quote-types")
	List<QuoteType> findQuoteTypes() {
		return quotes.findQuoteTypes();
	}

	@GetMapping("/quotes")
	public Iterable<Quote> getQuotes() {
		return quotes.findAll();
	}

	@GetMapping("/quotes/{id}")
	public Optional<Quote> getQuoteById(@PathVariable("id") Integer id) {
		logger.info("getting quote for id {}", id);
		return quotes.findById(id);
	}

	@PostMapping("/quotes") 
	public Quote addQuote(@RequestBody Quote quote) {
		return this.quotes.save(quote);
	}
	
	@PostMapping("/quotes/new")
	public Quote addQuote(@RequestParam("firstName") String firstName, @RequestParam("ownerId") Integer ownerId,
			@RequestParam("quoteType") QuoteType type, @RequestParam("birthDate") LocalDate birthDate) {
		Quote quote = new Quote();
		quote.setName(firstName);
		quote.setOwner(ownerId);
		quote.setType(type);
		quote.setBirthDate(birthDate);
		return quotes.save(quote);
	}

	@PutMapping("/quotes/{id}")
	public Quote editQuote(@PathVariable("id") Integer id, @RequestParam("firstName") String firstName,
			@RequestParam("ownerId") Integer ownerId, @RequestParam("quoteType") QuoteType type,
			@RequestParam("birthDate") LocalDate birthDate) {

		Optional<Quote> quoteOpt = quotes.findById(id);
		if (quoteOpt.isPresent()) {
			Quote quote = quoteOpt.get();
			quote.setName(firstName);
			quote.setOwner(ownerId);
			quote.setType(type);
			quote.setBirthDate(birthDate);
			quotes.save(quote);
		}
		return quoteOpt.get();
	}

	@DeleteMapping("/quotes/{id}")
	public void deleteQuote(@PathVariable("id") Integer id) {
		quotes.deleteById(id);
	}

	@PostMapping("/quotes/{quoteId}/addVisit")
	public void addVisitToQuote(@PathVariable("quoteId") Integer quoteId, @RequestParam("visitId") Integer visitId) {
		Optional<Quote> quoteOpt = quotes.findById(quoteId);
		if (quoteOpt.isPresent()) {
			Quote quote = quoteOpt.get();
			quote.addVisit(visitId);
			quotes.save(quote);
		}

	}

}
