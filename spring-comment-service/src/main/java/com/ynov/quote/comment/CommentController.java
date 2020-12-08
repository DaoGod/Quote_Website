package com.ynov.quote.comment;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CommentController {

	private final CommentRepository comments;

	public CommentController(CommentRepository comments) {
		this.comments = comments;
	}

	@GetMapping("/comments")
	public Iterable<Comment> getComments() {
		return comments.findAll();
	}

	@GetMapping("/comments/{id}")
	public Optional<Comment> getCommentById(@PathVariable("id") Integer id) {
		return comments.findById(id);
	}

	@PostMapping("/comments")
	public Comment addComment(@RequestParam("commentText") String commentText,
			@RequestParam("quoteId") Integer quoteId) {
		Comment comment = new Comment();
		comment.setCommentText(commentText);
		comment.setQuoteId(quoteId);
		return comments.save(comment);
	}

	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable("id") Integer id) {
		comments.deleteById(id);
	}
	
	@GetMapping("/comments/findByPetId/{petId}")
	public Iterable<Comment> findByPetId(@PathVariable("petId") Integer petId) {
		return comments.findByPetId(petId);
	}

}
