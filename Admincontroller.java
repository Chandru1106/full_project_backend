package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Adminmodel;
import com.example.demo.service.Adminservice;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class Admincontroller {
	@Autowired
	Adminservice eser;
	@PostMapping("/addadmin")
	
	public Adminmodel addDetails(@RequestBody  Adminmodel e)
	{
		return eser.saveDetails(e);
	}
	
	@GetMapping("/showadmin")
	public List<Adminmodel> fetchDetails()
	{
		return eser.getDetails();
	}
	  @PostMapping("/loginadmin")
	    public ResponseEntity<String> loginUser(@RequestBody Adminmodel loginData) {
	        String email = loginData.getEmail();
	        String password = loginData.getPassword();

	        Adminmodel user = eser.findByEmail(email);

	        if (user == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }

	        if (!user.getPassword().equals(password)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }

	       
	        return ResponseEntity.ok("Login successful");
	    }
}
