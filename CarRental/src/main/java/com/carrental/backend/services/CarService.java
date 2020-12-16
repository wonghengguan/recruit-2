package com.carrental.backend.services;

import com.carrental.backend.form.CarForm;
import com.carrental.backend.model.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    List<Car> getCarByFilter(CarForm form);

    List<Car> getCarList();

    List<Car> getAvailableCarList();
}
