package ua.validation.annotation;

import javax.validation.Payload;
import javax.validation.Constraint;
import ua.validation.validator.IngredientValidator;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = IngredientValidator.class)
public @interface UniqueIngredient {

	String message() default "Not unique";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default {};
	
	
}
