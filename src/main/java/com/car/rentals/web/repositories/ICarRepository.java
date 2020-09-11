package com.car.rentals.web.repositories;

import com.car.rentals.web.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends MongoRepository<Car,String> {

    // Create


    // Retrieve

    // Update

    // Delete


}
