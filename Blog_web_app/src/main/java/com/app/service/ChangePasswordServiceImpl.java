package com.app.service;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.ChangePasswordDao;
import com.app.dtos.UserLogInDto;
import com.app.entities.User;
@Service
@Transactional
public class ChangePasswordServiceImpl implements ChangePasswordService {
	@Autowired
	private ChangePasswordDao passDao;

	@Override
	public User changePassWordByEmail(UserLogInDto newPassUser) {

		User usr=passDao.findUserByEmail(newPassUser.getEmail());
		if (usr!=null) {
			usr.setPassword(newPassUser.getPassword());
			
			return usr;
		}
		else {
			return null;
		}
		
	}

}
