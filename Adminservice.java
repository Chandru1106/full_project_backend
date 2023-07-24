package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Adminmodel;
import com.example.demo.repository.Adminrepo;

@Service
public class Adminservice {
	@Autowired
	Adminrepo prepo;
	
	public Adminmodel saveDetails(Adminmodel e)
	{
		
	return prepo.save(e);
	}
    public List< Adminmodel> getDetails()
    {
    	return prepo.findAll();
    }
    public  Adminmodel findByEmail(String email) {
        return prepo.findByEmail(email);
    }
}
