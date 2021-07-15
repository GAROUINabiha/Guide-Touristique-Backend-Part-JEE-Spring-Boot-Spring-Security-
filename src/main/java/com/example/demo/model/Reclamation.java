package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Reclamation")
public class Reclamation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	int id;
	Date date = new Date();
	String pseudo,message;
	public Reclamation(int id, Date date, String pseudo, String message) {
		super();
		this.id = id;
		this.date = new Date();
		this.pseudo = pseudo;
		this.message = message;
	}
	public Reclamation() {
		super();
	}
	public int getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getMessage() {
		return message;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", date=" + date + ", pseudo=" + pseudo + ", message=" + message + "]";
	}

}
