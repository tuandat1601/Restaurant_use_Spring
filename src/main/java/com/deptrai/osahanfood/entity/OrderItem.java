package com.deptrai.osahanfood.entity;

import java.sql.Date;

import com.deptrai.osahanfood.entity.keys.KeyOrderItem;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "order_item")
public class OrderItem {
	@EmbeddedId
	KeyOrderItem keyOrderItem;
	@ManyToOne
	@JoinColumn(name="order_id", insertable = false, updatable = false)
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name="food_id" , insertable = false, updatable = false)
	private Food foods;
	
	@Column(name = "create_date")
	private Date createDate;

	

	

	public KeyOrderItem getKeyOrderItem() {
		return keyOrderItem;
	}

	public void setKeyOrderItem(KeyOrderItem keyOrderItem) {
		this.keyOrderItem = keyOrderItem;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Food getFoods() {
		return foods;
	}

	public void setFoods(Food foods) {
		this.foods = foods;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
