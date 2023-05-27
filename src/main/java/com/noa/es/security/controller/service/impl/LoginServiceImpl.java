package com.noa.es.security.controller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noa.es.security.controller.service.LoginService;
import com.noa.es.security.model.dto.UserRequestDto;
import com.noa.es.security.model.entity.Users;
import com.noa.es.security.model.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepository ur;

	@Override
	public Users login(UserRequestDto request) throws Exception {
		// TODO Auto-generated method stub
		Users u = ur.findUsersByName(request.getName()).orElse(null);
		
		return u;
	}

}
