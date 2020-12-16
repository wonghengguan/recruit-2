package com.carrental.backend.controller;

import com.carrental.backend.form.UserVehicleForm;
import com.carrental.backend.model.Car;
import com.carrental.backend.model.UserVehicle;
import com.carrental.backend.response.CustomPageResponse;
import com.carrental.backend.services.UserVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/uservehicle")
public class UserVehicleController {

    @Autowired
    UserVehicleService userVehicleService;

    @RequestMapping(value="/getuservehiclelist", method = RequestMethod.POST)
    public List<UserVehicle> getUserVehicleList(@RequestBody UserVehicleForm form){
        List<UserVehicle> userVehicleList = userVehicleService.getUserVehicleByUserId(form);
        if(userVehicleList!=null) {
            return userVehicleList;
        }
        return null;
    }

    @RequestMapping(value="/returnvehicle", method = RequestMethod.POST)
    public List<UserVehicle> returnVehicle(@RequestBody UserVehicleForm form){
        return userVehicleService.returnVehicle(form);
    }

    @RequestMapping(value="/rentvehicle", method = RequestMethod.POST)
    public CustomPageResponse rentVehicle(@RequestBody UserVehicleForm form){
        CustomPageResponse response = new CustomPageResponse();

        List<Car> carList = userVehicleService.rentVehicle(form);
        List<Object> objectList = new ArrayList<Object>(carList);

        if(carList.size()>0)
        {
            response.setList(objectList);
            return response;
        }
        return null;
    }
}
