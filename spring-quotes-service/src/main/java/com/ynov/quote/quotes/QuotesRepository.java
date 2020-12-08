package com.ynov.quote.quotes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface QuotesRepository extends CrudRepository<Quotes, Integer> {

	@Query("SELECT * FROM Quote WHERE quotesText <= 10 DESC")
	@Transactional(readOnly = true)
	Iterable<Quotes> findByTopVote();

}