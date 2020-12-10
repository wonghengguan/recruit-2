package com.carrental.backend.model;

import javax.persistence.*;

public class UserVehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "userID")
    @ManyToOne(cascade=CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    private User user;
	
	@JoinColumn(name = "vehicleID")
    @ManyToOne(cascade=CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    private Vehicle vehicle;
}
