package com.ynov.quotes.author;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

	@Query("SELECT DISTINCT author FROM Author author WHERE author.lastName LIKE :lastName%")
	@Transactional(readOnly = true)
	Collection<Author> findByLastName(@Param("lastName") String lastName);

}