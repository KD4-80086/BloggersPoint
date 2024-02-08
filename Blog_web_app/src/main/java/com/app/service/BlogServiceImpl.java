package com.app.service;

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

}
