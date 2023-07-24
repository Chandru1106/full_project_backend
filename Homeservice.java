package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Homemodel;
import com.example.demo.repository.Homerepo;

@Service
public class Homeservice {
    @Autowired
    Homerepo prepo;

    public Homemodel saveDetails(Homemodel e) {
        return prepo.save(e);
    }

    public List<Homemodel> getDetails() {
        return prepo.findAll();
    }

    public Homemodel updateDetails(int id, Homemodel s) {
        Homemodel modelx = prepo.findById(id).orElse(null);
        if (modelx != null) {
            modelx.setName(s.getName());
            modelx.setPrice(s.getPrice());
            modelx.setDescription(s.getDescription());
            return prepo.saveAndFlush(modelx);
        } else {
            return null;
        }
    }

    public void deleteDetails1(int id) {
        prepo.deleteById(id);
    }

    // Method to handle image upload and update the image field in Homemodel
    public Homemodel uploadImage(int id, MultipartFile file) throws IOException {
        Homemodel modelx = prepo.findById(id).orElse(null);
        if (modelx != null && file != null) {
            modelx.setImage(file.getBytes());
            return prepo.saveAndFlush(modelx);
        } else {
            return null;
        }
    }
    public Homemodel updateImageUrl(int id, String imageUrl) {
        Homemodel modelx = prepo.findById(id).orElse(null);
        if (modelx != null && imageUrl != null) {
            modelx.setImageUrl(imageUrl);
            return prepo.saveAndFlush(modelx);
        } else {
            return null;
        }
    }
}
