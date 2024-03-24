package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.coustom_exceptions.ResourceNotFoundException;
import com.app.dao.UserLoginDao;
import com.app.dtos.BlogDto;
import com.app.dtos.UserDto;
import com.app.dtos.UserLogInDto;
import com.app.entities.User;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserLoginDao usrLogindao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto findbyEmailAndPassword(UserLogInDto usr) {
		User user=null;
	    user= usrLogindao.findByEmailAndPassword(usr.getEmail(),usr.getPassword());
	  if (user!=null) 
	    {
		  UserDto uDto=mapper.map(user, UserDto.class);
		  return uDto;	
	  	}
	  return null;
	}

	@Override
	public List<BlogDto> getAllBlogByUser(Long id) {
		User u=usrLogindao.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found!!!!"));
		
		return u.getBlog()
				.stream() // Stream<Dept>
				.map(blog -> mapper.map(blog, BlogDto.class)) // Stream<DTO>
				.collect(Collectors.toList());// List<DTO>;
	}

	@Override
	public UserDto findUserById(Long id) {
		
	   User u=usrLogindao.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
	   UserDto udto=mapper.map(u, UserDto.class);
	   return udto;
	}
}
