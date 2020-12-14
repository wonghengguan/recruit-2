package com.carrental.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carrental.backend.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select car from Car car "
            + "where car.id = :carID")
    Car getCarByID(
            @Param("carID") Long carID
    );

    @Query("select car from Car car "
            + "where car.brandName like :brandName")
    List<Car> getCarByBrandName(
            @Param("brandName") String brandName
    );

    @Query("select car from Car car "
            + "where car.condition = :condition")
    List<Car> getCarByCondition(
            @Param("condition") double condition
    );

    @Query("select car from Car car "
            + "where (car.condition >= :condition)"
            + "or car.brandName like :brandName "
            + "or car.year = :year "
            + "or car.carType like :carType "
            + "or (car.price >= :price1 and car.price <= :price2)"
    )
    List<Car> getCarByFilter(
            @Param("condition") double condition,
            @Param("brandName") String brandName,
            @Param("year") int year,
            @Param("carType") String carType,
            @Param("price1") double price1,
            @Param("price2") double price2
    );
}
