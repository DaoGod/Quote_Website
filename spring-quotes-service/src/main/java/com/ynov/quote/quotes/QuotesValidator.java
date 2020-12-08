package com.ynov.quote.quotes;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class QuotesValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Quotes quote = (Quotes) obj;
		String quoteDesc = quote.getQuotesDesc();

		if (!StringUtils.hasLength(quoteDesc)) {
			errors.rejectValue("quoteDesc", REQUIRED, REQUIRED);
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Quotes.class.isAssignableFrom(clazz);
	}
}