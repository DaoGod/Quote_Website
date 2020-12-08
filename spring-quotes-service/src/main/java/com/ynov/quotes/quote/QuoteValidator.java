package com.ynov.quotes.quote;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class QuoteValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Quote quote = (Quote) obj;
		String name = quote.getName();

		if (!StringUtils.hasLength(name)) {
			errors.rejectValue("name", REQUIRED, REQUIRED);
		}

		if (quote.isNew() && quote.getType() == null) {
			errors.rejectValue("type", REQUIRED, REQUIRED);
		}

		if (quote.getBirthDate() == null) {
			errors.rejectValue("birthDate", REQUIRED, REQUIRED);
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Quote.class.isAssignableFrom(clazz);
	}

}
