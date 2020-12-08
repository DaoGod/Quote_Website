package com.ynov.quotes.quote;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "quotes")
public class Quote extends com.ynov.quotes.base.NamedEntity {

	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private QuoteType type;

	private Integer ownerId;

	@Transient
	private HashSet<Integer> visits = new LinkedHashSet<>();

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public QuoteType getType() {
		return this.type;
	}

	public void setType(QuoteType type) {
		this.type = type;
	}

	public Integer getOwner() {
		return this.ownerId;
	}

	public void setOwner(Integer owner) {
		this.ownerId = owner;
	}

	public HashSet<Integer> getVisits() {
		if (this.visits == null) {
			this.visits = new HashSet<>();
		}
		return this.visits;
	}

	public void addVisit(Integer visit) {
		getVisits().add(visit);
	}

}
