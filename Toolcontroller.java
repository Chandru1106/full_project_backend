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

import com.example.demo.model.Toolmodel;
import com.example.demo.service.Toolservice;

@RestController
public class Toolcontroller {
	@Autowired(required=true)
	Toolservice eser;
	@PostMapping("/addtool")
	
	public Toolmodel  addDetails(@RequestBody   Toolmodel  e)
	{
		return eser.saveDetails(e);
	}
	
	@GetMapping("/showtool")
	public List< Toolmodel  > fetchDetails()
	{
		return eser.getDetails();
	}
	@PutMapping("/updatingtool/{id}")
    public  Toolmodel   updateInfo(@PathVariable int id,@RequestBody  Toolmodel  s)
    {
    	return eser.updateDetails(id, s);
    	
    }
    @DeleteMapping("/deletetool/{id}")
    public String deleteInfo1(@PathVariable("id") int id)
    {
    	eser.deleteDetails1(id);
    	return "Details Deleted Successfully";
    }
}
