package com.ynov.quote.quotes;

import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "quotes")
public class Quotes extends com.ynov.quote.base.BaseEntity {

	private Integer authorId;
	
	@Column(name = "quotesText")
	private String quotesText;

	@Transient
	private HashSet<Integer> comment = new LinkedHashSet<>();
	
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getQuotesDesc() {
		return quotesText;
	}

	public void setQuotesDesc(String quotesText) {
		this.quotesText = quotesText;
	}

	public HashSet<Integer> getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		getComment().add(comment);
	}
}
