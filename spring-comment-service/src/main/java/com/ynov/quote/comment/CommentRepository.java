package com.ynov.quote.comment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

	List<Comment> findByPetId(Integer petId);

}
