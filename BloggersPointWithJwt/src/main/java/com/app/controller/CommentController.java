package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CommentDeleteDto;
import com.app.dtos.CommentDto;
import com.app.entities.Comment;
import com.app.service.CommentService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/comment")
@CrossOrigin(origins="http://localhost:3000")
public class CommentController {
	@Autowired
	private CommentService cmtSer;
	
	@PostMapping
	public CommentDto addComment(@RequestBody CommentDto cmt) {
		return cmtSer.addComment(cmt);
	}
	@DeleteMapping
	public void deleteComment(CommentDeleteDto cmt) {
		cmtSer.deleteComment(cmt);
	}
	@PutMapping
	public Comment updateComment(@RequestBody Comment cmt) {
		return cmtSer.findCommentById(cmt);
	}
}
