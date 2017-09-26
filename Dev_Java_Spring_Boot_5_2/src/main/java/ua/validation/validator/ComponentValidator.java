package ua.validation.validator;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ua.repository.ComponentRepository;
import ua.model.request.ComponentRequest;
import ua.validation.annotation.UniqueComponent;

public class ComponentValidator implements ConstraintValidator<UniqueComponent, ComponentRequest>{

	
	private final ComponentRepository repository;
	
	public ComponentValidator(ComponentRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueComponent arg0) {
		
		
	}

	@Override
	public boolean isValid(ComponentRequest request, ConstraintValidatorContext arg1) {
		boolean present = true;
		String amount = request.getAmount();
		boolean isNumeric = amount.chars().allMatch( Character::isDigit );
		if(isNumeric){
	if(repository.existsComponent(request.getIngredient().getName(), 
			request.getMs().getName(),new BigDecimal(amount))!= null){
		present = false;
		System.out.println();
		System.err.println(present);
		System.out.println();
	}
		}
		return present;
	}

}
