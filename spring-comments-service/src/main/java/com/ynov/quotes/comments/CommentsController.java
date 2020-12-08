package com.ynov.quotes.comments;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class CommentsController {

	private final CommentsRepository comments;

	public CommentsController(CommentsRepository comments) {
		this.comments = comments;
	}

	@GetMapping("/comments")
	public Iterable<Comments> getcomments() {
		return comments.findAll();
	}

	@GetMapping("/comments/{id}")
	public Optional<Comments> getcommentById(@PathVariable("id") Integer id) {
		return comments.findById(id);
	}

	@PostMapping("/comments")
	public Comments addcomment(@RequestParam("date") LocalDate date, @RequestParam("description") String description,
			@RequestParam("commentId") Integer commentId) {
		Comments comment = new Comments();
		comment.setDate(date);
		comment.setDescription(description);
		comment.setcommentId(commentId);
		return comments.save(comment);
	}

	@DeleteMapping("/comments/{id}")
	public void deletecomment(@PathVariable("id") Integer id) {
		comments.deleteById(id);
	}
	
	@GetMapping("/comments/findBycommentId/{commentId}")
	public Iterable<Comments> findBycommentId(@PathVariable("commentId") Integer commentId) {
		return comments.findByCommentId(commentId);
	}

}
