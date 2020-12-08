package com.ynov.quote.author;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

	@Query("SELECT DISTINCT author FROM Author author WHERE author.nickname LIKE :nickname%")
	@Transactional(readOnly = true)
	Collection<Author> findByNickname(@Param("nickname") String nickname);

}