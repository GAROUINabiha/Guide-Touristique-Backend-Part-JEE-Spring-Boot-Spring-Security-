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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtilistateurRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController{
	@Autowired
	private  UtilistateurRepository ur;
	
	public UtilisateurController(UtilistateurRepository ur) {
		super();
		this.ur = ur;
	}
	 @GetMapping("/utilisateur")
	public List<Utilisateur> getUser(){
		List<Utilisateur> users= new ArrayList<Utilisateur>();
		for(Utilisateur user: ur.findAll())
			users.add(user);
		return users;
		
	}
    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getuserById(@PathVariable(value = "id")  String idStr)
    {
    	int Id=Integer.parseInt(idStr);
        return ur.findById(Id);
        
          
    }
    
    @PostMapping("/utilisateur")
    public Utilisateur create( @RequestBody Utilisateur u) {
    	return ur.save(u);
    /*   return "vous étes inscrit maintenant";*/
    }
}