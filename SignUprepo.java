package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Signupmodel;

public interface SignUprepo extends JpaRepository<Signupmodel, Integer> {
    Signupmodel findByEmail(String email);
}
