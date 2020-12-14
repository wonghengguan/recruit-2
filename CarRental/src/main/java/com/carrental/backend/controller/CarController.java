package com.carrental.backend.controller;

import com.carrental.backend.form.CarForm;
import com.carrental.backend.model.Car;
import com.carrental.backend.response.CustomPageResponse;
import com.carrental.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/cars")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping(value="/getCarList", method = RequestMethod.POST)
    public CustomPageResponse getCarList(@RequestBody CarForm form) {
        CustomPageResponse response = new CustomPageResponse();

        List<Car> carList = carService.getCarList();
        List<Object> objectList = new ArrayList<Object>(carList);

        if(carList.size()>0)
        {
            response.setList(objectList);
            return response;
        }
        return null;
    }
}
