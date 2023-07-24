package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Toolmodel;
import com.example.demo.repository.Toolrepo;

@Service
public class Toolservice {
	@Autowired
	Toolrepo prepo;
	
	public Toolmodel saveDetails(Toolmodel e)
	{
		
	return prepo.save(e);
	}
    public List<Toolmodel> getDetails()
    {
    	return prepo.findAll();
    }
    public Toolmodel updateDetails(int id,Toolmodel s)
    {
    	Toolmodel modelx = prepo.findById(id).orElse(null);
		if(modelx !=null) {
		
			modelx.setPname(s.getPname());
			modelx.setPrice(s.getPrice());
			
			return prepo.saveAndFlush(modelx);
		}
		else {
			return null;
		}	
    }
    public void deleteDetails1(int id)
    {
    	prepo.deleteById(id);
    }
}
