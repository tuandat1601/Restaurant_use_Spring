package com.deptrai.osahanfood.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity(name="food")
public class Food {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "time_ship")
	private String timeShip;
	@Column(name = "price")
	private double price;
	@ManyToOne
	@JoinColumn(name="cate_id")
	private Category category;
	@OneToMany(mappedBy = "foods")
	private Set<OrderItem> listOrderItem;
	public Set<OrderItem> getListOrderItem() {
		return listOrderItem;
	}
	public void setListOrderItem(Set<OrderItem> listOrderItem) {
		this.listOrderItem = listOrderItem;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTimeShip() {
		return timeShip;
	}
	public void setTimeShip(String timeShip) {
		this.timeShip = timeShip;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@OneToMany(mappedBy = "foods")
	private Set<RatingFood> ratingFoodList;
	public Set<RatingFood> getRatingFoodList() {
		return ratingFoodList;
	}
	public void setRatingFoodList(Set<RatingFood> ratingFoodList) {
		this.ratingFoodList = ratingFoodList;
	}
	
	
}
