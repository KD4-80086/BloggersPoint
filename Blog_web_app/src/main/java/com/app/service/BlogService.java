package com.app.service;

import com.app.entities.Blog;

public interface BlogService {
	
	Blog save(Blog blog);

    
    void delete(Long id);

}
