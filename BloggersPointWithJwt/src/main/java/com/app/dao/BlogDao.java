package com.app.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dtos.BlogDto;
import com.app.entities.Blog;
import com.app.entities.Catagory;

public interface BlogDao extends JpaRepository<Blog, Long> {
	 Collection<Blog> findAllByOrderByCreationDateDesc();

	 Optional<Blog> findById(Long id);
	 List<Blog> findByCatgory(Catagory c);
}
