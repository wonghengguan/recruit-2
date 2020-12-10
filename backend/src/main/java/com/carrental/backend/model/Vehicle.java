package com.carrental.backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="brandName")
	private String brandName;
	
	@Column(name="modelName")
	private String modelName;
	
	@Column(name="condition")
	private double condition;
	
	@Column(name="price")
	private double price;
	
	@Column(name="year")
	private int year;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String brandName, String modelName, double condition, double price, int year) {
		this.brandName = brandName;
		this.modelName = modelName;
		this.condition = condition;
		this.price = price;
		this.year = year;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public double getCondition() {
		return condition;
	}
	public void setCondition(double condition) {
		this.condition = condition;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
