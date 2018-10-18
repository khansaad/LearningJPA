package com.learning.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	private String rating;
	
	@ManyToOne
	private Course course;

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating, description); //"Student [id=" + id + ", name=" + name + "]";
	}

	public Review() {
		
	}

	public Review(String description, String rating) {
		this.description = description;
		this.rating=rating;
	}

	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
