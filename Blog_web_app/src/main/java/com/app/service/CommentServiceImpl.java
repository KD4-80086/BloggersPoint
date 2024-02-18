package com.app.service;

import javax.transaction.Transactional; 

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.coustom_exceptions.ResourceNotFoundException;
import com.app.daos.CommentDao;
import com.app.dtos.CommentDeleteDto;
import com.app.dtos.CommentDto;
import com.app.entities.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao cmtDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CommentDto addComment(CommentDto cmt) {
		Comment c=mapper.map(cmt, Comment.class);
		
		Comment nc= cmtDao.save(c);
		return mapper.map(c, CommentDto.class);
	}
	@Override
	public void deleteComment(CommentDeleteDto cmt) {
		Comment cmt1=cmtDao.findById(cmt.getId()).orElseThrow(()->new ResourceNotFoundException("Comment not found"));
		if ((cmt.getUserId())==cmt1.getUser().getId() && (cmt.getBlogId()==cmt1.getBlog().getId())) {
			cmtDao.delete(cmt1);	
		}
		
		
	}
	@Override
	public Comment findCommentById(Comment newCmt) {
		Comment comment= cmtDao.findById(newCmt.getId()).orElseThrow(()->new ResourceNotFoundException("Plz enter valid comment id"));
		if (comment!=null) {
			comment.setComment(newCmt.getComment());
			return comment;
		}
		else {
			comment=null;
			return comment;
		}
			 
	}
	

}
