package com.deptrai.osahanfood.entity;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;

	@Column(name="subtitle")
	private String subtitle;

	@Column(name="description")
	private String description;
	

	@Column(name="imgae")
	private String image;
	

	@Column(name="is_freeship")
	private boolean isFreeship;
	

	@Column(name="address")
	private String address;
	

	@Column(name="open_time")
	private Date openTime;

	
	@OneToMany(mappedBy = "restaurant")
	private Set<Ratingrestaurant> ratingRestaurantList;
	@OneToMany(mappedBy = "restaurant")
	private Set<Orders> orderList;
	@OneToMany(mappedBy = "restaurant")
	private Set<MenuRestaurant> menuRestaurantList;
	@OneToMany(mappedBy = "restaurant")
	private Set<Promo> promoList;
	
	
	public Set<Promo> getPromoList() {
		return promoList;
	}


	public void setPromoList(Set<Promo> promoList) {
		this.promoList = promoList;
	}


	public Set<MenuRestaurant> getMenuRestaurantList() {
		return menuRestaurantList;
	}


	public void setMenuRestaurantList(Set<MenuRestaurant> menuRestaurantList) {
		this.menuRestaurantList = menuRestaurantList;
	}


	public Set<Orders> getOrderList() {
		return orderList;
	}


	public void setOrderList(Set<Orders> orderList) {
		this.orderList = orderList;
	}


	public Set<Ratingrestaurant> getRatingRestaurantList() {
		return ratingRestaurantList;
	}


	public void setRatingRestaurantList(Set<Ratingrestaurant> ratingRestaurantList) {
		this.ratingRestaurantList = ratingRestaurantList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubtitle() {
		return subtitle;
	}


	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public boolean isFreeship() {
		return isFreeship;
	}


	public void setFreeship(boolean isFreeship) {
		this.isFreeship = isFreeship;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getOpenTime() {
		return openTime;
	}


	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	
}
