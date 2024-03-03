package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface ChangePasswordDao extends JpaRepository<User, Long> {
	public User findUserByEmail(String email);

}
