package com.carrental.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carrental.backend.model.UserVehicle;

public interface UserVehicleRepository extends JpaRepository<UserVehicle, Long> {
	@Query("select userVehicle from UserVehicle userVehicle "
            + "where userVehicle.id = :userVehicleId")
	UserVehicle getUserVehicleByID(
            @Param("userVehicleId") Long userVehicleId
    );

}
