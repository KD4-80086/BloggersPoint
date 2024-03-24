package com.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.BlogDto;
import com.app.dtos.BlogResDto;
import com.app.entities.Blog;
import com.app.service.BlogService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/blog")
@CrossOrigin(origins="http://localhost:3000")
public class PostController {
	
	@Autowired
	private  BlogService blogService;
	@GetMapping
	public List<BlogResDto> getAllBlog() {
		
		return blogService.getAll(); 
	}
	
	@PostMapping("/addblog")
	public BlogResDto addBlog(@RequestBody BlogDto blg)
	// @RequestBody => method arg level annotation , in req handling methods
	// => un marshalling(=de ser) JSON ---> Java , performed by Jackson
	{
		return blogService.save(blg);
	}// handler(RestController) --> @ResponseBody(Java --> JSON) Employee


	@DeleteMapping("/{id}")
	public void deleteBlog(@PathVariable Long id) {
		blogService.delete(id);
		getAllBlog();
	}
	

    
	@PutMapping
	public BlogDto updateBlogById(@RequestBody Blog updatedPost){
		return blogService.updateBlogById(updatedPost);
	}
	
	@GetMapping("/{id}")
	public BlogDto getBlogByid(@PathVariable Long id) {
		return blogService.getBlogById(id);
	}
	
	@GetMapping("/category/{id}")
	public List<BlogDto> findBlogByCategoryId(@PathVariable Long id) {
		return blogService.findBlogByCategory(id);
	}

}
