package com.app.service;

import com.app.dtos.UserLogInDto;
import com.app.entities.User;

public interface UserLoginService {
	
	public User findbyEmailAndPassword(UserLogInDto usr);

}
