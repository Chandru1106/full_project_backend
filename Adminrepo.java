package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Adminmodel;


public interface Adminrepo extends JpaRepository<Adminmodel, Integer> {
    Adminmodel findByEmail(String email);
}
