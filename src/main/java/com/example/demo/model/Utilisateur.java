
package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	int id;
	String nom,prenom,pseudo,email,password;
	public Utilisateur(String nom, String prenom, String pseudo, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}
	public Utilisateur() {
		super();
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
}
