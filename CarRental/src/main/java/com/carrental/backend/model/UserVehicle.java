package com.carrental.backend.model;

import javax.persistence.*;

@Entity
@Table(name="userVehicles")
public class UserVehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JoinColumn(name = "userID")
    @ManyToOne(cascade=CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    private User user;
	
	@JoinColumn(name = "carID")
    @ManyToOne(cascade=CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    private Car car;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
