package com.app.service;

import java.util.List; 
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.coustom_exceptions.ResourceNotFoundException;
import com.app.daos.CatagoryDao;
import com.app.dtos.BlogDto;
import com.app.dtos.CategoryDto;
import com.app.entities.Blog;
import com.app.entities.Catagory;

@Service
@Transactional
public class CatagoryServiceImpl implements CatagoryService {
	@Autowired
	private CatagoryDao catDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public Catagory addCatagory(Catagory cat){
		return catDao.save(cat);
	}

	@Override
	public List<BlogDto> getAllBlogsOfThatCatagory(Long catId) {
		Catagory c=catDao.findById(catId).orElseThrow(()->new ResourceNotFoundException("Catagory not found"));
		//return (List<BlogDto>) mapper.map(c.getBlog(), BlogDto.class);
		return c.getBlog() // List<Dept>
			.stream() // Stream<Dept>
			.map(blog -> mapper.map(blog, BlogDto.class)) // Stream<DTO>
			.collect(Collectors.toList());// List<DTO>
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Catagory> category=catDao.findAll();
		   return  category
				.stream() // Stream<Dept>
				.map(cat -> mapper.map(cat, CategoryDto.class)) // Stream<DTO>
				.collect(Collectors.toList());
	}
	

}
