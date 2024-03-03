package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ChangePasswordDao;
import com.app.dtos.UserDto;
import com.app.dtos.UserLogInDto;
import com.app.entities.User;
@Service
@Transactional
public class ChangePasswordServiceImpl implements ChangePasswordService {
	@Autowired
	private ChangePasswordDao passDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public UserDto changePassWordByEmail(UserLogInDto newPassUser) {

		User usr=passDao.findUserByEmail(newPassUser.getEmail());
		if (usr!=null) {
			usr.setPassword(newPassUser.getPassword());
			UserDto uDto=mapper.map(usr, UserDto.class);
			return uDto;
		}
		else {
			return null;
		}
		
	}

}
