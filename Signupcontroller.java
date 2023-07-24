package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Signupmodel;

import com.example.demo.service.Signupservice;

@RestController
@CrossOrigin
public class Signupcontroller {
	@Autowired
	Signupservice eser;
	@PostMapping("/add")
	
	public Signupmodel addDetails(@RequestBody  Signupmodel e)
	{
		return eser.saveDetails(e);
	}
	
	@GetMapping("/show")
	public List<Signupmodel> fetchDetails()
	{
		return eser.getDetails();
	}
	  @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestBody Signupmodel loginData) {
	        String email = loginData.getEmail();
	        String password = loginData.getPassword();

	        Signupmodel user = eser.findByEmail(email);

	        if (user == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }

	        // Check if the password matches
	        if (!user.getPassword().equals(password)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }

	        // Authentication successful, you can return a success message or user data here
	        return ResponseEntity.ok("Login successful");
	    }
    
}
