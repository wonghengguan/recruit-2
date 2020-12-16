package com.carrental.backend.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cars")
public class Car extends Vehicle{
	
	@Column(name="numberOfDoors")
	private int numberOfDoors;

	@Column(name="carType")
	private String carType;

	@Column(name="registrationPlate")
	private String registrationPlate;
	
	public Car() {
		super();
	}
	
	public Car(String brandName, String modelName, double condition, double price, int year, int numberOfDoors, String carType) {
		super(brandName, modelName, condition, price, year);
		this.numberOfDoors = numberOfDoors;
		this.carType = carType;
	}
	
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getRegistrationPlate() {
		return registrationPlate;
	}

	public void setRegistrationPlate(String registrationPlate) {
		this.registrationPlate = registrationPlate;
	}

}
