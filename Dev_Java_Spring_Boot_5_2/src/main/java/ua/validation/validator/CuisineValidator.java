package ua.validation.validator;

import ua.repository.CuisineRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ua.validation.annotation.UniqueCuisine;

public class CuisineValidator implements ConstraintValidator<UniqueCuisine, String>{

	private final CuisineRepository repository;
	
	public CuisineValidator(CuisineRepository repository){
		this.repository = repository;
	}
	
	
	@Override
	public void initialize(UniqueCuisine arg0) {
		
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext arg1) {
		return !repository.existsByName(name);
	}

	
	
}
