package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Homemodel;

public interface Homerepo extends JpaRepository<Homemodel,Integer> {
	
}
