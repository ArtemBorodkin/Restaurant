package ua.validation.validator;

import ua.repository.IngredientRepository;
import javax.validation.ConstraintValidator;
import ua.validation.annotation.UniqueIngredient;
import javax.validation.ConstraintValidatorContext;

public class IngredientValidator implements ConstraintValidator<UniqueIngredient, String>{
	
	private final IngredientRepository repository;
	
	public IngredientValidator(IngredientRepository repository){
		this.repository = repository;
	}
	
	@Override
	public void initialize(UniqueIngredient arg){
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1){
		return !repository.existsByName(value);
	}
	
}
