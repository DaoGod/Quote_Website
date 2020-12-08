package com.ynov.quote.author;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import com.ynov.quote.base.BaseEntity;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

	@Column(name = "nickname")
	@NotEmpty
	private String nickname;

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	private HashSet<Integer> quotes;

	protected Set<Integer> getQuotesInternal() {
		if (this.quotes == null) {
			this.quotes = new HashSet<>();
		}
		return this.quotes;
	}

	protected void setQuotesInternal(Set<Integer> quotes) {
		this.quotes = new HashSet<>(quotes);
	}

	public List<Integer> getQuotes() {
		return new ArrayList<>(getQuotesInternal());
	}

	public void addQuote(Integer quoteId) {
			getQuotesInternal().add(quoteId);
	}
}