package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Plantmodel;

public interface Plantrepo extends JpaRepository<Plantmodel,Integer> {
	
}
