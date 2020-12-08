package com.ynov.quotes.models;

public class QuotesList {
	
	private String quote;
	private String author;
	
	public QuotesList(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}
	
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}	
}
