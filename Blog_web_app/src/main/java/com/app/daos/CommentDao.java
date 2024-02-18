package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dtos.CommentDto;
import com.app.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
