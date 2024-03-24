package com.app.dtos;

import java.time.LocalDate;

import com.app.entities.Catagory;
import com.app.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
	
	private String title;
	private String body;
	private LocalDate creationDate;
	private Long userid;
	private Long categoryId;

}
