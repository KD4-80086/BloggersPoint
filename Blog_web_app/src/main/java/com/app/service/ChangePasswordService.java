package com.app.service;

import com.app.dtos.UserLogInDto;
import com.app.entities.User;

public interface ChangePasswordService {
	public User changePassWordByEmail(UserLogInDto newPassUser);

}
