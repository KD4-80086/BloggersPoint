package com.app.service;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.UserRegisterDao;
import com.app.entities.User;

public interface UsersRegisterService  {
	
	User addUsersDetail(User usr);
	

}
