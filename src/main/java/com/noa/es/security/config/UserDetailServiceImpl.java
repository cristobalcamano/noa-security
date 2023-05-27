package com.noa.es.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.noa.es.security.model.entity.Users;
import com.noa.es.security.model.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository ur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users u = ur.findUsersByName(username).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
		try {
			System.out.println(u.getRoles().get(0).getRol().getName());
		} catch (Exception e) {
			System.out.println("Error");
		}
		return new UsersDetailsImpl(u);
	}

}
