package ua.validation.validator;

import ua.repository.MealRepository;
import ua.validation.annotation.UniqueMeal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MealValidator implements ConstraintValidator<UniqueMeal, String>{

	private final MealRepository repository;
	
	public MealValidator(MealRepository repository){
		this.repository = repository;
	}
	
	@Override
	public void initialize(UniqueMeal arg){
		
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg2){
		System.out.println();
		System.err.println(repository.existsByName(value));
		System.out.println();
		return !repository.existsByName(value);
	}
	
}
