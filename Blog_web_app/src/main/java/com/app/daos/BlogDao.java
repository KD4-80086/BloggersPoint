package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Blog;

public interface BlogDao extends JpaRepository<Blog, Long>{
	

}
