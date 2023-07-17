package com.deptrai.osahanfood.entity;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	@Column(name = "fullname")
	private String fullName;

	@Column(name = "created_date")
	private Date created_date;
	
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Roles roles;
	
	@OneToMany(mappedBy = "users")
	private Set<RatingFood>  ratingFoodList;

	
	@OneToMany(mappedBy = "users")
	private Set<Ratingrestaurant> ratingRestaurantList;
	@OneToMany(mappedBy = "users")
	private Set<Orders> orderList;
	
	public Set<Orders> getOrderList() {
		return orderList;
	}



	public void setOrderList(Set<Orders> orderList) {
		this.orderList = orderList;
	}



	public Set<RatingFood> getRatingFoodList() {
		return ratingFoodList;
	}

	
	
	public Set<Ratingrestaurant> getRatingRestaurantList() {
		return ratingRestaurantList;
	}


	public void setRatingRestaurantList(Set<Ratingrestaurant> ratingRestaurantList) {
		this.ratingRestaurantList = ratingRestaurantList;
	}


	public void setRatingFoodList(Set<RatingFood> ratingFoodList) {
		this.ratingFoodList = ratingFoodList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Date getCreated_date() {
		return created_date;
	}


	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}


	public Roles getRoles() {
		return roles;
	}


	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	
}
