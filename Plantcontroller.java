package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Plantmodel;
import com.example.demo.service.Plantservice;

@RestController
public class Plantcontroller {
	@Autowired(required=true)
	Plantservice eser;
	@PostMapping("/addplant")
	
	public Plantmodel addDetails(@RequestBody   Plantmodel   e)
	{
		return eser.saveDetails(e);
	}
	
	@GetMapping("/showplant")
	public List< Plantmodel  > fetchDetails()
	{
		return eser.getDetails();
	}
	@PutMapping("/updatingplant/{id}")
    public Plantmodel   updateInfo(@PathVariable int id,@RequestBody  Plantmodel   s)
    {
    	return eser.updateDetails(id, s);
    	
    }
    @DeleteMapping("/deleteplant/{id}")
    public String deleteInfo1(@PathVariable("id") int id)
    {
    	eser.deleteDetails1(id);
    	return "Details Deleted Successfully";
    }
}
