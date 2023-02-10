package com.example.springapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.Models.Car;
import com.example.springapp.Repositories.CarRepo;

@Service
public class ApiService {

    @Autowired
    public CarRepo carRepo;

    public boolean addCar(Car car){
        return carRepo.save(car) != null ? true : false;
    }

    public List<Car> getCarsDetailsWithOwnersCount(int owners){
        return carRepo.findByOwners(owners);
    }

    public List<Car> getCarsDetailsWithPlace(String address){
        return carRepo.findByAddress(address);
    }

    public List<Car> getCarsDetailsWithCarName(String carName){
        return carRepo.findByCarName(carName);
    }

    public List<Car> getCarsDetailsWithCarType(String carType){
        return carRepo.findByCarType(carType);
    }

    public List<Car> findCarsByOwnersAndCarType(int owners,String carType){
        return carRepo.findCarsByOwnersAndCarType(owners,carType);
    }

}
