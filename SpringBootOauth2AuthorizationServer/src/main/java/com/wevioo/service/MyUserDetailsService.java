package com.wevioo.service;

import java.util.Optional;

import com.wevioo.entity.User;
import com.wevioo.model.MyUserDetails;
import com.wevioo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
	    return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

}
