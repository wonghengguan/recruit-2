package com.carrental.backend.services;

import com.carrental.backend.form.CarForm;
import com.carrental.backend.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAvailableCarList();

    List<Car> getCarListByFilter(CarForm form);
}
