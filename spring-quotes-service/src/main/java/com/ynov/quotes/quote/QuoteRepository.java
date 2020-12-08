package com.ynov.quotes.quote;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface QuoteRepository extends CrudRepository<Quote, Integer> {

	@Query("SELECT ptype FROM QuoteType ptype ORDER BY ptype.name")
	@Transactional(readOnly = true)
	List<QuoteType> findQuoteTypes();


}
