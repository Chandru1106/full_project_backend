package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Plantmodel;
import com.example.demo.repository.Plantrepo;

@Service
public class Plantservice {
	@Autowired
	Plantrepo prepo;
	
	public Plantmodel saveDetails(Plantmodel e)
	{
		
	return prepo.save(e);
	}
    public List<Plantmodel> getDetails()
    {
    	return prepo.findAll();
    }
    public Plantmodel updateDetails(int id,Plantmodel s)
    {
    	Plantmodel modelx = prepo.findById(id).orElse(null);
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
