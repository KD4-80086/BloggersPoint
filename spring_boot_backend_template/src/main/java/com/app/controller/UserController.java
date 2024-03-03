package com.app.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.BlogDto;
import com.app.dtos.UserDto;
import com.app.dtos.UserLogInDto;
import com.app.dtos.UserRegisterDto;
import com.app.service.ChangePasswordService;
import com.app.service.UserLoginService;
import com.app.service.UsersRegisterService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/login")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	@Autowired
	private UserLoginService usrSer;
	@Autowired
	private ChangePasswordService cps;
	@Autowired
	private UsersRegisterService userReg;
	
	@PostMapping
	public UserDto FindbyEmail(@RequestBody UserLogInDto user) {
		return usrSer.findbyEmailAndPassword(user);

	}
	@PutMapping("/changepassword")
	public UserDto changePassword(@RequestBody UserLogInDto uNewPass) {
	    return cps.changePassWordByEmail(uNewPass);
	}
	
	@PostMapping("/register")
	public UserRegisterDto addEmpDetails(@RequestBody @Valid UserRegisterDto usr)
	// @RequestBody => method arg level annotation , in req handling methods
	// => un marshalling(=de ser) JSON ---> Java , performed by Jackson
	{
		return userReg.addUsersDetail(usr);
	}// handler(RestController) --> @ResponseBody(Java --> JSON) Employee

	@GetMapping("/user/{uId}")
	public List<BlogDto> getAllBlogsByUser(@PathVariable Long uId){
		return usrSer.getAllBlogByUser(uId);
	}
	
	@GetMapping("/currentu/{id}")
	public UserDto getUserById(@PathVariable Long id) {
		return usrSer.findUserById(id);
		
	}
}
