package com.carrental.backend.services;

import com.carrental.backend.form.UserVehicleForm;
import com.carrental.backend.model.Car;
import com.carrental.backend.model.UserVehicle;

import java.util.List;

public interface UserVehicleService {
    List<UserVehicle> getUserVehicleByUserId(UserVehicleForm form);
    List<UserVehicle> returnVehicle(UserVehicleForm form);
    List<Car> rentVehicle(UserVehicleForm form);
}
