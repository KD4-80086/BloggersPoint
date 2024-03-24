package com.app.service;



import javax.validation.Valid;

import com.app.dtos.UserDto;
import com.app.dtos.UserRegisterDto;

public interface UsersRegisterService  {
	
	UserRegisterDto addUsersDetail(UserRegisterDto usr);
	

}
