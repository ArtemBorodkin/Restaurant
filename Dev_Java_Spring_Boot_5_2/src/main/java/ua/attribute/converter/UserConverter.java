package ua.attribute.converter;

import ua.entity.User;
import ua.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class UserConverter implements Converter<String, User>{

	private final UserRepository repository;
	
	public UserConverter(UserRepository repository){
		this.repository = repository;
	}
	
	@Override
	public User convert(String source){
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!email.equals("anonymousUser")){
			return repository.findByEmail(email);
		}
		return null;
	}
	
}
