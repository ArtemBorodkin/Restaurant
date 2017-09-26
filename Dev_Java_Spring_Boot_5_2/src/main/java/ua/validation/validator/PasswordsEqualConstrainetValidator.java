package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ua.model.request.RegistrationRequest;
import ua.validation.annotation.PasswordEqual;

public class PasswordsEqualConstrainetValidator implements ConstraintValidator<PasswordEqual, RegistrationRequest>{

	@Override
	public void initialize(PasswordEqual arg0) {
	}

	@Override
	public boolean isValid(RegistrationRequest request, ConstraintValidatorContext arg1) {
		return request.getPassword().equals(request.getRepeatPassword());
	}

}
