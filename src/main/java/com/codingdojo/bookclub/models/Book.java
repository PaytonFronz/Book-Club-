package com.codingdojo.bookclub.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
    
@Entity
@Table(name="book")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotEmpty(message="Title is required!")
    @Size(min=3, max=50,message="Title must be between 3 and 50 characters.")
    private String title;
    
    @NotEmpty(message="Author is required!")
    private String author;
    
    private String posted_by;
    
    @NotEmpty(message="Please write your thoughts on the book below!")
    private String thoughts;
  
    public Book () {}
    
    public Book(String title, String author, String posted_by, String thoughts) {
    	this.title = title;
    	this.author = author;
    	this.thoughts = thoughts;
    }
    
    public Book(String title, String author, String posted_by, String thoughts, User user) {
    	this.title = title;
    	this.author = author;
    	this.thoughts = thoughts;
    	this.user = user;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}
}
