package com.car.rentals.web.services;


import com.car.rentals.web.models.Car;
import com.car.rentals.web.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    ICarRepository iCarRepository;


    //Create operation
    public String create(Car car) {
        iCarRepository.save(car);
        return "created";
    }


    //Retrieve Operation
    public List<Car> getAll(){
        return iCarRepository.findAll();
    }

    //Update Operation
    public String update(String ID, Car car){
        Optional<Car> tempCar = iCarRepository.findById(ID);
        if (tempCar.isPresent()){
            Car updateCar = tempCar.get();
            updateCar.setName(car.getName());
            iCarRepository.save(updateCar);
            return "car updated";
        }
        return "car not updated";
    }


    //Delete Operations
    public void deleteAll(){
        iCarRepository.deleteAll();
    }

    public void delete(String ID){
        Optional<Car> tempCar = iCarRepository.findById(ID);
        if (tempCar.isPresent()){
            Car car = tempCar.get();
            iCarRepository.delete(car);
        }
    }


}
