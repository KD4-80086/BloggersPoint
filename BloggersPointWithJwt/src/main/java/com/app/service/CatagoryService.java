package com.app.service;

import java.util.List;

import com.app.dtos.BlogDto;
import com.app.dtos.CategoryDto;
import com.app.entities.Blog;
import com.app.entities.Catagory;

public interface CatagoryService {
	Catagory addCatagory(String cat);
	List<BlogDto> getAllBlogsOfThatCatagory(Long catId);
	List<CategoryDto> getAllCategory();

}
