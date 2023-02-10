package com.example.springapp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.Models.Car;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer>{

    public List<Car> findByOwners(Integer owners);
    public List<Car> findByAddress(String address);
    public List<Car> findByCarName(String carName);
    public List<Car> findByCarType(String carType);

    @Query(value = "SELECT * FROM Car u WHERE u.owners = ?1 and u.car_type = ?2", nativeQuery = true)
    public List<Car> findCarsByOwnersAndCarType(Integer owners,String carType);

}