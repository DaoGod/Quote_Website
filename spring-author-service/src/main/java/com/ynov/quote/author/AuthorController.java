package com.ynov.quote.author;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
class AuthorController {

	private final AuthorRepository authors;

	public AuthorController(AuthorRepository quoteService) {
		this.authors = quoteService;
	}

	@HystrixCommand
	@GetMapping("/authors")
	public Iterable<Author> getAuthors() {
		return authors.findAll();
	}

	@HystrixCommand
	@GetMapping("/authors/{id}")
	public Optional<Author> getAuthorById(@PathVariable("id") Integer id) {
		return authors.findById(id);
	}

	@HystrixCommand
	@PostMapping("/authors/new")
	public Author addAuthor(@RequestParam("nickname") String nickname) {
		Author author = new Author();
		author.setNickname(nickname);
		return authors.save(author);
	}
	
	@HystrixCommand
	@PostMapping("/authors/")
	public Author save(@RequestBody Author author) {
		return authors.save(author);
	}


	@HystrixCommand
	@DeleteMapping("/authors/{id}")
	public void deleteAuthor(@PathVariable("id") Integer id) {
		authors.deleteById(id);
	}

	@HystrixCommand
	@PostMapping("/authors/{authorId}/addQuote")
	public void addQuoteToAuthor(@PathVariable("authorId") Integer authorId, @RequestParam("quoteId") Integer quoteId) {
		Optional<Author> authorOpt = authors.findById(authorId);
		if (authorOpt.isPresent()) {
			Author author = authorOpt.get();
			author.addQuote(quoteId);
			authors.save(author);
		}
	}
	
	@HystrixCommand(commandKey = "author-service-find-by-last-name")
	@GetMapping("/authors/findByNickname/{nickname}")
	public Iterable<Author> findAuthorByNickname(@PathVariable("nickname") String nickname) throws InterruptedException {
		return authors.findByNickname(nickname);
	}	
}