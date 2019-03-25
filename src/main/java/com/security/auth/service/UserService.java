package com.security.auth.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.auth.UserPrinciple;
import com.security.auth.data.entity.AuthGroup;
import com.security.auth.data.entity.User;
import com.security.auth.data.repository.AuthGroupRepository;
import com.security.auth.data.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final AuthGroupRepository authGroupRepository;
	
	public UserService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
		super();
		this.userRepository = userRepository;
		this.authGroupRepository = authGroupRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(null == user) {
			throw new UsernameNotFoundException("Cannot find username: " + username);
		}
		List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
		return new UserPrinciple(user, authGroups);
	}
}
