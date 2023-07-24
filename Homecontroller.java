package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Homemodel;
import com.example.demo.service.Homeservice;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class Homecontroller {
    @Autowired(required = true)
    Homeservice eser;

    @PostMapping("/addinhome")
    public Homemodel addDetails(@RequestBody Homemodel e) {
        return eser.saveDetails(e);
    }

    @GetMapping("/showhome")
    public List<Homemodel> fetchDetails() {
        return eser.getDetails();
    }

    @PutMapping("/updatinghome/{id}")
    public Homemodel updateInfo(@PathVariable int id, @RequestBody Homemodel s) {
        return eser.updateDetails(id, s);
    }

    @DeleteMapping("/deletehome/{id}")
    public String deleteInfo1(@PathVariable("id") int id) {
        eser.deleteDetails1(id);
        return "Details Deleted Successfully";
    }

    @PostMapping("/uploadImage/{id}")
    public String uploadImage(@PathVariable int id, @RequestParam("image") MultipartFile imageFile) {
        try {
            String fileName = id + "_" + imageFile.getOriginalFilename();
            String uploadDir = "/D://Project Images//Home Deals/"; // Replace with the actual directory path

            File file = new File(uploadDir, fileName);
            imageFile.transferTo(file);

            return "Image uploaded successfully!";
        } catch (IOException e) { 
            return "Error uploading the image: " + e.getMessage();
        }
    }
    @PostMapping("/updateImageUrl/{id}")
    public Homemodel updateImageUrl(@PathVariable int id, @RequestParam("imageUrl") String imageUrl) {
        Homemodel model = eser.updateImageUrl(id, imageUrl);
        return model;
    }

}
