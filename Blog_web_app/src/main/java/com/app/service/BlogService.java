package com.app.service;

import java.util.Collection;

import com.app.entities.Blog;

public interface BlogService {
	
	Blog save(Blog blog);

    
    void delete(Long id);
    
    Blog findBlogById(Blog updatedBlog);
    Collection<Blog> getAll();

}
