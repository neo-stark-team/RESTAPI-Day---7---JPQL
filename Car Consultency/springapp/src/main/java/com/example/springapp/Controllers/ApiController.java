package com.example.springapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Models.Car;
import com.example.springapp.Services.ApiService;

@RestController
public class ApiController{
    
    @Autowired
    public ApiService apiService;

    @PostMapping("/")
    public boolean addCar(@RequestBody Car car){
        return apiService.addCar(car);
    }

    @GetMapping("/owners/{owners}")
    public List<Car> getCarsDetailsWithOwnersCount(@PathVariable int owners){
        return apiService.getCarsDetailsWithOwnersCount(owners);
    }

    @GetMapping("/address/{address}")
    public List<Car> getCarsDetailsWithOwnersCount(@PathVariable String address){
        return apiService.getCarsDetailsWithPlace(address);
    }

    @GetMapping("/carname/{carname}")
    public List<Car> getCarsDetailsWithCarName(@PathVariable String carname){
        return apiService.getCarsDetailsWithCarName(carname);
    }

    @GetMapping("/owners/{owners}/cartype/{cartype}")
    public List<Car> findCarsByOwnersAndCarType(@PathVariable int owners,@PathVariable String cartype){
        return apiService.findCarsByOwnersAndCarType(owners,cartype);
    }

}
