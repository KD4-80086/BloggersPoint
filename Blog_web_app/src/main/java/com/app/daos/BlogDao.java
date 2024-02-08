package com.app.daos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Blog;

public interface BlogDao extends JpaRepository<Blog, Long>{
	Collection<Blog> findAllByOrderByCreationDateDesc();

	 Optional<Blog> findById(Long id);
	

}
