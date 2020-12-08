package com.ynov.quotes.models;

public class Comment {
	
	private String quoteID;
	private String comment;
	private String author;
	
	public Comment(String quoteID, String comment, String author) {
		this.quoteID = quoteID;
		this.comment = comment;
		this.author = author;
	}
	
	public String getQuoteID() {
		return quoteID;
	}
	public void setQuoteID(String quoteID) {
		this.quoteID = quoteID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
