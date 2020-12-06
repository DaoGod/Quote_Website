package com.ynov.quotes.models;

public class Quote {
	
	private String quoteID;
	private String quote;
	private String author;
	
	public Quote(String quoteID, String quote, String author) {
		this.quoteID = quoteID;
		this.quote = quote;
		this.author = author;
	}
	
	public String getQuoteID() {
		return quoteID;
	}
	public void setQuoteID(String quoteID) {
		this.quoteID = quoteID;
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
