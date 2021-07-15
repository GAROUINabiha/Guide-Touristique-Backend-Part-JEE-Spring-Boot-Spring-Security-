package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Comment")
public class Comment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	int id;
	String message,pseudo;
	Date date = new Date();
@ManyToOne(fetch = FetchType.LAZY, optional = false)
 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
 public Monument monument;


public Comment() {
	super();
}




public Comment(int id, String message, String pseudo, Date date, Monument monument) {
	super();
	this.id = id;
	this.message = message;
	this.pseudo = pseudo;
	this.date = new Date();
	this.monument = monument;
}





public Comment(String message, String pseudo, Monument monument) {
	super();
	this.message = message;
	this.pseudo = pseudo;
	this.monument=monument;
}




@Override
public String toString() {
	return "Comment [id=" + id + ", message=" + message + ", pseudo=" + pseudo + ", date=" + date + "]";
}


public int getId() {
	return id;
}


public String getMessage() {
	return message;
}


public String getPseudo() {
	return pseudo;
}


public Date getDate() {
	return date;
}


public Monument getMonument() {
	return monument;
}


public void setId(int id) {
	this.id = id;
}


public void setMessage(String message) {
	this.message = message;
}


public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
}


public void setDate(Date date) {
	this.date = date;
}


public void setMonument(Monument monument) {
	this.monument = monument;
}


}
