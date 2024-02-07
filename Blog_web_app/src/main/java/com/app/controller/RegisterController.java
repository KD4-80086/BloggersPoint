package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.service.UsersRegisterService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UsersRegisterService userReg;
	
	@PostMapping
	public User addEmpDetails(@RequestBody User usr)
	// @RequestBody => method arg level annotation , in req handling methods
	// => un marshalling(=de ser) JSON ---> Java , performed by Jackson
	{
		return userReg.addUsersDetail(usr);
	}// handler(RestController) --> @ResponseBody(Java --> JSON) Employee

}
