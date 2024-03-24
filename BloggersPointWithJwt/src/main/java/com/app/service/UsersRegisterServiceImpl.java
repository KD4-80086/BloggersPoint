package com.app.service;

import javax.transaction.Transactional;  

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.app.dao.UserRegisterDao;
import com.app.dtos.UserDto;
import com.app.dtos.UserRegisterDto;
import com.app.entities.User;

@Service
@Transactional
public class UsersRegisterServiceImpl implements UsersRegisterService {
	@Autowired
	private UserRegisterDao userRegDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder  encoder;
	@Override
	public UserRegisterDto addUsersDetail(UserRegisterDto usr) {
		User u=mapper.map(usr, User.class);
		u.setPassword(encoder.encode(usr.getPassword()));
		u.setRole("ROLE_USER");
		User user=userRegDao.save(u);
		return mapper.map(user, UserRegisterDto.class);
	}

	

	
	

}
