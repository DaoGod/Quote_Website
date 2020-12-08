package com.ynov.quote.comment;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.ynov.quote.base.BaseEntity;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

	@NotEmpty
	@Column(name = "commentText")
	private String commentText;

	@Column(name = "quoteId")
	private Integer quoteId;

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Integer getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}
}
