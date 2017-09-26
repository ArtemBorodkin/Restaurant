package ua.attribute.converter;

import ua.entity.Ms;
import ua.repository.MsRepository;

import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class MsConverter implements Converter<String, Ms>{
	
	private final MsRepository repository;
	
	public MsConverter(MsRepository repository){
		this.repository = repository;
	}

	@Override
	public Ms convert(String source) {
		return repository.findByName(source);
	}
	
	

}
