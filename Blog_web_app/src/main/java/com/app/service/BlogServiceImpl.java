package com.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.coustom_exceptions.ResourceNotFoundException;
import com.app.daos.BlogDao;
import com.app.daos.CatagoryDao;
import com.app.daos.UserLoginDao;
import com.app.dtos.BlogDto;
import com.app.dtos.BlogResDto;
import com.app.dtos.UserDto;
import com.app.entities.Blog;
import com.app.entities.Catagory;
import com.app.entities.User;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CatagoryDao catDao;
	@Autowired
	private UserLoginDao userDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<BlogResDto> getAll() {
		// TODO Auto-generated method stub

		return blogDao.findAllByOrderByCreationDateDesc() // List<Dept>
				.stream() // Stream<Dept>
				.map(blog -> mapper.map(blog, BlogResDto.class)) // Stream<DTO>
				.collect(Collectors.toList());// List<DTO>
	}

	@Override
	public BlogResDto save(BlogDto blog) {
		User u = userDao.findById(blog.getUserid()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		Catagory c = catDao.findById(blog.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("category not found"));
		Blog blog2 = mapper.map(blog, Blog.class);
		u.addBlog(blog2);
		c.addBlog(blog2);
		BlogResDto bDto = mapper.map(blogDao.save(blog2), BlogResDto.class);
		return bDto;
	}

	@Override

	public void delete(Long id) {
		Blog b = blogDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
		User u = userDao.findById(b.getUser().getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		Catagory c = catDao.findById(b.getCatgory().getId())
				.orElseThrow(() -> new ResourceNotFoundException("category not found"));
		u.removeBlog(b);
		c.removeBlog(b);
		blogDao.deleteById(id);
	}

	public BlogDto updateBlogById(Blog updatedBlog) {

		Blog newblog = blogDao.findById(updatedBlog.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Plz enter valid blog id"));
		newblog.setTitle(updatedBlog.getTitle());
		newblog.setBody(updatedBlog.getBody());
		BlogDto b = mapper.map(newblog, BlogDto.class);
		return b;

	}

	@Override
	public BlogDto getBlogById(Long id) {

		Blog b = blogDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enter valid blog id!!!!"));
		BlogDto bDto = mapper.map(b, BlogDto.class);
		return bDto;
	}

	@Override
	public List<BlogDto> findBlogByCategory(Long catId) {
		Catagory c = catDao.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category id not found"));

		return blogDao.findByCatgory(c) // List<Dept>
				.stream() // Stream<Dept>
				.map(blog -> mapper.map(blog, BlogDto.class)) // Stream<DTO>
				.collect(Collectors.toList());// List<DTO>
	}

}
