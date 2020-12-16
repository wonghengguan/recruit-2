package com.carrental.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carrental.backend.model.UserVehicle;

import java.util.List;

public interface UserVehicleRepository extends JpaRepository<UserVehicle, Long> {
	@Query("select userVehicle from UserVehicle userVehicle "
			+ "where userVehicle.id = :userVehicleId")
	UserVehicle getUserVehicleByID(
			@Param("userVehicleId") Long userVehicleId
	);

	@Query("select userVehicle from UserVehicle userVehicle "
			+ "where userVehicle.user.id = :userId")
	List<UserVehicle> getUserVehicleByUserID(
			@Param("userId") Long userId
	);

	@Query("select userVehicle from UserVehicle userVehicle "
			+ "where userVehicle.user.id = :userId "
			+ "and userVehicle.car.id = :carId "
	)
	UserVehicle getUserVehicleByUserIDAndCarID(
			@Param("userId") Long userId,
			@Param("carId") Long carId
	);
}
