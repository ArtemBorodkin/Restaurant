package ua.attribute.converter;

import ua.entity.Cuisine;
import org.springframework.stereotype.Component;
import ua.repository.CuisineRepository;
import org.springframework.core.convert.converter.Converter;

@Component
public class CuisineConverter implements Converter<String, Cuisine>{

	private final CuisineRepository repository;
	
	public CuisineConverter(CuisineRepository repository){
		this.repository = repository;
	}
	
	@Override
	public Cuisine convert(String source){
		return repository.findByName(source);
	}
}
