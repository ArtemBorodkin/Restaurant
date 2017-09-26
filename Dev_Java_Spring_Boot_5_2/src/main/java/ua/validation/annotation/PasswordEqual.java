package ua.validation.annotation;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.validation.validator.PasswordsEqualConstrainetValidator;

@Retention(RUNTIME)
@Constraint(validatedBy=PasswordsEqualConstrainetValidator.class)
public @interface PasswordEqual {

	
	String message() default "The passwords not equal";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
