package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.UserLogInDto;
import com.app.entities.User;
import com.app.service.UserLoginService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/login")
@CrossOrigin(origins="http://localhost:3000")
public class LoginController {
	@Autowired
	private UserLoginService usrSer;
	
	@PostMapping
	public User FindbyEmail(@RequestBody UserLogInDto user) {
		return usrSer.findbyEmailAndPassword(user);

	}

}
