package com.app.service;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.UserLoginDao;
import com.app.dtos.UserLogInDto;
import com.app.entities.User;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserLoginDao usrLogindao;

	@Override
	public User findbyEmailAndPassword(UserLogInDto usr) {
		User user=null;
	    user= usrLogindao.findByEmailAndPassword(usr.getEmail(),usr.getPassword());
	  if (user!=null) 
	    {
		  return user;	
	  	}
	  return null;
	}

	
	
	

}
