package com.car.rentals.web.services;

import com.car.rentals.web.models.Car;
import com.car.rentals.web.repositories.GenericRepository;
import com.car.rentals.web.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService extends GenericService<Car> {

    @Autowired
    ICarRepository iCarRepository;


    @Override
    public GenericRepository<Car> getRepository() {
        return this.iCarRepository;
    }
}
