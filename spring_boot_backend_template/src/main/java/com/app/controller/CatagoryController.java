package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.BlogDto;
import com.app.dtos.CategoryDto;
import com.app.entities.Blog;
import com.app.entities.Catagory;
import com.app.service.CatagoryService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/catagory")
@CrossOrigin(origins="http://localhost:3000")
public class CatagoryController {
	@Autowired 
	private CatagoryService catSer;
	
	@PostMapping
	public Catagory addCatagory(@RequestBody Catagory cat) {
		return catSer.addCatagory(cat);
	}
	@GetMapping("/{id}")
	public List<BlogDto> getAllBlogByCatagory(@PathVariable Long id){
		return catSer.getAllBlogsOfThatCatagory(id);
		
	}
	@GetMapping
	public List<CategoryDto> getAllCategory(){
		return catSer.getAllCategory();
		
	}

}
