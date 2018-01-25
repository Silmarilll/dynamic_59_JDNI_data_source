package com.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String>{

	private int min;

	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return email.length() >= min && EmailValidator.getInstance().isValid(email);
	}
	
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		min = constraintAnnotation.min();
	}



}
