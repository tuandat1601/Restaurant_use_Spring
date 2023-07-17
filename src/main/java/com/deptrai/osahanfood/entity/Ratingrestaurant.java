package com.deptrai.osahanfood.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="rating_restaurant")
public class Ratingrestaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	
	
	@ManyToOne
	@JoinColumn(name="res_id")
	private Restaurant restaurant;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "rate_point")
	private int ratePoint;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRatePoint() {
		return ratePoint;
	}

	public void setRatePoint(int ratePoint) {
		this.ratePoint = ratePoint;
	}
	
}
