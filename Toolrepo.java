package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Toolmodel;

public interface Toolrepo extends JpaRepository<Toolmodel,Integer> {
	
}
