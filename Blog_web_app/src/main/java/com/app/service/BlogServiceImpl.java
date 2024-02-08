package com.app.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.BlogDao;
import com.app.entities.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDao blogDao;

	
	@Override
	public Blog save(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.save(blog);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 blogDao.deleteById(id);
	}
	
	@Override
	public Collection<Blog> getAll() {
		// TODO Auto-generated method stub
		
		return blogDao.findAllByOrderByCreationDateDesc();
	}
	
     public Blog findBlogById(Blog updatedBlog) {
		
		Blog newblog=blogDao.findById(updatedBlog.getId()).orElseThrow(null);
		newblog.setTitle(updatedBlog.getTitle());
		newblog.setBody(updatedBlog.getBody());
		return newblog;

	}

}
