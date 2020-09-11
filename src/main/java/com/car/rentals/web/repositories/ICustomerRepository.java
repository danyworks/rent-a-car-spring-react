package com.car.rentals.web.repositories;


import com.car.rentals.web.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer,String> {


}
