package com.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.app.dtos.BlogDto;
import com.app.dtos.BlogResDto;
import com.app.entities.Blog;

public interface BlogService {

	List<BlogResDto> getAll();

	BlogResDto save(BlogDto blog);

	BlogDto getBlogById(Long id);

	void delete(Long id);

	BlogDto updateBlogById(Blog updatedBlog);

	List<BlogDto> findBlogByCategory(Long catId);

}
