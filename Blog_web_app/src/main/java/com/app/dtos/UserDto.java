package com.app.dtos;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private Long id;
	private String firstName;	
	private String lastName;
	private String email;
	

}
