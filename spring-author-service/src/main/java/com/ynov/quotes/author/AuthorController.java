package com.ynov.quotes.author;

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
public class AuthorController {
	
	private final AuthorRepository authors;

	public AuthorController(AuthorRepository clinicService) {
		this.authors = clinicService;
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
	public Author addAuthor(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("city") String city, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setCity(city);
		author.setTelephone(phoneNumber);
		author.setAddress(address);
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
	@PostMapping("/authors/{authorId}/addPet")
	public void addPetToAuthor(@PathVariable("authorId") Integer authorId, @RequestParam("petId") Integer petId) {
		Optional<Author> authorOpt = authors.findById(authorId);
		if (authorOpt.isPresent()) {
			Author author = authorOpt.get();
			author.addPet(petId);
			authors.save(author);
		}
		
	}
	
	@HystrixCommand(commandKey = "author-service-find-by-last-name")
	@GetMapping("/authors/findByLastName/{lastName}")
	public Iterable<Author> findAuthorByLastName(@PathVariable("lastName") String lastName) throws InterruptedException {
		return authors.findByLastName(lastName);
	}	

}