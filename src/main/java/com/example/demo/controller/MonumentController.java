package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Monument;
import com.example.demo.repository.MonumentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MonumentController{
	@Autowired
	private  MonumentRepository mr;
	

	 @GetMapping("/monument")
	public List<Monument> getUser(){
		List<Monument> monuments= new ArrayList<Monument>();
		for(Monument monument: mr.findAll())
			monuments.add(monument);
		return monuments;
		
	}
    @GetMapping("/monuments/{id}")
    public Optional<Monument> getuserById(@PathVariable(value = "id")  String ids)
    {
    	int Id=Integer.parseInt(ids);
        return mr.findById(Id);
        
          
    }
    
    @PostMapping("/monument")
    public Monument create( @RequestBody Monument m) {
    	return mr.save(m);
    /*   return "vous étes inscrit maintenant";*/
    	
    }
    
    @PutMapping("/monument/{id}")
    public ResponseEntity<Monument> updateMonument(@PathVariable(value = "id") int id,
            @RequestBody Monument MonumentDetails){
      	Optional<Monument> optionelEntity= mr.findById(id);
      	Monument monument= optionelEntity.get();
      	monument.setNom(MonumentDetails.getNom());
      	monument.setDescription(MonumentDetails.getDescription());
      	monument.setImg(MonumentDetails.getImg());
          final Monument updatedMonument = mr.save(monument);
          return ResponseEntity.ok(updatedMonument);
      }

    @DeleteMapping("/monument/{id}")
    public Map<String, Boolean> deleteMonument(@PathVariable(value = "id") int id) {
    	 mr.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
		return response;
        
    }
}