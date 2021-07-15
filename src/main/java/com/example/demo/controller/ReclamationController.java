package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.model.Monument;
import com.example.demo.model.Reclamation;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.ReclamationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ReclamationController {
@Autowired
private  ReclamationRepository rr;

public ReclamationController(ReclamationRepository rr) {
	super();
	this.rr = rr;
}
@GetMapping("/reclamation")
public List<Reclamation> getReclamation(){
	List<Reclamation> reclamations= new ArrayList<Reclamation>();
	for(Reclamation reclamation: rr.findAll())
		reclamations.add(reclamation);
	return reclamations;
	
}
@PostMapping("/reclamation")
public Reclamation create(@RequestBody Reclamation r) {
return rr.save(r);
}
}
