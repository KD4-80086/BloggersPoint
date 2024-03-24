package com.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
	
	@NotBlank(message = "first name required....")
	private String firstName;
	
	@NotBlank(message = "last name required....")
	private String lastName;
	
	@NotBlank(message = "email required....")
	@Email(message = "Invalid email format!!")
	private String email;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password")
	private String password;
	

}
