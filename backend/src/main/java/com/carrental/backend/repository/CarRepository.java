package com.carrental.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carrental.backend.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	@Query("select car from Car car "
            + "where car.id = :carID")
    Car getCarByID(
            @Param("carID") Long carID
    );
}
