package com.app.service;

import java.util.List;

import com.app.dtos.BlogDto;
import com.app.dtos.UserDto;
import com.app.dtos.UserLogInDto;
import com.app.entities.User;

public interface UserLoginService {
	
	public UserDto findbyEmailAndPassword(UserLogInDto usr);
	List<BlogDto> getAllBlogByUser(Long id);
	public UserDto findUserById(Long id);

}
