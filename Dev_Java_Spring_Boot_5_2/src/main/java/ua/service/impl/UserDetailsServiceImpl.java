package ua.service.impl;

import ua.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository repository;
	
	public UserDetailsServiceImpl(UserRepository repository){
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		ua.entity.User user = repository.findByEmail(username);
		if(user==null)throw new UsernameNotFoundException("User with email " + username +" isn't exists");
		return new User(username, user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()));
	}
	
}
