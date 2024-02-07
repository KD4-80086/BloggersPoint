package com.app.service;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.UserRegisterDao;
import com.app.entities.User;

@Service
@Transactional
public class UsersRegisterServiceImpl implements UsersRegisterService {
	@Autowired
	private UserRegisterDao userRegDao;

	@Override
	public User addUsersDetail(User usr) {
		// TODO Auto-generated method stub
		return userRegDao.save(usr);
	}

	

	
	

}
