package com.carrental.backend.model;

public class Car extends Vehicle{
	private int numberOfDoors;
	private String carType;
	
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

}
