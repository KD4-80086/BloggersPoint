package com.app.service;

import com.app.dtos.CommentDeleteDto;
import com.app.dtos.CommentDto;
import com.app.entities.Comment;

public interface CommentService {
	CommentDto addComment (CommentDto cmt);
	void deleteComment(CommentDeleteDto cmt);
	Comment findCommentById(Comment newCmt);

}
