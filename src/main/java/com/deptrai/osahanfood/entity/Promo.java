package com.deptrai.osahanfood.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="promo")
public class Promo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;


@ManyToOne
@JoinColumn(name="res_id")
private Restaurant restaurant;
@Column(name = "percent")
private int percent;
@Column(name = "start_date")
private Date startDate;
@Column(name = "end_date")
private Date endDate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Restaurant getRestaurant() {
	return restaurant;
}
public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}
public int getPercent() {
	return percent;
}
public void setPercent(int percent) {
	this.percent = percent;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}


}
