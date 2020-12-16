package com.carrental.backend.services.implementation;

import com.carrental.backend.form.UserVehicleForm;
import com.carrental.backend.model.Car;
import com.carrental.backend.model.User;
import com.carrental.backend.model.UserVehicle;
import com.carrental.backend.repository.CarRepository;
import com.carrental.backend.repository.UserRepository;
import com.carrental.backend.repository.UserVehicleRepository;
import com.carrental.backend.services.UserVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userVehicleService")
@Transactional
public class UserVehicleImpl implements UserVehicleService {

    @Autowired
    UserVehicleRepository userVehicleRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserVehicle> getUserVehicleByUserId(UserVehicleForm form) {
        List<UserVehicle> userVehicleList = userVehicleRepository.getUserVehicleByUserID(form.getUserId());

        if(userVehicleList.size() > 0) {
            return userVehicleList;
        }
        return null;
    }

    @Override
    public List<UserVehicle> returnVehicle(UserVehicleForm form) {

        UserVehicle userVehicle = userVehicleRepository.getUserVehicleByUserIDAndCarID(form.getUserId(), form.getCarId());
        if(userVehicle!=null) {
            userVehicleRepository.delete(userVehicle);
        }
        Car car = carRepository.getCarByID(form.getCarId());
        if(car!=null) {
            car.setAvailable(true);
            carRepository.save(car);
        }

        return userVehicleRepository.getUserVehicleByUserID(form.getUserId());

    }

    @Override
    public List<Car> rentVehicle(UserVehicleForm form) {
        UserVehicle userVehicle = new UserVehicle();
        User user = userRepository.getUserByID(form.getUserId());
        Car car = carRepository.getCarByID(form.getCarId());
        if(user!=null && car!=null){
            car.setAvailable(false);
            userVehicle.setUser(user);
            userVehicle.setCar(car);
            carRepository.save(car);
            userVehicleRepository.save(userVehicle);
        }
        return carRepository.getCarByAvailability(true);
    }

}
