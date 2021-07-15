package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Monument")
public class Monument implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	int id;
	String nom,description,img;
	 @OneToMany(mappedBy = "monument",
		        cascade = CascadeType.ALL,
		        orphanRemoval=true)
		     Set<Comment> comment = new HashSet<>();
	 
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
		 for(Comment l : comment) {
	         l.setMonument(this);
		 }
	}
	public Monument(String nom, String description, String img) {
		super();
		this.nom = nom;
		this.description = description;
		this.img = img;
	}
	public Monument() {
		super();
	}
	@Override
	public String toString() {
		return "Monument [nom=" + nom + ", description=" + description + ", img=" + img + "]";
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getDescription() {
		return description;
	}
	public String getImg() {
		return img;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	}
