package com.carrental.backend.services.implementation;

import com.carrental.backend.form.CarForm;
import com.carrental.backend.model.Car;
import com.carrental.backend.repository.CarRepository;
import com.carrental.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carService")
@Transactional
public class CarImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getCarByFilter(CarForm form) {
        List<Car> carList = carRepository.getCarByFilter(form.getCondition(), form.getBrandName(), form.getYear(), form.getCarType(), form.getPrice1(), form.getPrice2());
        if(carList.size() > 0){
            return carList;
        }
        return null;
    }

    @Override
    public List<Car> getCarList() {
        return carRepository.findAll();
    }
}
