package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Signupmodel;
import com.example.demo.repository.SignUprepo;


@Service
public class Signupservice {
	@Autowired
	SignUprepo prepo;
	
	public Signupmodel saveDetails(Signupmodel e)
	{
		
	return prepo.save(e);
	}
    public List<Signupmodel> getDetails()
    {
    	return prepo.findAll();
    }
    public Signupmodel findByEmail(String email) {
        return prepo.findByEmail(email);
    }
   
}

