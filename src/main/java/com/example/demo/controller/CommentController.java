package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Comment;
import com.example.demo.model.Monument;
import com.example.demo.model.Utilisateur;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MonumentRepository;
import com.example.demo.repository.UtilistateurRepository;
import com.fasterxml.jackson.databind.node.TextNode;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CommentController{
	@Autowired
	
	private  CommentRepository cr;
	private  MonumentRepository mr;
	
	 public CommentController(CommentRepository cr, MonumentRepository mr) {
		super();
		this.cr = cr;
		this.mr = mr;
	}
	@GetMapping("/comment")
	public List<Comment> getComment(){
		List<Comment> comments= new ArrayList<Comment>();
		for(Comment comment: cr.findAll())
			comments.add(comment);
		return comments;
		
	}
    @GetMapping("/comment/{id}")
    public Optional<Comment> getCommentById(@PathVariable(value = "id")  String idc)
    {
    	int Id=Integer.parseInt(idc);
        return cr.findById(Id);
        
          
    }
    @PostMapping("/comment/{monument}/{pseudo}/{message}")
    public Comment create(@PathVariable(value = "message") String message,@PathVariable(value = "pseudo") String pseudo, @PathVariable(value = "monument") Monument monument) {
    Comment co=new Comment(message,pseudo,monument);
    return cr.save(co);
    }
    @DeleteMapping("/comment/{id}")
	 public String deletecomment(@PathVariable(value = "id") int id) {
		Optional<Monument> m = mr.findById(id);
    	Optional<Comment> c = cr.findById(id);
    	Comment cm=c.get();
    	Monument mm = m.get();
    	mm.getId();
    	cm.getId();
    	cr.delete(cm);
    return "comment suprimée!";
	}
 
        
    }
