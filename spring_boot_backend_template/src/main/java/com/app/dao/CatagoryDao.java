package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Catagory;

public interface CatagoryDao extends JpaRepository<Catagory, Long> {

}
