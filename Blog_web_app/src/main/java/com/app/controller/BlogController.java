package com.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Blog;
import com.app.service.BlogService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private  BlogService blogService;
	
	@PostMapping
	public Blog addBlog(@RequestBody Blog blg)
	// @RequestBody => method arg level annotation , in req handling methods
	// => un marshalling(=de ser) JSON ---> Java , performed by Jackson
	{
		return blogService.save(blg);
	}// handler(RestController) --> @ResponseBody(Java --> JSON) Employee


	@DeleteMapping
	public void deleteBlog(long id) {
		blogService.delete(id);
		
	}
	
	@PutMapping
	public Blog updateBlogById(@RequestBody Blog updatedPost){
		return blogService.findBlogById(updatedPost);
	}
	@GetMapping
	public Collection<Blog> getAllBlog() {
		return blogService.getAll(); 
	}
}
