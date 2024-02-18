package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.UserRegisterDao;
import com.app.dtos.UserRegisterDto;
import com.app.entities.User;

@Service
@Transactional
public class UsersRegisterServiceImpl implements UsersRegisterService {
	@Autowired
	private UserRegisterDao userRegDao;

	@Autowired
	private ModelMapper mapper;
	@Override
	public UserRegisterDto addUsersDetail(UserRegisterDto usr) {
		User u=mapper.map(usr, User.class);
		User user=userRegDao.save(u);
		return mapper.map(user, UserRegisterDto.class);
	}

	

	
	

}
