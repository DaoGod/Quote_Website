package com.ynov.quotes.quote;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class QuoteTypeFormatter implements Formatter<QuoteType> {

	private final QuoteRepository quotes;

	@Autowired
	public QuoteTypeFormatter(QuoteRepository quotes) {
		this.quotes = quotes;
	}

	@Override
	public String print(QuoteType quoteType, Locale locale) {
		return quoteType.getName();
	}

	@Override
	public QuoteType parse(String text, Locale locale) throws ParseException {
		Collection<QuoteType> findQuoteTypes = this.quotes.findQuoteTypes();
		for (QuoteType type : findQuoteTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}

}
