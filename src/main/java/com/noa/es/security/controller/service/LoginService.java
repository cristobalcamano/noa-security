package com.noa.es.security.controller.service;

import com.noa.es.security.model.dto.UserRequestDto;
import com.noa.es.security.model.entity.Users;

public interface LoginService {

	public Users login(UserRequestDto request) throws Exception;
	
}
