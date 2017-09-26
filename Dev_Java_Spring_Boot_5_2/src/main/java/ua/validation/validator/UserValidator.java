package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ua.repository.UserRepository;
import ua.validation.annotation.UniqueUser;

public class UserValidator implements ConstraintValidator<UniqueUser, String>{

	private final UserRepository repository;
	
	
	public UserValidator(UserRepository repository){
		this.repository = repository;
	}
	
	@Override
	public void initialize(UniqueUser arg0) {
		
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		boolean mulo = repository.findByEmail(email) == null;
		return  mulo;
	}

}
