package com.app.dtos;

import com.app.entities.Blog;
import com.app.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private String comment;
	private User user;
	private Blog blog;

}
