package com.app.service;

import com.app.dtos.UserDto;
import com.app.dtos.UserLogInDto;
import com.app.entities.User;

public interface ChangePasswordService {
	public UserDto changePassWordByEmail(UserLogInDto newPassUser);

}
