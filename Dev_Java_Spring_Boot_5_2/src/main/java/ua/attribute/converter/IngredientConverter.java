package ua.attribute.converter;

import ua.entity.Ingredient;
import ua.repository.IngredientRepository;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class IngredientConverter implements Converter<String, Ingredient>{

	private final IngredientRepository repository;
	
	public IngredientConverter(IngredientRepository repository){
		this.repository = repository;
	}

	@Override
	public Ingredient convert(String source) {
		return repository.findByName(source);
	}
}
