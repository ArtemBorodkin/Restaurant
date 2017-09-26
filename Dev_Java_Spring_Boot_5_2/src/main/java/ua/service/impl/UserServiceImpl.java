package ua.service.impl;

import ua.entity.User;
import ua.entity.Role;
import ua.service.UserService;
import ua.repository.UserRepository;
import org.springframework.stereotype.Service;
import ua.model.request.RegistrationRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository repository;
	
	private final PasswordEncoder encoder;

	public UserServiceImpl(UserRepository repository, PasswordEncoder encoder){
		this.repository = repository;
		this.encoder = encoder;
	}
	
	public void save(RegistrationRequest request){
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(Role.ROLE_CLIENT);
		repository.save(user);
	}
	
}
